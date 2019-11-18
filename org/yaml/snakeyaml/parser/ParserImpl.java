package org.yaml.snakeyaml.parser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.DumperOptions$Version;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.Event$ID;
import org.yaml.snakeyaml.events.ImplicitTuple;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.scanner.Scanner;
import org.yaml.snakeyaml.scanner.ScannerImpl;
import org.yaml.snakeyaml.tokens.AliasToken;
import org.yaml.snakeyaml.tokens.AnchorToken;
import org.yaml.snakeyaml.tokens.DirectiveToken;
import org.yaml.snakeyaml.tokens.ScalarToken;
import org.yaml.snakeyaml.tokens.TagToken;
import org.yaml.snakeyaml.tokens.TagTuple;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.Token$ID;
import org.yaml.snakeyaml.util.ArrayStack;

public class ParserImpl implements Parser {
   private static final Map DEFAULT_TAGS = new HashMap();
   protected final Scanner scanner;
   private Event currentEvent;
   private final ArrayStack states;
   private final ArrayStack marks;
   private Production state;
   private VersionTagsTuple directives;

   public ParserImpl(StreamReader reader) {
      this((Scanner)(new ScannerImpl(reader)));
   }

   public ParserImpl(Scanner scanner) {
      this.scanner = scanner;
      this.currentEvent = null;
      this.directives = new VersionTagsTuple((DumperOptions$Version)null, new HashMap(DEFAULT_TAGS));
      this.states = new ArrayStack(100);
      this.marks = new ArrayStack(10);
      this.state = new ParserImpl$ParseStreamStart(this, (ParserImpl$1)null);
   }

   public boolean checkEvent(Event$ID choice) {
      this.peekEvent();
      return this.currentEvent != null && this.currentEvent.is(choice);
   }

   public Event peekEvent() {
      if (this.currentEvent == null && this.state != null) {
         this.currentEvent = this.state.produce();
      }

      return this.currentEvent;
   }

   public Event getEvent() {
      this.peekEvent();
      Event value = this.currentEvent;
      this.currentEvent = null;
      return value;
   }

   private VersionTagsTuple processDirectives() {
      DumperOptions$Version yamlVersion = null;
      HashMap tagHandles = new HashMap();

      while(this.scanner.checkToken(Token$ID.Directive)) {
         DirectiveToken token = (DirectiveToken)this.scanner.getToken();
         List value;
         if (token.getName().equals("YAML")) {
            if (yamlVersion != null) {
               throw new ParserException((String)null, (Mark)null, "found duplicate YAML directive", token.getStartMark());
            }

            value = token.getValue();
            Integer major = (Integer)value.get(0);
            if (major != 1) {
               throw new ParserException((String)null, (Mark)null, "found incompatible YAML document (version 1.* is required)", token.getStartMark());
            }

            Integer minor = (Integer)value.get(1);
            switch(minor) {
            case 0:
               yamlVersion = DumperOptions$Version.V1_0;
               break;
            default:
               yamlVersion = DumperOptions$Version.V1_1;
            }
         } else if (token.getName().equals("TAG")) {
            value = token.getValue();
            String handle = (String)value.get(0);
            String prefix = (String)value.get(1);
            if (tagHandles.containsKey(handle)) {
               throw new ParserException((String)null, (Mark)null, "duplicate tag handle " + handle, token.getStartMark());
            }

            tagHandles.put(handle, prefix);
         }
      }

      if (yamlVersion != null || !tagHandles.isEmpty()) {
         Iterator var7 = DEFAULT_TAGS.keySet().iterator();

         while(var7.hasNext()) {
            String key = (String)var7.next();
            if (!tagHandles.containsKey(key)) {
               tagHandles.put(key, DEFAULT_TAGS.get(key));
            }
         }

         this.directives = new VersionTagsTuple(yamlVersion, tagHandles);
      }

      return this.directives;
   }

   private Event parseFlowNode() {
      return this.parseNode(false, false);
   }

   private Event parseBlockNodeOrIndentlessSequence() {
      return this.parseNode(true, true);
   }

   private Event parseNode(boolean block, boolean indentlessSequence) {
      Mark startMark = null;
      Mark endMark = null;
      Mark tagMark = null;
      Object event;
      if (this.scanner.checkToken(Token$ID.Alias)) {
         AliasToken token = (AliasToken)this.scanner.getToken();
         event = new AliasEvent(token.getValue(), token.getStartMark(), token.getEndMark());
         this.state = (Production)this.states.pop();
      } else {
         String anchor = null;
         TagTuple tagTokenTag = null;
         if (this.scanner.checkToken(Token$ID.Anchor)) {
            AnchorToken token = (AnchorToken)this.scanner.getToken();
            startMark = token.getStartMark();
            endMark = token.getEndMark();
            anchor = token.getValue();
            if (this.scanner.checkToken(Token$ID.Tag)) {
               TagToken tagToken = (TagToken)this.scanner.getToken();
               tagMark = tagToken.getStartMark();
               endMark = tagToken.getEndMark();
               tagTokenTag = tagToken.getValue();
            }
         } else if (this.scanner.checkToken(Token$ID.Tag)) {
            TagToken tagToken = (TagToken)this.scanner.getToken();
            startMark = tagToken.getStartMark();
            tagMark = startMark;
            endMark = tagToken.getEndMark();
            tagTokenTag = tagToken.getValue();
            if (this.scanner.checkToken(Token$ID.Anchor)) {
               AnchorToken token = (AnchorToken)this.scanner.getToken();
               endMark = token.getEndMark();
               anchor = token.getValue();
            }
         }

         String tag = null;
         String node;
         if (tagTokenTag != null) {
            String handle = tagTokenTag.getHandle();
            node = tagTokenTag.getSuffix();
            if (handle != null) {
               if (!this.directives.getTags().containsKey(handle)) {
                  throw new ParserException("while parsing a node", startMark, "found undefined tag handle " + handle, tagMark);
               }

               tag = (String)this.directives.getTags().get(handle) + node;
            } else {
               tag = node;
            }
         }

         if (startMark == null) {
            startMark = this.scanner.peekToken().getStartMark();
            endMark = startMark;
         }

         event = null;
         boolean implicit = tag == null || tag.equals("!");
         if (indentlessSequence && this.scanner.checkToken(Token$ID.BlockEntry)) {
            endMark = this.scanner.peekToken().getEndMark();
            event = new SequenceStartEvent(anchor, tag, implicit, startMark, endMark, Boolean.FALSE);
            this.state = new ParserImpl$ParseIndentlessSequenceEntry(this, (ParserImpl$1)null);
         } else if (this.scanner.checkToken(Token$ID.Scalar)) {
            ScalarToken token = (ScalarToken)this.scanner.getToken();
            endMark = token.getEndMark();
            ImplicitTuple implicitValues;
            if ((!token.getPlain() || tag != null) && !"!".equals(tag)) {
               if (tag == null) {
                  implicitValues = new ImplicitTuple(false, true);
               } else {
                  implicitValues = new ImplicitTuple(false, false);
               }
            } else {
               implicitValues = new ImplicitTuple(true, false);
            }

            event = new ScalarEvent(anchor, tag, implicitValues, token.getValue(), startMark, endMark, token.getStyle());
            this.state = (Production)this.states.pop();
         } else if (this.scanner.checkToken(Token$ID.FlowSequenceStart)) {
            endMark = this.scanner.peekToken().getEndMark();
            event = new SequenceStartEvent(anchor, tag, implicit, startMark, endMark, Boolean.TRUE);
            this.state = new ParserImpl$ParseFlowSequenceFirstEntry(this, (ParserImpl$1)null);
         } else if (this.scanner.checkToken(Token$ID.FlowMappingStart)) {
            endMark = this.scanner.peekToken().getEndMark();
            event = new MappingStartEvent(anchor, tag, implicit, startMark, endMark, Boolean.TRUE);
            this.state = new ParserImpl$ParseFlowMappingFirstKey(this, (ParserImpl$1)null);
         } else if (block && this.scanner.checkToken(Token$ID.BlockSequenceStart)) {
            endMark = this.scanner.peekToken().getStartMark();
            event = new SequenceStartEvent(anchor, tag, implicit, startMark, endMark, Boolean.FALSE);
            this.state = new ParserImpl$ParseBlockSequenceFirstEntry(this, (ParserImpl$1)null);
         } else if (block && this.scanner.checkToken(Token$ID.BlockMappingStart)) {
            endMark = this.scanner.peekToken().getStartMark();
            event = new MappingStartEvent(anchor, tag, implicit, startMark, endMark, Boolean.FALSE);
            this.state = new ParserImpl$ParseBlockMappingFirstKey(this, (ParserImpl$1)null);
         } else {
            if (anchor == null && tag == null) {
               if (block) {
                  node = "block";
               } else {
                  node = "flow";
               }

               Token token = this.scanner.peekToken();
               throw new ParserException("while parsing a " + node + " node", startMark, "expected the node content, but found " + token.getTokenId(), token.getStartMark());
            }

            event = new ScalarEvent(anchor, tag, new ImplicitTuple(implicit, false), "", startMark, endMark, '\u0000');
            this.state = (Production)this.states.pop();
         }
      }

      return (Event)event;
   }

   private Event processEmptyScalar(Mark mark) {
      return new ScalarEvent((String)null, (String)null, new ImplicitTuple(true, false), "", mark, mark, '\u0000');
   }

   // $FF: synthetic method
   static Production access$102(ParserImpl x0, Production x1) {
      return x0.state = x1;
   }

   // $FF: synthetic method
   static VersionTagsTuple access$302(ParserImpl x0, VersionTagsTuple x1) {
      return x0.directives = x1;
   }

   // $FF: synthetic method
   static Map access$400() {
      return DEFAULT_TAGS;
   }

   // $FF: synthetic method
   static ArrayStack access$600(ParserImpl x0) {
      return x0.states;
   }

   // $FF: synthetic method
   static VersionTagsTuple access$900(ParserImpl x0) {
      return x0.processDirectives();
   }

   // $FF: synthetic method
   static ArrayStack access$1100(ParserImpl x0) {
      return x0.marks;
   }

   // $FF: synthetic method
   static Event access$1200(ParserImpl x0, Mark x1) {
      return x0.processEmptyScalar(x1);
   }

   // $FF: synthetic method
   static Event access$1300(ParserImpl x0, boolean x1, boolean x2) {
      return x0.parseNode(x1, x2);
   }

   // $FF: synthetic method
   static Event access$2200(ParserImpl x0) {
      return x0.parseBlockNodeOrIndentlessSequence();
   }

   // $FF: synthetic method
   static Event access$2400(ParserImpl x0) {
      return x0.parseFlowNode();
   }

   static {
      DEFAULT_TAGS.put("!", "!");
      DEFAULT_TAGS.put("!!", "tag:yaml.org,2002:");
   }
}
