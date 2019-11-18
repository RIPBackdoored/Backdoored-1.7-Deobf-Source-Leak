package org.yaml.snakeyaml.scanner;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.tokens.AliasToken;
import org.yaml.snakeyaml.tokens.AnchorToken;
import org.yaml.snakeyaml.tokens.BlockEndToken;
import org.yaml.snakeyaml.tokens.BlockEntryToken;
import org.yaml.snakeyaml.tokens.BlockMappingStartToken;
import org.yaml.snakeyaml.tokens.BlockSequenceStartToken;
import org.yaml.snakeyaml.tokens.DirectiveToken;
import org.yaml.snakeyaml.tokens.DocumentEndToken;
import org.yaml.snakeyaml.tokens.DocumentStartToken;
import org.yaml.snakeyaml.tokens.FlowEntryToken;
import org.yaml.snakeyaml.tokens.FlowMappingEndToken;
import org.yaml.snakeyaml.tokens.FlowMappingStartToken;
import org.yaml.snakeyaml.tokens.FlowSequenceEndToken;
import org.yaml.snakeyaml.tokens.FlowSequenceStartToken;
import org.yaml.snakeyaml.tokens.KeyToken;
import org.yaml.snakeyaml.tokens.ScalarToken;
import org.yaml.snakeyaml.tokens.StreamEndToken;
import org.yaml.snakeyaml.tokens.StreamStartToken;
import org.yaml.snakeyaml.tokens.TagToken;
import org.yaml.snakeyaml.tokens.TagTuple;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.Token$ID;
import org.yaml.snakeyaml.tokens.ValueToken;
import org.yaml.snakeyaml.util.ArrayStack;
import org.yaml.snakeyaml.util.UriEncoder;

public final class ScannerImpl implements Scanner {
   private static final Pattern NOT_HEXA = Pattern.compile("[^0-9A-Fa-f]");
   public static final Map ESCAPE_REPLACEMENTS = new HashMap();
   public static final Map ESCAPE_CODES = new HashMap();
   private final StreamReader reader;
   private boolean done = false;
   private int flowLevel = 0;
   private List tokens;
   private int tokensTaken = 0;
   private int indent = -1;
   private ArrayStack indents;
   private boolean allowSimpleKey = true;
   private Map possibleSimpleKeys;

   public ScannerImpl(StreamReader reader) {
      this.reader = reader;
      this.tokens = new ArrayList(100);
      this.indents = new ArrayStack(10);
      this.possibleSimpleKeys = new LinkedHashMap();
      this.fetchStreamStart();
   }

   public boolean checkToken(Token$ID... choices) {
      while(this.needMoreTokens()) {
         this.fetchMoreTokens();
      }

      if (!this.tokens.isEmpty()) {
         if (choices.length == 0) {
            return true;
         }

         Token$ID first = ((Token)this.tokens.get(0)).getTokenId();

         for(int i = 0; i < choices.length; ++i) {
            if (first == choices[i]) {
               return true;
            }
         }
      }

      return false;
   }

   public Token peekToken() {
      while(this.needMoreTokens()) {
         this.fetchMoreTokens();
      }

      return (Token)this.tokens.get(0);
   }

   public Token getToken() {
      if (!this.tokens.isEmpty()) {
         ++this.tokensTaken;
         return (Token)this.tokens.remove(0);
      } else {
         return null;
      }
   }

   private boolean needMoreTokens() {
      if (this.done) {
         return false;
      } else if (this.tokens.isEmpty()) {
         return true;
      } else {
         this.stalePossibleSimpleKeys();
         return this.nextPossibleSimpleKey() == this.tokensTaken;
      }
   }

   private void fetchMoreTokens() {
      this.scanToNextToken();
      this.stalePossibleSimpleKeys();
      this.unwindIndent(this.reader.getColumn());
      int c = this.reader.peek();
      switch(c) {
      case 0:
         this.fetchStreamEnd();
         return;
      case 33:
         this.fetchTag();
         return;
      case 34:
         this.fetchDouble();
         return;
      case 37:
         if (this.checkDirective()) {
            this.fetchDirective();
            return;
         }
         break;
      case 38:
         this.fetchAnchor();
         return;
      case 39:
         this.fetchSingle();
         return;
      case 42:
         this.fetchAlias();
         return;
      case 44:
         this.fetchFlowEntry();
         return;
      case 45:
         if (this.checkDocumentStart()) {
            this.fetchDocumentStart();
            return;
         }

         if (this.checkBlockEntry()) {
            this.fetchBlockEntry();
            return;
         }
         break;
      case 46:
         if (this.checkDocumentEnd()) {
            this.fetchDocumentEnd();
            return;
         }
         break;
      case 58:
         if (this.checkValue()) {
            this.fetchValue();
            return;
         }
         break;
      case 62:
         if (this.flowLevel == 0) {
            this.fetchFolded();
            return;
         }
         break;
      case 63:
         if (this.checkKey()) {
            this.fetchKey();
            return;
         }
         break;
      case 91:
         this.fetchFlowSequenceStart();
         return;
      case 93:
         this.fetchFlowSequenceEnd();
         return;
      case 123:
         this.fetchFlowMappingStart();
         return;
      case 124:
         if (this.flowLevel == 0) {
            this.fetchLiteral();
            return;
         }
         break;
      case 125:
         this.fetchFlowMappingEnd();
         return;
      }

      if (this.checkPlain()) {
         this.fetchPlain();
      } else {
         String chRepresentation = String.valueOf(Character.toChars(c));
         Iterator var3 = ESCAPE_REPLACEMENTS.keySet().iterator();

         while(var3.hasNext()) {
            Character s = (Character)var3.next();
            String v = (String)ESCAPE_REPLACEMENTS.get(s);
            if (v.equals(chRepresentation)) {
               chRepresentation = "\\" + s;
               break;
            }
         }

         if (c == 9) {
            chRepresentation = chRepresentation + "(TAB)";
         }

         String text = String.format("found character '%s' that cannot start any token. (Do not use %s for indentation)", chRepresentation, chRepresentation);
         throw new ScannerException("while scanning for the next token", (Mark)null, text, this.reader.getMark());
      }
   }

   private int nextPossibleSimpleKey() {
      return !this.possibleSimpleKeys.isEmpty() ? ((SimpleKey)this.possibleSimpleKeys.values().iterator().next()).getTokenNumber() : -1;
   }

   private void stalePossibleSimpleKeys() {
      if (!this.possibleSimpleKeys.isEmpty()) {
         Iterator iterator = this.possibleSimpleKeys.values().iterator();

         while(true) {
            SimpleKey key;
            do {
               if (!iterator.hasNext()) {
                  return;
               }

               key = (SimpleKey)iterator.next();
            } while(key.getLine() == this.reader.getLine() && this.reader.getIndex() - key.getIndex() <= 1024);

            if (key.isRequired()) {
               throw new ScannerException("while scanning a simple key", key.getMark(), "could not find expected ':'", this.reader.getMark());
            }

            iterator.remove();
         }
      }
   }

   private void savePossibleSimpleKey() {
      boolean required = this.flowLevel == 0 && this.indent == this.reader.getColumn();
      if (!this.allowSimpleKey && required) {
         throw new YAMLException("A simple key is required only if it is the first token in the current line");
      } else {
         if (this.allowSimpleKey) {
            this.removePossibleSimpleKey();
            int tokenNumber = this.tokensTaken + this.tokens.size();
            SimpleKey key = new SimpleKey(tokenNumber, required, this.reader.getIndex(), this.reader.getLine(), this.reader.getColumn(), this.reader.getMark());
            this.possibleSimpleKeys.put(this.flowLevel, key);
         }

      }
   }

   private void removePossibleSimpleKey() {
      SimpleKey key = (SimpleKey)this.possibleSimpleKeys.remove(this.flowLevel);
      if (key != null && key.isRequired()) {
         throw new ScannerException("while scanning a simple key", key.getMark(), "could not find expected ':'", this.reader.getMark());
      }
   }

   private void unwindIndent(int col) {
      if (this.flowLevel == 0) {
         while(this.indent > col) {
            Mark mark = this.reader.getMark();
            this.indent = (Integer)this.indents.pop();
            this.tokens.add(new BlockEndToken(mark, mark));
         }

      }
   }

   private boolean addIndent(int column) {
      if (this.indent < column) {
         this.indents.push(this.indent);
         this.indent = column;
         return true;
      } else {
         return false;
      }
   }

   private void fetchStreamStart() {
      Mark mark = this.reader.getMark();
      Token token = new StreamStartToken(mark, mark);
      this.tokens.add(token);
   }

   private void fetchStreamEnd() {
      this.unwindIndent(-1);
      this.removePossibleSimpleKey();
      this.allowSimpleKey = false;
      this.possibleSimpleKeys.clear();
      Mark mark = this.reader.getMark();
      Token token = new StreamEndToken(mark, mark);
      this.tokens.add(token);
      this.done = true;
   }

   private void fetchDirective() {
      this.unwindIndent(-1);
      this.removePossibleSimpleKey();
      this.allowSimpleKey = false;
      Token tok = this.scanDirective();
      this.tokens.add(tok);
   }

   private void fetchDocumentStart() {
      this.fetchDocumentIndicator(true);
   }

   private void fetchDocumentEnd() {
      this.fetchDocumentIndicator(false);
   }

   private void fetchDocumentIndicator(boolean isDocumentStart) {
      this.unwindIndent(-1);
      this.removePossibleSimpleKey();
      this.allowSimpleKey = false;
      Mark startMark = this.reader.getMark();
      this.reader.forward(3);
      Mark endMark = this.reader.getMark();
      Object token;
      if (isDocumentStart) {
         token = new DocumentStartToken(startMark, endMark);
      } else {
         token = new DocumentEndToken(startMark, endMark);
      }

      this.tokens.add(token);
   }

   private void fetchFlowSequenceStart() {
      this.fetchFlowCollectionStart(false);
   }

   private void fetchFlowMappingStart() {
      this.fetchFlowCollectionStart(true);
   }

   private void fetchFlowCollectionStart(boolean isMappingStart) {
      this.savePossibleSimpleKey();
      ++this.flowLevel;
      this.allowSimpleKey = true;
      Mark startMark = this.reader.getMark();
      this.reader.forward(1);
      Mark endMark = this.reader.getMark();
      Object token;
      if (isMappingStart) {
         token = new FlowMappingStartToken(startMark, endMark);
      } else {
         token = new FlowSequenceStartToken(startMark, endMark);
      }

      this.tokens.add(token);
   }

   private void fetchFlowSequenceEnd() {
      this.fetchFlowCollectionEnd(false);
   }

   private void fetchFlowMappingEnd() {
      this.fetchFlowCollectionEnd(true);
   }

   private void fetchFlowCollectionEnd(boolean isMappingEnd) {
      this.removePossibleSimpleKey();
      --this.flowLevel;
      this.allowSimpleKey = false;
      Mark startMark = this.reader.getMark();
      this.reader.forward();
      Mark endMark = this.reader.getMark();
      Object token;
      if (isMappingEnd) {
         token = new FlowMappingEndToken(startMark, endMark);
      } else {
         token = new FlowSequenceEndToken(startMark, endMark);
      }

      this.tokens.add(token);
   }

   private void fetchFlowEntry() {
      this.allowSimpleKey = true;
      this.removePossibleSimpleKey();
      Mark startMark = this.reader.getMark();
      this.reader.forward();
      Mark endMark = this.reader.getMark();
      Token token = new FlowEntryToken(startMark, endMark);
      this.tokens.add(token);
   }

   private void fetchBlockEntry() {
      Mark mark;
      if (this.flowLevel == 0) {
         if (!this.allowSimpleKey) {
            throw new ScannerException((String)null, (Mark)null, "sequence entries are not allowed here", this.reader.getMark());
         }

         if (this.addIndent(this.reader.getColumn())) {
            mark = this.reader.getMark();
            this.tokens.add(new BlockSequenceStartToken(mark, mark));
         }
      }

      this.allowSimpleKey = true;
      this.removePossibleSimpleKey();
      mark = this.reader.getMark();
      this.reader.forward();
      Mark endMark = this.reader.getMark();
      Token token = new BlockEntryToken(mark, endMark);
      this.tokens.add(token);
   }

   private void fetchKey() {
      Mark mark;
      if (this.flowLevel == 0) {
         if (!this.allowSimpleKey) {
            throw new ScannerException((String)null, (Mark)null, "mapping keys are not allowed here", this.reader.getMark());
         }

         if (this.addIndent(this.reader.getColumn())) {
            mark = this.reader.getMark();
            this.tokens.add(new BlockMappingStartToken(mark, mark));
         }
      }

      this.allowSimpleKey = this.flowLevel == 0;
      this.removePossibleSimpleKey();
      mark = this.reader.getMark();
      this.reader.forward();
      Mark endMark = this.reader.getMark();
      Token token = new KeyToken(mark, endMark);
      this.tokens.add(token);
   }

   private void fetchValue() {
      SimpleKey key = (SimpleKey)this.possibleSimpleKeys.remove(this.flowLevel);
      Mark mark;
      if (key != null) {
         this.tokens.add(key.getTokenNumber() - this.tokensTaken, new KeyToken(key.getMark(), key.getMark()));
         if (this.flowLevel == 0 && this.addIndent(key.getColumn())) {
            this.tokens.add(key.getTokenNumber() - this.tokensTaken, new BlockMappingStartToken(key.getMark(), key.getMark()));
         }

         this.allowSimpleKey = false;
      } else {
         if (this.flowLevel == 0 && !this.allowSimpleKey) {
            throw new ScannerException((String)null, (Mark)null, "mapping values are not allowed here", this.reader.getMark());
         }

         if (this.flowLevel == 0 && this.addIndent(this.reader.getColumn())) {
            mark = this.reader.getMark();
            this.tokens.add(new BlockMappingStartToken(mark, mark));
         }

         this.allowSimpleKey = this.flowLevel == 0;
         this.removePossibleSimpleKey();
      }

      mark = this.reader.getMark();
      this.reader.forward();
      Mark endMark = this.reader.getMark();
      Token token = new ValueToken(mark, endMark);
      this.tokens.add(token);
   }

   private void fetchAlias() {
      this.savePossibleSimpleKey();
      this.allowSimpleKey = false;
      Token tok = this.scanAnchor(false);
      this.tokens.add(tok);
   }

   private void fetchAnchor() {
      this.savePossibleSimpleKey();
      this.allowSimpleKey = false;
      Token tok = this.scanAnchor(true);
      this.tokens.add(tok);
   }

   private void fetchTag() {
      this.savePossibleSimpleKey();
      this.allowSimpleKey = false;
      Token tok = this.scanTag();
      this.tokens.add(tok);
   }

   private void fetchLiteral() {
      this.fetchBlockScalar('|');
   }

   private void fetchFolded() {
      this.fetchBlockScalar('>');
   }

   private void fetchBlockScalar(char style) {
      this.allowSimpleKey = true;
      this.removePossibleSimpleKey();
      Token tok = this.scanBlockScalar(style);
      this.tokens.add(tok);
   }

   private void fetchSingle() {
      this.fetchFlowScalar('\'');
   }

   private void fetchDouble() {
      this.fetchFlowScalar('"');
   }

   private void fetchFlowScalar(char style) {
      this.savePossibleSimpleKey();
      this.allowSimpleKey = false;
      Token tok = this.scanFlowScalar(style);
      this.tokens.add(tok);
   }

   private void fetchPlain() {
      this.savePossibleSimpleKey();
      this.allowSimpleKey = false;
      Token tok = this.scanPlain();
      this.tokens.add(tok);
   }

   private boolean checkDirective() {
      return this.reader.getColumn() == 0;
   }

   private boolean checkDocumentStart() {
      return this.reader.getColumn() == 0 && "---".equals(this.reader.prefix(3)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3));
   }

   private boolean checkDocumentEnd() {
      return this.reader.getColumn() == 0 && "...".equals(this.reader.prefix(3)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3));
   }

   private boolean checkBlockEntry() {
      return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
   }

   private boolean checkKey() {
      return this.flowLevel != 0 ? true : Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
   }

   private boolean checkValue() {
      return this.flowLevel != 0 ? true : Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
   }

   private boolean checkPlain() {
      int c = this.reader.peek();
      return Constant.NULL_BL_T_LINEBR.hasNo(c, "-?:,[]{}#&*!|>'\"%@`") || Constant.NULL_BL_T_LINEBR.hasNo(this.reader.peek(1)) && (c == 45 || this.flowLevel == 0 && "?:".indexOf(c) != -1);
   }

   private void scanToNextToken() {
      if (this.reader.getIndex() == 0 && this.reader.peek() == 65279) {
         this.reader.forward();
      }

      boolean found = false;

      while(!found) {
         int ff;
         for(ff = 0; this.reader.peek(ff) == 32; ++ff) {
         }

         if (ff > 0) {
            this.reader.forward(ff);
         }

         if (this.reader.peek() == 35) {
            for(ff = 0; Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(ff)); ++ff) {
            }

            if (ff > 0) {
               this.reader.forward(ff);
            }
         }

         if (this.scanLineBreak().length() != 0) {
            if (this.flowLevel == 0) {
               this.allowSimpleKey = true;
            }
         } else {
            found = true;
         }
      }

   }

   private Token scanDirective() {
      Mark startMark = this.reader.getMark();
      this.reader.forward();
      String name = this.scanDirectiveName(startMark);
      List value = null;
      Mark endMark;
      if ("YAML".equals(name)) {
         value = this.scanYamlDirectiveValue(startMark);
         endMark = this.reader.getMark();
      } else if ("TAG".equals(name)) {
         value = this.scanTagDirectiveValue(startMark);
         endMark = this.reader.getMark();
      } else {
         endMark = this.reader.getMark();

         int ff;
         for(ff = 0; Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(ff)); ++ff) {
         }

         if (ff > 0) {
            this.reader.forward(ff);
         }
      }

      this.scanDirectiveIgnoredLine(startMark);
      return new DirectiveToken(name, value, startMark, endMark);
   }

   private String scanDirectiveName(Mark startMark) {
      int length = 0;

      int c;
      for(c = this.reader.peek(length); Constant.ALPHA.has(c); c = this.reader.peek(length)) {
         ++length;
      }

      String value;
      if (length == 0) {
         value = String.valueOf(Character.toChars(c));
         throw new ScannerException("while scanning a directive", startMark, "expected alphabetic or numeric character, but found " + value + "(" + c + ")", this.reader.getMark());
      } else {
         value = this.reader.prefixForward(length);
         c = this.reader.peek();
         if (Constant.NULL_BL_LINEBR.hasNo(c)) {
            String s = String.valueOf(Character.toChars(c));
            throw new ScannerException("while scanning a directive", startMark, "expected alphabetic or numeric character, but found " + s + "(" + c + ")", this.reader.getMark());
         } else {
            return value;
         }
      }
   }

   private List scanYamlDirectiveValue(Mark startMark) {
      while(this.reader.peek() == 32) {
         this.reader.forward();
      }

      Integer major = this.scanYamlDirectiveNumber(startMark);
      int c = this.reader.peek();
      if (c != 46) {
         String s = String.valueOf(Character.toChars(c));
         throw new ScannerException("while scanning a directive", startMark, "expected a digit or '.', but found " + s + "(" + c + ")", this.reader.getMark());
      } else {
         this.reader.forward();
         Integer minor = this.scanYamlDirectiveNumber(startMark);
         c = this.reader.peek();
         if (Constant.NULL_BL_LINEBR.hasNo(c)) {
            String s = String.valueOf(Character.toChars(c));
            throw new ScannerException("while scanning a directive", startMark, "expected a digit or ' ', but found " + s + "(" + c + ")", this.reader.getMark());
         } else {
            List result = new ArrayList(2);
            result.add(major);
            result.add(minor);
            return result;
         }
      }
   }

   private Integer scanYamlDirectiveNumber(Mark startMark) {
      int c = this.reader.peek();
      if (!Character.isDigit(c)) {
         String s = String.valueOf(Character.toChars(c));
         throw new ScannerException("while scanning a directive", startMark, "expected a digit, but found " + s + "(" + c + ")", this.reader.getMark());
      } else {
         int length;
         for(length = 0; Character.isDigit(this.reader.peek(length)); ++length) {
         }

         Integer value = Integer.parseInt(this.reader.prefixForward(length));
         return value;
      }
   }

   private List scanTagDirectiveValue(Mark startMark) {
      while(this.reader.peek() == 32) {
         this.reader.forward();
      }

      String handle = this.scanTagDirectiveHandle(startMark);

      while(this.reader.peek() == 32) {
         this.reader.forward();
      }

      String prefix = this.scanTagDirectivePrefix(startMark);
      List result = new ArrayList(2);
      result.add(handle);
      result.add(prefix);
      return result;
   }

   private String scanTagDirectiveHandle(Mark startMark) {
      String value = this.scanTagHandle("directive", startMark);
      int c = this.reader.peek();
      if (c != 32) {
         String s = String.valueOf(Character.toChars(c));
         throw new ScannerException("while scanning a directive", startMark, "expected ' ', but found " + s + "(" + c + ")", this.reader.getMark());
      } else {
         return value;
      }
   }

   private String scanTagDirectivePrefix(Mark startMark) {
      String value = this.scanTagUri("directive", startMark);
      int c = this.reader.peek();
      if (Constant.NULL_BL_LINEBR.hasNo(c)) {
         String s = String.valueOf(Character.toChars(c));
         throw new ScannerException("while scanning a directive", startMark, "expected ' ', but found " + s + "(" + c + ")", this.reader.getMark());
      } else {
         return value;
      }
   }

   private String scanDirectiveIgnoredLine(Mark startMark) {
      while(this.reader.peek() == 32) {
         this.reader.forward();
      }

      if (this.reader.peek() == 35) {
         while(Constant.NULL_OR_LINEBR.hasNo(this.reader.peek())) {
            this.reader.forward();
         }
      }

      int c = this.reader.peek();
      String lineBreak = this.scanLineBreak();
      if (lineBreak.length() == 0 && c != 0) {
         String s = String.valueOf(Character.toChars(c));
         throw new ScannerException("while scanning a directive", startMark, "expected a comment or a line break, but found " + s + "(" + c + ")", this.reader.getMark());
      } else {
         return lineBreak;
      }
   }

   private Token scanAnchor(boolean isAnchor) {
      Mark startMark = this.reader.getMark();
      int indicator = this.reader.peek();
      String name = indicator == 42 ? "alias" : "anchor";
      this.reader.forward();
      int length = 0;

      int c;
      for(c = this.reader.peek(length); Constant.ALPHA.has(c); c = this.reader.peek(length)) {
         ++length;
      }

      String value;
      if (length == 0) {
         value = String.valueOf(Character.toChars(c));
         throw new ScannerException("while scanning an " + name, startMark, "expected alphabetic or numeric character, but found " + value + "(" + c + ")", this.reader.getMark());
      } else {
         value = this.reader.prefixForward(length);
         c = this.reader.peek();
         if (Constant.NULL_BL_T_LINEBR.hasNo(c, "?:,]}%@`")) {
            String s = String.valueOf(Character.toChars(c));
            throw new ScannerException("while scanning an " + name, startMark, "expected alphabetic or numeric character, but found " + s + "(" + c + ")", this.reader.getMark());
         } else {
            Mark endMark = this.reader.getMark();
            Object tok;
            if (isAnchor) {
               tok = new AnchorToken(value, startMark, endMark);
            } else {
               tok = new AliasToken(value, startMark, endMark);
            }

            return (Token)tok;
         }
      }
   }

   private Token scanTag() {
      Mark startMark = this.reader.getMark();
      int c = this.reader.peek(1);
      String handle = null;
      String suffix = null;
      String s;
      if (c == 60) {
         this.reader.forward(2);
         suffix = this.scanTagUri("tag", startMark);
         c = this.reader.peek();
         if (c != 62) {
            s = String.valueOf(Character.toChars(c));
            throw new ScannerException("while scanning a tag", startMark, "expected '>', but found '" + s + "' (" + c + ")", this.reader.getMark());
         }

         this.reader.forward();
      } else if (Constant.NULL_BL_T_LINEBR.has(c)) {
         suffix = "!";
         this.reader.forward();
      } else {
         int length = 1;

         boolean useHandle;
         for(useHandle = false; Constant.NULL_BL_LINEBR.hasNo(c); c = this.reader.peek(length)) {
            if (c == 33) {
               useHandle = true;
               break;
            }

            ++length;
         }

         handle = "!";
         if (useHandle) {
            handle = this.scanTagHandle("tag", startMark);
         } else {
            handle = "!";
            this.reader.forward();
         }

         suffix = this.scanTagUri("tag", startMark);
      }

      c = this.reader.peek();
      if (Constant.NULL_BL_LINEBR.hasNo(c)) {
         s = String.valueOf(Character.toChars(c));
         throw new ScannerException("while scanning a tag", startMark, "expected ' ', but found '" + s + "' (" + c + ")", this.reader.getMark());
      } else {
         TagTuple value = new TagTuple(handle, suffix);
         Mark endMark = this.reader.getMark();
         return new TagToken(value, startMark, endMark);
      }
   }

   private Token scanBlockScalar(char style) {
      boolean folded;
      if (style == '>') {
         folded = true;
      } else {
         folded = false;
      }

      StringBuilder chunks = new StringBuilder();
      Mark startMark = this.reader.getMark();
      this.reader.forward();
      ScannerImpl$Chomping chompi = this.scanBlockScalarIndicators(startMark);
      int increment = chompi.getIncrement();
      this.scanBlockScalarIgnoredLine(startMark);
      int minIndent = this.indent + 1;
      if (minIndent < 1) {
         minIndent = 1;
      }

      String breaks = null;
      int maxIndent = false;
      int indent = false;
      Mark endMark;
      Object[] brme;
      int indent;
      if (increment == -1) {
         brme = this.scanBlockScalarIndentation();
         breaks = (String)brme[0];
         int maxIndent = (Integer)brme[1];
         endMark = (Mark)brme[2];
         indent = Math.max(minIndent, maxIndent);
      } else {
         indent = minIndent + increment - 1;
         brme = this.scanBlockScalarBreaks(indent);
         breaks = (String)brme[0];
         endMark = (Mark)brme[1];
      }

      String lineBreak = "";

      while(this.reader.getColumn() == indent && this.reader.peek() != 0) {
         chunks.append(breaks);
         boolean leadingNonSpace = " \t".indexOf(this.reader.peek()) == -1;

         int length;
         for(length = 0; Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(length)); ++length) {
         }

         chunks.append(this.reader.prefixForward(length));
         lineBreak = this.scanLineBreak();
         Object[] brme = this.scanBlockScalarBreaks(indent);
         breaks = (String)brme[0];
         endMark = (Mark)brme[1];
         if (this.reader.getColumn() != indent || this.reader.peek() == 0) {
            break;
         }

         if (folded && "\n".equals(lineBreak) && leadingNonSpace && " \t".indexOf(this.reader.peek()) == -1) {
            if (breaks.length() == 0) {
               chunks.append(" ");
            }
         } else {
            chunks.append(lineBreak);
         }
      }

      if (chompi.chompTailIsNotFalse()) {
         chunks.append(lineBreak);
      }

      if (chompi.chompTailIsTrue()) {
         chunks.append(breaks);
      }

      return new ScalarToken(chunks.toString(), false, startMark, endMark, style);
   }

   private ScannerImpl$Chomping scanBlockScalarIndicators(Mark startMark) {
      Boolean chomping = null;
      int increment = -1;
      int c = this.reader.peek();
      String s;
      if (c != 45 && c != 43) {
         if (Character.isDigit(c)) {
            s = String.valueOf(Character.toChars(c));
            increment = Integer.parseInt(s);
            if (increment == 0) {
               throw new ScannerException("while scanning a block scalar", startMark, "expected indentation indicator in the range 1-9, but found 0", this.reader.getMark());
            }

            this.reader.forward();
            c = this.reader.peek();
            if (c == 45 || c == 43) {
               if (c == 43) {
                  chomping = Boolean.TRUE;
               } else {
                  chomping = Boolean.FALSE;
               }

               this.reader.forward();
            }
         }
      } else {
         if (c == 43) {
            chomping = Boolean.TRUE;
         } else {
            chomping = Boolean.FALSE;
         }

         this.reader.forward();
         c = this.reader.peek();
         if (Character.isDigit(c)) {
            s = String.valueOf(Character.toChars(c));
            increment = Integer.parseInt(s);
            if (increment == 0) {
               throw new ScannerException("while scanning a block scalar", startMark, "expected indentation indicator in the range 1-9, but found 0", this.reader.getMark());
            }

            this.reader.forward();
         }
      }

      c = this.reader.peek();
      if (Constant.NULL_BL_LINEBR.hasNo(c)) {
         s = String.valueOf(Character.toChars(c));
         throw new ScannerException("while scanning a block scalar", startMark, "expected chomping or indentation indicators, but found " + s + "(" + c + ")", this.reader.getMark());
      } else {
         return new ScannerImpl$Chomping(chomping, increment);
      }
   }

   private String scanBlockScalarIgnoredLine(Mark startMark) {
      while(this.reader.peek() == 32) {
         this.reader.forward();
      }

      if (this.reader.peek() == 35) {
         while(Constant.NULL_OR_LINEBR.hasNo(this.reader.peek())) {
            this.reader.forward();
         }
      }

      int c = this.reader.peek();
      String lineBreak = this.scanLineBreak();
      if (lineBreak.length() == 0 && c != 0) {
         String s = String.valueOf(Character.toChars(c));
         throw new ScannerException("while scanning a block scalar", startMark, "expected a comment or a line break, but found " + s + "(" + c + ")", this.reader.getMark());
      } else {
         return lineBreak;
      }
   }

   private Object[] scanBlockScalarIndentation() {
      StringBuilder chunks = new StringBuilder();
      int maxIndent = 0;
      Mark endMark = this.reader.getMark();

      while(Constant.LINEBR.has(this.reader.peek(), " \r")) {
         if (this.reader.peek() != 32) {
            chunks.append(this.scanLineBreak());
            endMark = this.reader.getMark();
         } else {
            this.reader.forward();
            if (this.reader.getColumn() > maxIndent) {
               maxIndent = this.reader.getColumn();
            }
         }
      }

      return new Object[]{chunks.toString(), maxIndent, endMark};
   }

   private Object[] scanBlockScalarBreaks(int indent) {
      StringBuilder chunks = new StringBuilder();
      Mark endMark = this.reader.getMark();

      int col;
      for(col = this.reader.getColumn(); col < indent && this.reader.peek() == 32; ++col) {
         this.reader.forward();
      }

      String lineBreak = null;

      while((lineBreak = this.scanLineBreak()).length() != 0) {
         chunks.append(lineBreak);
         endMark = this.reader.getMark();

         for(col = this.reader.getColumn(); col < indent && this.reader.peek() == 32; ++col) {
            this.reader.forward();
         }
      }

      return new Object[]{chunks.toString(), endMark};
   }

   private Token scanFlowScalar(char style) {
      boolean _double;
      if (style == '"') {
         _double = true;
      } else {
         _double = false;
      }

      StringBuilder chunks = new StringBuilder();
      Mark startMark = this.reader.getMark();
      int quote = this.reader.peek();
      this.reader.forward();
      chunks.append(this.scanFlowScalarNonSpaces(_double, startMark));

      while(this.reader.peek() != quote) {
         chunks.append(this.scanFlowScalarSpaces(startMark));
         chunks.append(this.scanFlowScalarNonSpaces(_double, startMark));
      }

      this.reader.forward();
      Mark endMark = this.reader.getMark();
      return new ScalarToken(chunks.toString(), false, startMark, endMark, style);
   }

   private String scanFlowScalarNonSpaces(boolean doubleQuoted, Mark startMark) {
      StringBuilder chunks = new StringBuilder();

      while(true) {
         while(true) {
            while(true) {
               int length;
               for(length = 0; Constant.NULL_BL_T_LINEBR.hasNo(this.reader.peek(length), "'\"\\"); ++length) {
               }

               if (length != 0) {
                  chunks.append(this.reader.prefixForward(length));
               }

               int c = this.reader.peek();
               if (doubleQuoted || c != 39 || this.reader.peek(1) != 39) {
                  if ((!doubleQuoted || c != 39) && (doubleQuoted || "\"\\".indexOf(c) == -1)) {
                     if (!doubleQuoted || c != 92) {
                        return chunks.toString();
                     }

                     this.reader.forward();
                     c = this.reader.peek();
                     if (!Character.isSupplementaryCodePoint(c) && ESCAPE_REPLACEMENTS.containsKey((char)c)) {
                        chunks.append((String)ESCAPE_REPLACEMENTS.get((char)c));
                        this.reader.forward();
                     } else {
                        String s;
                        if (!Character.isSupplementaryCodePoint(c) && ESCAPE_CODES.containsKey((char)c)) {
                           length = (Integer)ESCAPE_CODES.get((char)c);
                           this.reader.forward();
                           s = this.reader.prefix(length);
                           if (NOT_HEXA.matcher(s).find()) {
                              throw new ScannerException("while scanning a double-quoted scalar", startMark, "expected escape sequence of " + length + " hexadecimal numbers, but found: " + s, this.reader.getMark());
                           }

                           int decimal = Integer.parseInt(s, 16);
                           String unicode = new String(Character.toChars(decimal));
                           chunks.append(unicode);
                           this.reader.forward(length);
                        } else {
                           if (this.scanLineBreak().length() == 0) {
                              s = String.valueOf(Character.toChars(c));
                              throw new ScannerException("while scanning a double-quoted scalar", startMark, "found unknown escape character " + s + "(" + c + ")", this.reader.getMark());
                           }

                           chunks.append(this.scanFlowScalarBreaks(startMark));
                        }
                     }
                  } else {
                     chunks.appendCodePoint(c);
                     this.reader.forward();
                  }
               } else {
                  chunks.append("'");
                  this.reader.forward(2);
               }
            }
         }
      }
   }

   private String scanFlowScalarSpaces(Mark startMark) {
      StringBuilder chunks = new StringBuilder();

      int length;
      for(length = 0; " \t".indexOf(this.reader.peek(length)) != -1; ++length) {
      }

      String whitespaces = this.reader.prefixForward(length);
      int c = this.reader.peek();
      if (c == 0) {
         throw new ScannerException("while scanning a quoted scalar", startMark, "found unexpected end of stream", this.reader.getMark());
      } else {
         String lineBreak = this.scanLineBreak();
         if (lineBreak.length() != 0) {
            String breaks = this.scanFlowScalarBreaks(startMark);
            if (!"\n".equals(lineBreak)) {
               chunks.append(lineBreak);
            } else if (breaks.length() == 0) {
               chunks.append(" ");
            }

            chunks.append(breaks);
         } else {
            chunks.append(whitespaces);
         }

         return chunks.toString();
      }
   }

   private String scanFlowScalarBreaks(Mark startMark) {
      StringBuilder chunks = new StringBuilder();

      while(true) {
         String prefix = this.reader.prefix(3);
         if (("---".equals(prefix) || "...".equals(prefix)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))) {
            throw new ScannerException("while scanning a quoted scalar", startMark, "found unexpected document separator", this.reader.getMark());
         }

         while(" \t".indexOf(this.reader.peek()) != -1) {
            this.reader.forward();
         }

         String lineBreak = this.scanLineBreak();
         if (lineBreak.length() == 0) {
            return chunks.toString();
         }

         chunks.append(lineBreak);
      }
   }

   private Token scanPlain() {
      StringBuilder chunks = new StringBuilder();
      Mark startMark = this.reader.getMark();
      Mark endMark = startMark;
      int indent = this.indent + 1;
      String spaces = "";

      do {
         int length = 0;
         if (this.reader.peek() == 35) {
            break;
         }

         while(true) {
            int c = this.reader.peek(length);
            if (Constant.NULL_BL_T_LINEBR.has(c) || this.flowLevel == 0 && c == 58 && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(length + 1)) || this.flowLevel != 0 && ",:?[]{}".indexOf(c) != -1) {
               if (this.flowLevel != 0 && c == 58 && Constant.NULL_BL_T_LINEBR.hasNo(this.reader.peek(length + 1), ",[]{}")) {
                  this.reader.forward(length);
                  throw new ScannerException("while scanning a plain scalar", startMark, "found unexpected ':'", this.reader.getMark(), "Please check http://pyyaml.org/wiki/YAMLColonInFlowContext for details.");
               }

               if (length == 0) {
                  return new ScalarToken(chunks.toString(), startMark, endMark, true);
               }

               this.allowSimpleKey = false;
               chunks.append(spaces);
               chunks.append(this.reader.prefixForward(length));
               endMark = this.reader.getMark();
               spaces = this.scanPlainSpaces();
               break;
            }

            ++length;
         }
      } while(spaces.length() != 0 && this.reader.peek() != 35 && (this.flowLevel != 0 || this.reader.getColumn() >= indent));

      return new ScalarToken(chunks.toString(), startMark, endMark, true);
   }

   private String scanPlainSpaces() {
      int length;
      for(length = 0; this.reader.peek(length) == 32 || this.reader.peek(length) == 9; ++length) {
      }

      String whitespaces = this.reader.prefixForward(length);
      String lineBreak = this.scanLineBreak();
      if (lineBreak.length() == 0) {
         return whitespaces;
      } else {
         this.allowSimpleKey = true;
         String prefix = this.reader.prefix(3);
         if ("---".equals(prefix) || "...".equals(prefix) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))) {
            return "";
         } else {
            StringBuilder breaks = new StringBuilder();

            do {
               while(this.reader.peek() == 32) {
                  this.reader.forward();
               }

               String lb = this.scanLineBreak();
               if (lb.length() == 0) {
                  if (!"\n".equals(lineBreak)) {
                     return lineBreak + breaks;
                  }

                  if (breaks.length() == 0) {
                     return " ";
                  }

                  return breaks.toString();
               }

               breaks.append(lb);
               prefix = this.reader.prefix(3);
            } while(!"---".equals(prefix) && (!"...".equals(prefix) || !Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))));

            return "";
         }
      }
   }

   private String scanTagHandle(String name, Mark startMark) {
      int c = this.reader.peek();
      if (c != 33) {
         String s = String.valueOf(Character.toChars(c));
         throw new ScannerException("while scanning a " + name, startMark, "expected '!', but found " + s + "(" + c + ")", this.reader.getMark());
      } else {
         int length = 1;
         c = this.reader.peek(length);
         String s;
         if (c != 32) {
            while(Constant.ALPHA.has(c)) {
               ++length;
               c = this.reader.peek(length);
            }

            if (c != 33) {
               this.reader.forward(length);
               s = String.valueOf(Character.toChars(c));
               throw new ScannerException("while scanning a " + name, startMark, "expected '!', but found " + s + "(" + c + ")", this.reader.getMark());
            }

            ++length;
         }

         s = this.reader.prefixForward(length);
         return s;
      }
   }

   private String scanTagUri(String name, Mark startMark) {
      StringBuilder chunks = new StringBuilder();
      int length = 0;

      int c;
      for(c = this.reader.peek(length); Constant.URI_CHARS.has(c); c = this.reader.peek(length)) {
         if (c == 37) {
            chunks.append(this.reader.prefixForward(length));
            length = 0;
            chunks.append(this.scanUriEscapes(name, startMark));
         } else {
            ++length;
         }
      }

      if (length != 0) {
         chunks.append(this.reader.prefixForward(length));
         boolean var7 = false;
      }

      if (chunks.length() == 0) {
         String s = String.valueOf(Character.toChars(c));
         throw new ScannerException("while scanning a " + name, startMark, "expected URI, but found " + s + "(" + c + ")", this.reader.getMark());
      } else {
         return chunks.toString();
      }
   }

   private String scanUriEscapes(String name, Mark startMark) {
      int length;
      for(length = 1; this.reader.peek(length * 3) == 37; ++length) {
      }

      Mark beginningMark = this.reader.getMark();

      ByteBuffer buff;
      for(buff = ByteBuffer.allocate(length); this.reader.peek() == 37; this.reader.forward(2)) {
         this.reader.forward();

         try {
            byte code = (byte)Integer.parseInt(this.reader.prefix(2), 16);
            buff.put(code);
         } catch (NumberFormatException var12) {
            int c1 = this.reader.peek();
            String s1 = String.valueOf(Character.toChars(c1));
            int c2 = this.reader.peek(1);
            String s2 = String.valueOf(Character.toChars(c2));
            throw new ScannerException("while scanning a " + name, startMark, "expected URI escape sequence of 2 hexadecimal numbers, but found " + s1 + "(" + c1 + ") and " + s2 + "(" + c2 + ")", this.reader.getMark());
         }
      }

      buff.flip();

      String var10000;
      try {
         var10000 = UriEncoder.decode(buff);
      } catch (CharacterCodingException var11) {
         throw new ScannerException("while scanning a " + name, startMark, "expected URI in UTF-8: " + var11.getMessage(), beginningMark);
      }

      return var10000;
   }

   private String scanLineBreak() {
      int c = this.reader.peek();
      if (c != 13 && c != 10 && c != 133) {
         if (c != 8232 && c != 8233) {
            return "";
         } else {
            this.reader.forward();
            return String.valueOf(Character.toChars(c));
         }
      } else {
         if (c == 13 && 10 == this.reader.peek(1)) {
            this.reader.forward(2);
         } else {
            this.reader.forward();
         }

         return "\n";
      }
   }

   static {
      ESCAPE_REPLACEMENTS.put('0', "\u0000");
      ESCAPE_REPLACEMENTS.put('a', "\u0007");
      ESCAPE_REPLACEMENTS.put('b', "\b");
      ESCAPE_REPLACEMENTS.put('t', "\t");
      ESCAPE_REPLACEMENTS.put('n', "\n");
      ESCAPE_REPLACEMENTS.put('v', "\u000b");
      ESCAPE_REPLACEMENTS.put('f', "\f");
      ESCAPE_REPLACEMENTS.put('r', "\r");
      ESCAPE_REPLACEMENTS.put('e', "\u001b");
      ESCAPE_REPLACEMENTS.put(' ', " ");
      ESCAPE_REPLACEMENTS.put('"', "\"");
      ESCAPE_REPLACEMENTS.put('\\', "\\");
      ESCAPE_REPLACEMENTS.put('N', "\u0085");
      ESCAPE_REPLACEMENTS.put('_', "\u00a0");
      ESCAPE_REPLACEMENTS.put('L', "\u2028");
      ESCAPE_REPLACEMENTS.put('P', "\u2029");
      ESCAPE_CODES.put('x', 2);
      ESCAPE_CODES.put('u', 4);
      ESCAPE_CODES.put('U', 8);
   }
}
