package org.yaml.snakeyaml.constructor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.Tag;

public class SafeConstructor extends BaseConstructor {
   public static final SafeConstructor$ConstructUndefined undefinedConstructor = new SafeConstructor$ConstructUndefined();
   private static final Map BOOL_VALUES = new HashMap();
   private static final Pattern TIMESTAMP_REGEXP;
   private static final Pattern YMD_REGEXP;

   public SafeConstructor() {
      this.yamlConstructors.put(Tag.NULL, new SafeConstructor$ConstructYamlNull(this));
      this.yamlConstructors.put(Tag.BOOL, new SafeConstructor$ConstructYamlBool(this));
      this.yamlConstructors.put(Tag.INT, new SafeConstructor$ConstructYamlInt(this));
      this.yamlConstructors.put(Tag.FLOAT, new SafeConstructor$ConstructYamlFloat(this));
      this.yamlConstructors.put(Tag.BINARY, new SafeConstructor$ConstructYamlBinary(this));
      this.yamlConstructors.put(Tag.TIMESTAMP, new SafeConstructor$ConstructYamlTimestamp());
      this.yamlConstructors.put(Tag.OMAP, new SafeConstructor$ConstructYamlOmap(this));
      this.yamlConstructors.put(Tag.PAIRS, new SafeConstructor$ConstructYamlPairs(this));
      this.yamlConstructors.put(Tag.SET, new SafeConstructor$ConstructYamlSet(this));
      this.yamlConstructors.put(Tag.STR, new SafeConstructor$ConstructYamlStr(this));
      this.yamlConstructors.put(Tag.SEQ, new SafeConstructor$ConstructYamlSeq(this));
      this.yamlConstructors.put(Tag.MAP, new SafeConstructor$ConstructYamlMap(this));
      this.yamlConstructors.put((Object)null, undefinedConstructor);
      this.yamlClassConstructors.put(NodeId.scalar, undefinedConstructor);
      this.yamlClassConstructors.put(NodeId.sequence, undefinedConstructor);
      this.yamlClassConstructors.put(NodeId.mapping, undefinedConstructor);
   }

   protected void flattenMapping(MappingNode node) {
      this.processDuplicateKeys(node);
      if (node.isMerged()) {
         node.setValue(this.mergeNode(node, true, new HashMap(), new ArrayList()));
      }

   }

   protected void processDuplicateKeys(MappingNode node) {
      List nodeValue = node.getValue();
      Map keys = new HashMap(nodeValue.size());
      TreeSet toRemove = new TreeSet();
      int i = 0;

      Iterator indicies2remove;
      for(indicies2remove = nodeValue.iterator(); indicies2remove.hasNext(); ++i) {
         NodeTuple tuple = (NodeTuple)indicies2remove.next();
         Node keyNode = tuple.getKeyNode();
         if (!keyNode.getTag().equals(Tag.MERGE)) {
            Object key = this.constructObject(keyNode);
            if (key != null) {
               try {
                  key.hashCode();
               } catch (Exception var11) {
                  throw new ConstructorException("while constructing a mapping", node.getStartMark(), "found unacceptable key " + key, tuple.getKeyNode().getStartMark(), var11);
               }
            }

            Integer prevIndex = (Integer)keys.put(key, i);
            if (prevIndex != null) {
               if (!this.isAllowDuplicateKeys()) {
                  throw new IllegalStateException("duplicate key: " + key);
               }

               toRemove.add(prevIndex);
            }
         }
      }

      indicies2remove = toRemove.descendingIterator();

      while(indicies2remove.hasNext()) {
         nodeValue.remove((Integer)indicies2remove.next());
      }

   }

   private List mergeNode(MappingNode node, boolean isPreffered, Map key2index, List values) {
      // $FF: Couldn't be decompiled
   }

   protected void constructMapping2ndStep(MappingNode node, Map mapping) {
      this.flattenMapping(node);
      super.constructMapping2ndStep(node, mapping);
   }

   protected void constructSet2ndStep(MappingNode node, Set set) {
      this.flattenMapping(node);
      super.constructSet2ndStep(node, set);
   }

   private Number createNumber(int sign, String number, int radix) {
      if (sign < 0) {
         number = "-" + number;
      }

      Object result;
      try {
         result = Integer.valueOf(number, radix);
      } catch (NumberFormatException var8) {
         try {
            result = Long.valueOf(number, radix);
         } catch (NumberFormatException var7) {
            result = new BigInteger(number, radix);
         }
      }

      return (Number)result;
   }

   // $FF: synthetic method
   static Map access$000() {
      return BOOL_VALUES;
   }

   // $FF: synthetic method
   static Number access$100(SafeConstructor x0, int x1, String x2, int x3) {
      return x0.createNumber(x1, x2, x3);
   }

   // $FF: synthetic method
   static Pattern access$200() {
      return YMD_REGEXP;
   }

   // $FF: synthetic method
   static Pattern access$300() {
      return TIMESTAMP_REGEXP;
   }

   static {
      BOOL_VALUES.put("yes", Boolean.TRUE);
      BOOL_VALUES.put("no", Boolean.FALSE);
      BOOL_VALUES.put("true", Boolean.TRUE);
      BOOL_VALUES.put("false", Boolean.FALSE);
      BOOL_VALUES.put("on", Boolean.TRUE);
      BOOL_VALUES.put("off", Boolean.FALSE);
      TIMESTAMP_REGEXP = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)(?:(?:[Tt]|[ \t]+)([0-9][0-9]?):([0-9][0-9]):([0-9][0-9])(?:\\.([0-9]*))?(?:[ \t]*(?:Z|([-+][0-9][0-9]?)(?::([0-9][0-9])?)?))?)?$");
      YMD_REGEXP = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)$");
   }
}
