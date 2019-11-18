package org.yaml.snakeyaml.emitter;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions$Version;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.CollectionEndEvent;
import org.yaml.snakeyaml.events.CollectionStartEvent;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.NodeEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.scanner.Constant;
import org.yaml.snakeyaml.util.ArrayStack;

public final class Emitter implements Emitable {
   private static final Map ESCAPE_REPLACEMENTS = new HashMap();
   public static final int MIN_INDENT = 1;
   public static final int MAX_INDENT = 10;
   private static final char[] SPACE = new char[]{' '};
   private static final Map DEFAULT_TAG_PREFIXES;
   private final Writer stream;
   private final ArrayStack states;
   private EmitterState state;
   private final Queue events;
   private Event event;
   private final ArrayStack indents;
   private Integer indent;
   private int flowLevel;
   private boolean rootContext;
   private boolean mappingContext;
   private boolean simpleKeyContext;
   private int column;
   private boolean whitespace;
   private boolean indention;
   private boolean openEnded;
   private Boolean canonical;
   private Boolean prettyFlow;
   private boolean allowUnicode;
   private int bestIndent;
   private int indicatorIndent;
   private int bestWidth;
   private char[] bestLineBreak;
   private boolean splitLines;
   private Map tagPrefixes;
   private String preparedAnchor;
   private String preparedTag;
   private ScalarAnalysis analysis;
   private Character style;
   private static final Pattern HANDLE_FORMAT;
   private static final Pattern ANCHOR_FORMAT;

   public Emitter(Writer stream, DumperOptions opts) {
      this.stream = stream;
      this.states = new ArrayStack(100);
      this.state = new Emitter$ExpectStreamStart(this, (Emitter$1)null);
      this.events = new ArrayBlockingQueue(100);
      this.event = null;
      this.indents = new ArrayStack(10);
      this.indent = null;
      this.flowLevel = 0;
      this.mappingContext = false;
      this.simpleKeyContext = false;
      this.column = 0;
      this.whitespace = true;
      this.indention = true;
      this.openEnded = false;
      this.canonical = opts.isCanonical();
      this.prettyFlow = opts.isPrettyFlow();
      this.allowUnicode = opts.isAllowUnicode();
      this.bestIndent = 2;
      if (opts.getIndent() > 1 && opts.getIndent() < 10) {
         this.bestIndent = opts.getIndent();
      }

      this.indicatorIndent = opts.getIndicatorIndent();
      this.bestWidth = 80;
      if (opts.getWidth() > this.bestIndent * 2) {
         this.bestWidth = opts.getWidth();
      }

      this.bestLineBreak = opts.getLineBreak().getString().toCharArray();
      this.splitLines = opts.getSplitLines();
      this.tagPrefixes = new LinkedHashMap();
      this.preparedAnchor = null;
      this.preparedTag = null;
      this.analysis = null;
      this.style = null;
   }

   public void emit(Event event) throws IOException {
      this.events.add(event);

      while(!this.needMoreEvents()) {
         this.event = (Event)this.events.poll();
         this.state.expect();
         this.event = null;
      }

   }

   private boolean needMoreEvents() {
      if (this.events.isEmpty()) {
         return true;
      } else {
         Event event = (Event)this.events.peek();
         if (event instanceof DocumentStartEvent) {
            return this.needEvents(1);
         } else if (event instanceof SequenceStartEvent) {
            return this.needEvents(2);
         } else {
            return event instanceof MappingStartEvent ? this.needEvents(3) : false;
         }
      }
   }

   private boolean needEvents(int count) {
      int level = 0;
      Iterator iter = this.events.iterator();
      iter.next();

      do {
         if (!iter.hasNext()) {
            return this.events.size() < count + 1;
         }

         Event event = (Event)iter.next();
         if (!(event instanceof DocumentStartEvent) && !(event instanceof CollectionStartEvent)) {
            if (!(event instanceof DocumentEndEvent) && !(event instanceof CollectionEndEvent)) {
               if (event instanceof StreamEndEvent) {
                  level = -1;
               }
            } else {
               --level;
            }
         } else {
            ++level;
         }
      } while(level >= 0);

      return false;
   }

   private void increaseIndent(boolean flow, boolean indentless) {
      this.indents.push(this.indent);
      if (this.indent == null) {
         if (flow) {
            this.indent = this.bestIndent;
         } else {
            this.indent = 0;
         }
      } else if (!indentless) {
         this.indent = this.indent + this.bestIndent;
      }

   }

   private void expectNode(boolean root, boolean mapping, boolean simpleKey) throws IOException {
      this.rootContext = root;
      this.mappingContext = mapping;
      this.simpleKeyContext = simpleKey;
      if (this.event instanceof AliasEvent) {
         this.expectAlias();
      } else {
         if (!(this.event instanceof ScalarEvent) && !(this.event instanceof CollectionStartEvent)) {
            throw new EmitterException("expected NodeEvent, but got " + this.event);
         }

         this.processAnchor("&");
         this.processTag();
         if (this.event instanceof ScalarEvent) {
            this.expectScalar();
         } else if (this.event instanceof SequenceStartEvent) {
            if (this.flowLevel == 0 && !this.canonical && !((SequenceStartEvent)this.event).getFlowStyle() && !this.checkEmptySequence()) {
               this.expectBlockSequence();
            } else {
               this.expectFlowSequence();
            }
         } else if (this.flowLevel == 0 && !this.canonical && !((MappingStartEvent)this.event).getFlowStyle() && !this.checkEmptyMapping()) {
            this.expectBlockMapping();
         } else {
            this.expectFlowMapping();
         }
      }

   }

   private void expectAlias() throws IOException {
      if (((NodeEvent)this.event).getAnchor() == null) {
         throw new EmitterException("anchor is not specified for alias");
      } else {
         this.processAnchor("*");
         this.state = (EmitterState)this.states.pop();
      }
   }

   private void expectScalar() throws IOException {
      this.increaseIndent(true, false);
      this.processScalar();
      this.indent = (Integer)this.indents.pop();
      this.state = (EmitterState)this.states.pop();
   }

   private void expectFlowSequence() throws IOException {
      this.writeIndicator("[", true, true, false);
      ++this.flowLevel;
      this.increaseIndent(true, false);
      if (this.prettyFlow) {
         this.writeIndent();
      }

      this.state = new Emitter$ExpectFirstFlowSequenceItem(this, (Emitter$1)null);
   }

   private void expectFlowMapping() throws IOException {
      this.writeIndicator("{", true, true, false);
      ++this.flowLevel;
      this.increaseIndent(true, false);
      if (this.prettyFlow) {
         this.writeIndent();
      }

      this.state = new Emitter$ExpectFirstFlowMappingKey(this, (Emitter$1)null);
   }

   private void expectBlockSequence() throws IOException {
      boolean indentless = this.mappingContext && !this.indention;
      this.increaseIndent(false, indentless);
      this.state = new Emitter$ExpectFirstBlockSequenceItem(this, (Emitter$1)null);
   }

   private void expectBlockMapping() throws IOException {
      this.increaseIndent(false, false);
      this.state = new Emitter$ExpectFirstBlockMappingKey(this, (Emitter$1)null);
   }

   private boolean checkEmptySequence() {
      return this.event instanceof SequenceStartEvent && !this.events.isEmpty() && this.events.peek() instanceof SequenceEndEvent;
   }

   private boolean checkEmptyMapping() {
      return this.event instanceof MappingStartEvent && !this.events.isEmpty() && this.events.peek() instanceof MappingEndEvent;
   }

   private boolean checkEmptyDocument() {
      if (this.event instanceof DocumentStartEvent && !this.events.isEmpty()) {
         Event event = (Event)this.events.peek();
         if (!(event instanceof ScalarEvent)) {
            return false;
         } else {
            ScalarEvent e = (ScalarEvent)event;
            return e.getAnchor() == null && e.getTag() == null && e.getImplicit() != null && e.getValue().length() == 0;
         }
      } else {
         return false;
      }
   }

   private boolean checkSimpleKey() {
      int length = 0;
      if (this.event instanceof NodeEvent && ((NodeEvent)this.event).getAnchor() != null) {
         if (this.preparedAnchor == null) {
            this.preparedAnchor = prepareAnchor(((NodeEvent)this.event).getAnchor());
         }

         length += this.preparedAnchor.length();
      }

      String tag = null;
      if (this.event instanceof ScalarEvent) {
         tag = ((ScalarEvent)this.event).getTag();
      } else if (this.event instanceof CollectionStartEvent) {
         tag = ((CollectionStartEvent)this.event).getTag();
      }

      if (tag != null) {
         if (this.preparedTag == null) {
            this.preparedTag = this.prepareTag(tag);
         }

         length += this.preparedTag.length();
      }

      if (this.event instanceof ScalarEvent) {
         if (this.analysis == null) {
            this.analysis = this.analyzeScalar(((ScalarEvent)this.event).getValue());
         }

         length += this.analysis.scalar.length();
      }

      return length < 128 && (this.event instanceof AliasEvent || this.event instanceof ScalarEvent && !this.analysis.empty && !this.analysis.multiline || this.checkEmptySequence() || this.checkEmptyMapping());
   }

   private void processAnchor(String indicator) throws IOException {
      NodeEvent ev = (NodeEvent)this.event;
      if (ev.getAnchor() == null) {
         this.preparedAnchor = null;
      } else {
         if (this.preparedAnchor == null) {
            this.preparedAnchor = prepareAnchor(ev.getAnchor());
         }

         this.writeIndicator(indicator + this.preparedAnchor, true, false, false);
         this.preparedAnchor = null;
      }
   }

   private void processTag() throws IOException {
      String tag = null;
      if (this.event instanceof ScalarEvent) {
         ScalarEvent ev = (ScalarEvent)this.event;
         tag = ev.getTag();
         if (this.style == null) {
            this.style = this.chooseScalarStyle();
         }

         if ((!this.canonical || tag == null) && (this.style == null && ev.getImplicit().canOmitTagInPlainScalar() || this.style != null && ev.getImplicit().canOmitTagInNonPlainScalar())) {
            this.preparedTag = null;
            return;
         }

         if (ev.getImplicit().canOmitTagInPlainScalar() && tag == null) {
            tag = "!";
            this.preparedTag = null;
         }
      } else {
         CollectionStartEvent ev = (CollectionStartEvent)this.event;
         tag = ev.getTag();
         if ((!this.canonical || tag == null) && ev.getImplicit()) {
            this.preparedTag = null;
            return;
         }
      }

      if (tag == null) {
         throw new EmitterException("tag is not specified");
      } else {
         if (this.preparedTag == null) {
            this.preparedTag = this.prepareTag(tag);
         }

         this.writeIndicator(this.preparedTag, true, false, false);
         this.preparedTag = null;
      }
   }

   private Character chooseScalarStyle() {
      ScalarEvent ev = (ScalarEvent)this.event;
      if (this.analysis == null) {
         this.analysis = this.analyzeScalar(ev.getValue());
      }

      if ((ev.getStyle() == null || ev.getStyle() != '"') && !this.canonical) {
         if (ev.getStyle() != null || !ev.getImplicit().canOmitTagInPlainScalar() || this.simpleKeyContext && (this.analysis.empty || this.analysis.multiline) || (this.flowLevel == 0 || !this.analysis.allowFlowPlain) && (this.flowLevel != 0 || !this.analysis.allowBlockPlain)) {
            if (ev.getStyle() != null && (ev.getStyle() == '|' || ev.getStyle() == '>') && this.flowLevel == 0 && !this.simpleKeyContext && this.analysis.allowBlock) {
               return ev.getStyle();
            } else {
               return ev.getStyle() != null && ev.getStyle() != '\'' || !this.analysis.allowSingleQuoted || this.simpleKeyContext && this.analysis.multiline ? '"' : '\'';
            }
         } else {
            return null;
         }
      } else {
         return '"';
      }
   }

   private void processScalar() throws IOException {
      ScalarEvent ev = (ScalarEvent)this.event;
      if (this.analysis == null) {
         this.analysis = this.analyzeScalar(ev.getValue());
      }

      if (this.style == null) {
         this.style = this.chooseScalarStyle();
      }

      boolean split = !this.simpleKeyContext && this.splitLines;
      if (this.style == null) {
         this.writePlain(this.analysis.scalar, split);
      } else {
         switch(this.style) {
         case '"':
            this.writeDoubleQuoted(this.analysis.scalar, split);
            break;
         case '\'':
            this.writeSingleQuoted(this.analysis.scalar, split);
            break;
         case '>':
            this.writeFolded(this.analysis.scalar, split);
            break;
         case '|':
            this.writeLiteral(this.analysis.scalar);
            break;
         default:
            throw new YAMLException("Unexpected style: " + this.style);
         }
      }

      this.analysis = null;
      this.style = null;
   }

   private String prepareVersion(DumperOptions$Version version) {
      if (version.major() != 1) {
         throw new EmitterException("unsupported YAML version: " + version);
      } else {
         return version.getRepresentation();
      }
   }

   private String prepareTagHandle(String handle) {
      if (handle.length() == 0) {
         throw new EmitterException("tag handle must not be empty");
      } else if (handle.charAt(0) == '!' && handle.charAt(handle.length() - 1) == '!') {
         if (!"!".equals(handle) && !HANDLE_FORMAT.matcher(handle).matches()) {
            throw new EmitterException("invalid character in the tag handle: " + handle);
         } else {
            return handle;
         }
      } else {
         throw new EmitterException("tag handle must start and end with '!': " + handle);
      }
   }

   private String prepareTagPrefix(String prefix) {
      if (prefix.length() == 0) {
         throw new EmitterException("tag prefix must not be empty");
      } else {
         StringBuilder chunks = new StringBuilder();
         int start = 0;
         int end = 0;
         if (prefix.charAt(0) == '!') {
            end = 1;
         }

         while(end < prefix.length()) {
            ++end;
         }

         if (start < end) {
            chunks.append(prefix.substring(start, end));
         }

         return chunks.toString();
      }
   }

   private String prepareTag(String tag) {
      if (tag.length() == 0) {
         throw new EmitterException("tag must not be empty");
      } else if ("!".equals(tag)) {
         return tag;
      } else {
         String handle = null;
         String suffix = tag;
         Iterator var4 = this.tagPrefixes.keySet().iterator();

         while(true) {
            String suffixText;
            do {
               do {
                  if (!var4.hasNext()) {
                     if (handle != null) {
                        suffix = tag.substring(handle.length());
                        handle = (String)this.tagPrefixes.get(handle);
                     }

                     int end = suffix.length();
                     suffixText = end > 0 ? suffix.substring(0, end) : "";
                     if (handle != null) {
                        return handle + suffixText;
                     }

                     return "!<" + suffixText + ">";
                  }

                  suffixText = (String)var4.next();
               } while(!tag.startsWith(suffixText));
            } while(!"!".equals(suffixText) && suffixText.length() >= tag.length());

            handle = suffixText;
         }
      }
   }

   static String prepareAnchor(String anchor) {
      if (anchor.length() == 0) {
         throw new EmitterException("anchor must not be empty");
      } else if (!ANCHOR_FORMAT.matcher(anchor).matches()) {
         throw new EmitterException("invalid character in the anchor: " + anchor);
      } else {
         return anchor;
      }
   }

   private ScalarAnalysis analyzeScalar(String scalar) {
      if (scalar.length() == 0) {
         return new ScalarAnalysis(scalar, true, false, false, true, true, false);
      } else {
         boolean blockIndicators = false;
         boolean flowIndicators = false;
         boolean lineBreaks = false;
         boolean specialCharacters = false;
         boolean leadingSpace = false;
         boolean leadingBreak = false;
         boolean trailingSpace = false;
         boolean trailingBreak = false;
         boolean breakSpace = false;
         boolean spaceBreak = false;
         if (scalar.startsWith("---") || scalar.startsWith("...")) {
            blockIndicators = true;
            flowIndicators = true;
         }

         boolean preceededByWhitespace = true;
         boolean followedByWhitespace = scalar.length() == 1 || Constant.NULL_BL_T_LINEBR.has(scalar.codePointAt(1));
         boolean previousSpace = false;
         boolean previousBreak = false;
         int index = 0;

         while(true) {
            boolean isLineBreak;
            int nextIndex;
            do {
               do {
                  if (index >= scalar.length()) {
                     boolean allowFlowPlain = true;
                     isLineBreak = true;
                     boolean allowSingleQuoted = true;
                     boolean allowBlock = true;
                     if (leadingSpace || leadingBreak || trailingSpace || trailingBreak) {
                        isLineBreak = false;
                        allowFlowPlain = false;
                     }

                     if (trailingSpace) {
                        allowBlock = false;
                     }

                     if (breakSpace) {
                        allowSingleQuoted = false;
                        isLineBreak = false;
                        allowFlowPlain = false;
                     }

                     if (spaceBreak || specialCharacters) {
                        allowBlock = false;
                        allowSingleQuoted = false;
                        isLineBreak = false;
                        allowFlowPlain = false;
                     }

                     if (lineBreaks) {
                        allowFlowPlain = false;
                     }

                     if (flowIndicators) {
                        allowFlowPlain = false;
                     }

                     if (blockIndicators) {
                        isLineBreak = false;
                     }

                     return new ScalarAnalysis(scalar, false, lineBreaks, allowFlowPlain, isLineBreak, allowSingleQuoted, allowBlock);
                  }

                  int c = scalar.codePointAt(index);
                  if (index == 0) {
                     if ("#,[]{}&*!|>'\"%@`".indexOf(c) != -1) {
                        flowIndicators = true;
                        blockIndicators = true;
                     }

                     if (c == 63 || c == 58) {
                        flowIndicators = true;
                        if (followedByWhitespace) {
                           blockIndicators = true;
                        }
                     }

                     if (c == 45 && followedByWhitespace) {
                        flowIndicators = true;
                        blockIndicators = true;
                     }
                  } else {
                     if (",?[]{}".indexOf(c) != -1) {
                        flowIndicators = true;
                     }

                     if (c == 58) {
                        flowIndicators = true;
                        if (followedByWhitespace) {
                           blockIndicators = true;
                        }
                     }

                     if (c == 35 && preceededByWhitespace) {
                        flowIndicators = true;
                        blockIndicators = true;
                     }
                  }

                  isLineBreak = Constant.LINEBR.has(c);
                  if (isLineBreak) {
                     lineBreaks = true;
                  }

                  if (c != 10 && (32 > c || c > 126)) {
                     if (c != 133 && (c < 160 || c > 55295) && (c < 57344 || c > 65533) && (c < 65536 || c > 1114111)) {
                        specialCharacters = true;
                     } else if (!this.allowUnicode) {
                        specialCharacters = true;
                     }
                  }

                  if (c == 32) {
                     if (index == 0) {
                        leadingSpace = true;
                     }

                     if (index == scalar.length() - 1) {
                        trailingSpace = true;
                     }

                     if (previousBreak) {
                        breakSpace = true;
                     }

                     previousSpace = true;
                     previousBreak = false;
                  } else if (isLineBreak) {
                     if (index == 0) {
                        leadingBreak = true;
                     }

                     if (index == scalar.length() - 1) {
                        trailingBreak = true;
                     }

                     if (previousSpace) {
                        spaceBreak = true;
                     }

                     previousSpace = false;
                     previousBreak = true;
                  } else {
                     previousSpace = false;
                     previousBreak = false;
                  }

                  index += Character.charCount(c);
                  preceededByWhitespace = Constant.NULL_BL_T.has(c) || isLineBreak;
                  followedByWhitespace = true;
               } while(index + 1 >= scalar.length());

               nextIndex = index + Character.charCount(scalar.codePointAt(index));
            } while(nextIndex >= scalar.length());

            followedByWhitespace = Constant.NULL_BL_T.has(scalar.codePointAt(nextIndex)) || isLineBreak;
         }
      }
   }

   void flushStream() throws IOException {
      this.stream.flush();
   }

   void writeStreamStart() {
   }

   void writeStreamEnd() throws IOException {
      this.flushStream();
   }

   void writeIndicator(String indicator, boolean needWhitespace, boolean whitespace, boolean indentation) throws IOException {
      if (!this.whitespace && needWhitespace) {
         ++this.column;
         this.stream.write(SPACE);
      }

      this.whitespace = whitespace;
      this.indention = this.indention && indentation;
      this.column += indicator.length();
      this.openEnded = false;
      this.stream.write(indicator);
   }

   void writeIndent() throws IOException {
      int indent;
      if (this.indent != null) {
         indent = this.indent;
      } else {
         indent = 0;
      }

      if (!this.indention || this.column > indent || this.column == indent && !this.whitespace) {
         this.writeLineBreak((String)null);
      }

      this.writeWhitespace(indent - this.column);
   }

   private void writeWhitespace(int length) throws IOException {
      if (length > 0) {
         this.whitespace = true;
         char[] data = new char[length];

         for(int i = 0; i < data.length; ++i) {
            data[i] = ' ';
         }

         this.column += length;
         this.stream.write(data);
      }
   }

   private void writeLineBreak(String data) throws IOException {
      this.whitespace = true;
      this.indention = true;
      this.column = 0;
      if (data == null) {
         this.stream.write(this.bestLineBreak);
      } else {
         this.stream.write(data);
      }

   }

   void writeVersionDirective(String versionText) throws IOException {
      this.stream.write("%YAML ");
      this.stream.write(versionText);
      this.writeLineBreak((String)null);
   }

   void writeTagDirective(String handleText, String prefixText) throws IOException {
      this.stream.write("%TAG ");
      this.stream.write(handleText);
      this.stream.write(SPACE);
      this.stream.write(prefixText);
      this.writeLineBreak((String)null);
   }

   private void writeSingleQuoted(String text, boolean split) throws IOException {
      this.writeIndicator("'", true, false, false);
      boolean spaces = false;
      boolean breaks = false;
      int start = 0;

      for(int end = 0; end <= text.length(); ++end) {
         char ch = 0;
         if (end < text.length()) {
            ch = text.charAt(end);
         }

         int len;
         if (spaces) {
            if (ch == 0 || ch != ' ') {
               if (start + 1 == end && this.column > this.bestWidth && split && start != 0 && end != text.length()) {
                  this.writeIndent();
               } else {
                  len = end - start;
                  this.column += len;
                  this.stream.write(text, start, len);
               }

               start = end;
            }
         } else if (!breaks) {
            if (Constant.LINEBR.has(ch, "\u0000 '") && start < end) {
               len = end - start;
               this.column += len;
               this.stream.write(text, start, len);
               start = end;
            }
         } else if (ch == 0 || Constant.LINEBR.hasNo(ch)) {
            if (text.charAt(start) == '\n') {
               this.writeLineBreak((String)null);
            }

            String data = text.substring(start, end);
            char[] var9 = data.toCharArray();
            int var10 = var9.length;

            for(int var11 = 0; var11 < var10; ++var11) {
               char br = var9[var11];
               if (br == '\n') {
                  this.writeLineBreak((String)null);
               } else {
                  this.writeLineBreak(String.valueOf(br));
               }
            }

            this.writeIndent();
            start = end;
         }

         if (ch == '\'') {
            this.column += 2;
            this.stream.write("''");
            start = end + 1;
         }

         if (ch != 0) {
            spaces = ch == ' ';
            breaks = Constant.LINEBR.has(ch);
         }
      }

      this.writeIndicator("'", false, false, false);
   }

   private void writeDoubleQuoted(String text, boolean split) throws IOException {
      this.writeIndicator("\"", true, false, false);
      int start = 0;

      for(int end = 0; end <= text.length(); ++end) {
         Character ch = null;
         if (end < text.length()) {
            ch = text.charAt(end);
         }

         String data;
         if (ch == null || "\"\\\u0085\u2028\u2029\ufeff".indexOf(ch) != -1 || ' ' > ch || ch > '~') {
            if (start < end) {
               int len = end - start;
               this.column += len;
               this.stream.write(text, start, len);
               start = end;
            }

            if (ch != null) {
               if (ESCAPE_REPLACEMENTS.containsKey(ch)) {
                  data = "\\" + (String)ESCAPE_REPLACEMENTS.get(ch);
               } else if (this.allowUnicode && StreamReader.isPrintable(ch)) {
                  data = String.valueOf(ch);
               } else {
                  String s;
                  if (ch <= 255) {
                     s = "0" + Integer.toString(ch, 16);
                     data = "\\x" + s.substring(s.length() - 2);
                  } else if (ch >= '\ud800' && ch <= '\udbff') {
                     if (end + 1 < text.length()) {
                        ++end;
                        Character ch2 = text.charAt(end);
                        String s = "000" + Long.toHexString((long)Character.toCodePoint(ch, ch2));
                        data = "\\U" + s.substring(s.length() - 8);
                     } else {
                        s = "000" + Integer.toString(ch, 16);
                        data = "\\u" + s.substring(s.length() - 4);
                     }
                  } else {
                     s = "000" + Integer.toString(ch, 16);
                     data = "\\u" + s.substring(s.length() - 4);
                  }
               }

               this.column += data.length();
               this.stream.write(data);
               start = end + 1;
            }
         }

         if (0 < end && end < text.length() - 1 && (ch == ' ' || start >= end) && this.column + (end - start) > this.bestWidth && split) {
            if (start >= end) {
               data = "\\";
            } else {
               data = text.substring(start, end) + "\\";
            }

            if (start < end) {
               start = end;
            }

            this.column += data.length();
            this.stream.write(data);
            this.writeIndent();
            this.whitespace = false;
            this.indention = false;
            if (text.charAt(start) == ' ') {
               data = "\\";
               this.column += data.length();
               this.stream.write(data);
            }
         }
      }

      this.writeIndicator("\"", false, false, false);
   }

   private String determineBlockHints(String text) {
      StringBuilder hints = new StringBuilder();
      if (Constant.LINEBR.has(text.charAt(0), " ")) {
         hints.append(this.bestIndent);
      }

      char ch1 = text.charAt(text.length() - 1);
      if (Constant.LINEBR.hasNo(ch1)) {
         hints.append("-");
      } else if (text.length() == 1 || Constant.LINEBR.has(text.charAt(text.length() - 2))) {
         hints.append("+");
      }

      return hints.toString();
   }

   void writeFolded(String text, boolean split) throws IOException {
      String hints = this.determineBlockHints(text);
      this.writeIndicator(">" + hints, true, false, false);
      if (hints.length() > 0 && hints.charAt(hints.length() - 1) == '+') {
         this.openEnded = true;
      }

      this.writeLineBreak((String)null);
      boolean leadingSpace = true;
      boolean spaces = false;
      boolean breaks = true;
      int start = 0;

      for(int end = 0; end <= text.length(); ++end) {
         char ch = 0;
         if (end < text.length()) {
            ch = text.charAt(end);
         }

         if (breaks) {
            if (ch == 0 || Constant.LINEBR.hasNo(ch)) {
               if (!leadingSpace && ch != 0 && ch != ' ' && text.charAt(start) == '\n') {
                  this.writeLineBreak((String)null);
               }

               leadingSpace = ch == ' ';
               String data = text.substring(start, end);
               char[] var11 = data.toCharArray();
               int var12 = var11.length;

               for(int var13 = 0; var13 < var12; ++var13) {
                  char br = var11[var13];
                  if (br == '\n') {
                     this.writeLineBreak((String)null);
                  } else {
                     this.writeLineBreak(String.valueOf(br));
                  }
               }

               if (ch != 0) {
                  this.writeIndent();
               }

               start = end;
            }
         } else {
            int len;
            if (spaces) {
               if (ch != ' ') {
                  if (start + 1 == end && this.column > this.bestWidth && split) {
                     this.writeIndent();
                  } else {
                     len = end - start;
                     this.column += len;
                     this.stream.write(text, start, len);
                  }

                  start = end;
               }
            } else if (Constant.LINEBR.has(ch, "\u0000 ")) {
               len = end - start;
               this.column += len;
               this.stream.write(text, start, len);
               if (ch == 0) {
                  this.writeLineBreak((String)null);
               }

               start = end;
            }
         }

         if (ch != 0) {
            breaks = Constant.LINEBR.has(ch);
            spaces = ch == ' ';
         }
      }

   }

   void writeLiteral(String text) throws IOException {
      String hints = this.determineBlockHints(text);
      this.writeIndicator("|" + hints, true, false, false);
      if (hints.length() > 0 && hints.charAt(hints.length() - 1) == '+') {
         this.openEnded = true;
      }

      this.writeLineBreak((String)null);
      boolean breaks = true;
      int start = 0;

      for(int end = 0; end <= text.length(); ++end) {
         char ch = 0;
         if (end < text.length()) {
            ch = text.charAt(end);
         }

         if (!breaks) {
            if (ch == 0 || Constant.LINEBR.has(ch)) {
               this.stream.write(text, start, end - start);
               if (ch == 0) {
                  this.writeLineBreak((String)null);
               }

               start = end;
            }
         } else if (ch == 0 || Constant.LINEBR.hasNo(ch)) {
            String data = text.substring(start, end);
            char[] var8 = data.toCharArray();
            int var9 = var8.length;

            for(int var10 = 0; var10 < var9; ++var10) {
               char br = var8[var10];
               if (br == '\n') {
                  this.writeLineBreak((String)null);
               } else {
                  this.writeLineBreak(String.valueOf(br));
               }
            }

            if (ch != 0) {
               this.writeIndent();
            }

            start = end;
         }

         if (ch != 0) {
            breaks = Constant.LINEBR.has(ch);
         }
      }

   }

   void writePlain(String text, boolean split) throws IOException {
      if (this.rootContext) {
         this.openEnded = true;
      }

      if (text.length() != 0) {
         if (!this.whitespace) {
            ++this.column;
            this.stream.write(SPACE);
         }

         this.whitespace = false;
         this.indention = false;
         boolean spaces = false;
         boolean breaks = false;
         int start = 0;

         for(int end = 0; end <= text.length(); ++end) {
            char ch = 0;
            if (end < text.length()) {
               ch = text.charAt(end);
            }

            int len;
            if (spaces) {
               if (ch != ' ') {
                  if (start + 1 == end && this.column > this.bestWidth && split) {
                     this.writeIndent();
                     this.whitespace = false;
                     this.indention = false;
                  } else {
                     len = end - start;
                     this.column += len;
                     this.stream.write(text, start, len);
                  }

                  start = end;
               }
            } else if (!breaks) {
               if (Constant.LINEBR.has(ch, "\u0000 ")) {
                  len = end - start;
                  this.column += len;
                  this.stream.write(text, start, len);
                  start = end;
               }
            } else if (Constant.LINEBR.hasNo(ch)) {
               if (text.charAt(start) == '\n') {
                  this.writeLineBreak((String)null);
               }

               String data = text.substring(start, end);
               char[] var9 = data.toCharArray();
               int var10 = var9.length;

               for(int var11 = 0; var11 < var10; ++var11) {
                  char br = var9[var11];
                  if (br == '\n') {
                     this.writeLineBreak((String)null);
                  } else {
                     this.writeLineBreak(String.valueOf(br));
                  }
               }

               this.writeIndent();
               this.whitespace = false;
               this.indention = false;
               start = end;
            }

            if (ch != 0) {
               spaces = ch == ' ';
               breaks = Constant.LINEBR.has(ch);
            }
         }

      }
   }

   // $FF: synthetic method
   static Event access$100(Emitter x0) {
      return x0.event;
   }

   // $FF: synthetic method
   static EmitterState access$202(Emitter x0, EmitterState x1) {
      return x0.state = x1;
   }

   // $FF: synthetic method
   static boolean access$400(Emitter x0) {
      return x0.openEnded;
   }

   // $FF: synthetic method
   static String access$500(Emitter x0, DumperOptions$Version x1) {
      return x0.prepareVersion(x1);
   }

   // $FF: synthetic method
   static Map access$602(Emitter x0, Map x1) {
      return x0.tagPrefixes = x1;
   }

   // $FF: synthetic method
   static Map access$700() {
      return DEFAULT_TAG_PREFIXES;
   }

   // $FF: synthetic method
   static Map access$600(Emitter x0) {
      return x0.tagPrefixes;
   }

   // $FF: synthetic method
   static String access$800(Emitter x0, String x1) {
      return x0.prepareTagHandle(x1);
   }

   // $FF: synthetic method
   static String access$900(Emitter x0, String x1) {
      return x0.prepareTagPrefix(x1);
   }

   // $FF: synthetic method
   static Boolean access$1000(Emitter x0) {
      return x0.canonical;
   }

   // $FF: synthetic method
   static boolean access$1100(Emitter x0) {
      return x0.checkEmptyDocument();
   }

   // $FF: synthetic method
   static ArrayStack access$1500(Emitter x0) {
      return x0.states;
   }

   // $FF: synthetic method
   static void access$1600(Emitter x0, boolean x1, boolean x2, boolean x3) throws IOException {
      x0.expectNode(x1, x2, x3);
   }

   // $FF: synthetic method
   static Integer access$1802(Emitter x0, Integer x1) {
      return x0.indent = x1;
   }

   // $FF: synthetic method
   static ArrayStack access$1900(Emitter x0) {
      return x0.indents;
   }

   // $FF: synthetic method
   static int access$2010(Emitter x0) {
      return x0.flowLevel--;
   }

   // $FF: synthetic method
   static int access$2100(Emitter x0) {
      return x0.column;
   }

   // $FF: synthetic method
   static int access$2200(Emitter x0) {
      return x0.bestWidth;
   }

   // $FF: synthetic method
   static boolean access$2300(Emitter x0) {
      return x0.splitLines;
   }

   // $FF: synthetic method
   static Boolean access$2400(Emitter x0) {
      return x0.prettyFlow;
   }

   // $FF: synthetic method
   static boolean access$2700(Emitter x0) {
      return x0.checkSimpleKey();
   }

   // $FF: synthetic method
   static int access$3200(Emitter x0) {
      return x0.indicatorIndent;
   }

   // $FF: synthetic method
   static void access$3300(Emitter x0, int x1) throws IOException {
      x0.writeWhitespace(x1);
   }

   static {
      ESCAPE_REPLACEMENTS.put('\u0000', "0");
      ESCAPE_REPLACEMENTS.put('\u0007', "a");
      ESCAPE_REPLACEMENTS.put('\b', "b");
      ESCAPE_REPLACEMENTS.put('\t', "t");
      ESCAPE_REPLACEMENTS.put('\n', "n");
      ESCAPE_REPLACEMENTS.put('\u000b', "v");
      ESCAPE_REPLACEMENTS.put('\f', "f");
      ESCAPE_REPLACEMENTS.put('\r', "r");
      ESCAPE_REPLACEMENTS.put('\u001b', "e");
      ESCAPE_REPLACEMENTS.put('"', "\"");
      ESCAPE_REPLACEMENTS.put('\\', "\\");
      ESCAPE_REPLACEMENTS.put('\u0085', "N");
      ESCAPE_REPLACEMENTS.put('\u00a0', "_");
      ESCAPE_REPLACEMENTS.put('\u2028', "L");
      ESCAPE_REPLACEMENTS.put('\u2029', "P");
      DEFAULT_TAG_PREFIXES = new LinkedHashMap();
      DEFAULT_TAG_PREFIXES.put("!", "!");
      DEFAULT_TAG_PREFIXES.put("tag:yaml.org,2002:", "!!");
      HANDLE_FORMAT = Pattern.compile("^![-_\\w]*!$");
      ANCHOR_FORMAT = Pattern.compile("^[-_\\w]*$");
   }
}
