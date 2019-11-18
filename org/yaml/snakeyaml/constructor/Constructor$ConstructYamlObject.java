package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.nodes.Node;

public class Constructor$ConstructYamlObject implements Construct {
   // $FF: synthetic field
   final Constructor this$0;

   protected Constructor$ConstructYamlObject(Constructor this$0) {
      this.this$0 = this$0;
   }

   private Construct getConstructor(Node node) {
      Class cl = this.this$0.getClassForNode(node);
      node.setType(cl);
      Construct constructor = (Construct)this.this$0.yamlClassConstructors.get(node.getNodeId());
      return constructor;
   }

   public Object construct(Node node) {
      Object result = null;

      try {
         result = this.getConstructor(node).construct(node);
      } catch (ConstructorException var4) {
         throw var4;
      } catch (Exception var5) {
         throw new ConstructorException((String)null, (Mark)null, "Can't construct a java object for " + node.getTag() + "; exception=" + var5.getMessage(), node.getStartMark(), var5);
      }

      return result;
   }

   public void construct2ndStep(Node node, Object object) {
      try {
         this.getConstructor(node).construct2ndStep(node, object);
      } catch (Exception var4) {
         throw new ConstructorException((String)null, (Mark)null, "Can't construct a second step for a java object for " + node.getTag() + "; exception=" + var4.getMessage(), node.getStartMark(), var4);
      }

   }
}
