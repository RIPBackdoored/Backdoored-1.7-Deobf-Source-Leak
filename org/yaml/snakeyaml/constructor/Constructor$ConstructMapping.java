package org.yaml.snakeyaml.constructor;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

public class Constructor$ConstructMapping implements Construct {
   // $FF: synthetic field
   final Constructor this$0;

   protected Constructor$ConstructMapping(Constructor this$0) {
      this.this$0 = this$0;
   }

   public Object construct(Node node) {
      MappingNode mnode = (MappingNode)node;
      if (Map.class.isAssignableFrom(node.getType())) {
         return node.isTwoStepsConstruction() ? this.this$0.newMap(mnode) : this.this$0.constructMapping(mnode);
      } else if (Collection.class.isAssignableFrom(node.getType())) {
         return node.isTwoStepsConstruction() ? this.this$0.newSet(mnode) : this.this$0.constructSet(mnode);
      } else {
         Object obj = this.this$0.newInstance(mnode);
         return node.isTwoStepsConstruction() ? obj : this.constructJavaBean2ndStep(mnode, obj);
      }
   }

   public void construct2ndStep(Node node, Object object) {
      if (Map.class.isAssignableFrom(node.getType())) {
         this.this$0.constructMapping2ndStep((MappingNode)node, (Map)object);
      } else if (Set.class.isAssignableFrom(node.getType())) {
         this.this$0.constructSet2ndStep((MappingNode)node, (Set)object);
      } else {
         this.constructJavaBean2ndStep((MappingNode)node, object);
      }

   }

   protected Object constructJavaBean2ndStep(MappingNode node, Object object) {
      this.this$0.flattenMapping(node);
      Class beanType = node.getType();
      List nodeValue = node.getValue();
      Iterator var5 = nodeValue.iterator();

      while(var5.hasNext()) {
         NodeTuple tuple = (NodeTuple)var5.next();
         if (!(tuple.getKeyNode() instanceof ScalarNode)) {
            throw new YAMLException("Keys must be scalars but found: " + tuple.getKeyNode());
         }

         ScalarNode keyNode = (ScalarNode)tuple.getKeyNode();
         Node valueNode = tuple.getValueNode();
         keyNode.setType(String.class);
         String key = (String)this.this$0.constructObject(keyNode);

         try {
            TypeDescription memberDescription = (TypeDescription)this.this$0.typeDefinitions.get(beanType);
            Property property = memberDescription == null ? this.getProperty(beanType, key) : memberDescription.getProperty(key);
            if (!property.isWritable()) {
               throw new YAMLException("No writable property '" + key + "' on class: " + beanType.getName());
            }

            valueNode.setType(property.getType());
            boolean typeDetected = memberDescription != null ? memberDescription.setupPropertyType(key, valueNode) : false;
            if (!typeDetected && valueNode.getNodeId() != NodeId.scalar) {
               Class[] arguments = property.getActualTypeArguments();
               if (arguments != null && arguments.length > 0) {
                  Class ketType;
                  if (valueNode.getNodeId() == NodeId.sequence) {
                     ketType = arguments[0];
                     SequenceNode snode = (SequenceNode)valueNode;
                     snode.setListType(ketType);
                  } else if (Set.class.isAssignableFrom(valueNode.getType())) {
                     ketType = arguments[0];
                     MappingNode mnode = (MappingNode)valueNode;
                     mnode.setOnlyKeyType(ketType);
                     mnode.setUseClassConstructor(true);
                  } else if (Map.class.isAssignableFrom(valueNode.getType())) {
                     ketType = arguments[0];
                     Class valueType = arguments[1];
                     MappingNode mnode = (MappingNode)valueNode;
                     mnode.setTypes(ketType, valueType);
                     mnode.setUseClassConstructor(true);
                  }
               }
            }

            Object value = memberDescription != null ? this.newInstance(memberDescription, key, valueNode) : this.this$0.constructObject(valueNode);
            if ((property.getType() == Float.TYPE || property.getType() == Float.class) && value instanceof Double) {
               value = ((Double)value).floatValue();
            }

            if (property.getType() == String.class && Tag.BINARY.equals(valueNode.getTag()) && value instanceof byte[]) {
               value = new String((byte[])((byte[])value));
            }

            if (memberDescription == null || !memberDescription.setProperty(object, key, value)) {
               property.set(object, value);
            }
         } catch (Exception var17) {
            throw new ConstructorException("Cannot create property=" + key + " for JavaBean=" + object, node.getStartMark(), var17.getMessage(), valueNode.getStartMark(), var17);
         }
      }

      return object;
   }

   private Object newInstance(TypeDescription memberDescription, String propertyName, Node node) {
      Object newInstance = memberDescription.newInstance(propertyName, node);
      if (newInstance != null) {
         this.this$0.constructedObjects.put(node, newInstance);
         return this.this$0.constructObjectNoCheck(node);
      } else {
         return this.this$0.constructObject(node);
      }
   }

   protected Property getProperty(Class type, String name) {
      return this.this$0.getPropertyUtils().getProperty(type, name);
   }
}
