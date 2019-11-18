package org.yaml.snakeyaml.representer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.yaml.snakeyaml.DumperOptions$FlowStyle;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

public class Representer extends SafeRepresenter {
   protected Map typeDefinitions = Collections.emptyMap();

   public Representer() {
      this.representers.put((Object)null, new Representer$RepresentJavaBean(this));
   }

   public TypeDescription addTypeDescription(TypeDescription td) {
      if (Collections.EMPTY_MAP == this.typeDefinitions) {
         this.typeDefinitions = new HashMap();
      }

      if (td.getTag() != null) {
         this.addClassTag(td.getType(), td.getTag());
      }

      td.setPropertyUtils(this.getPropertyUtils());
      return (TypeDescription)this.typeDefinitions.put(td.getType(), td);
   }

   public void setPropertyUtils(PropertyUtils propertyUtils) {
      super.setPropertyUtils(propertyUtils);
      Collection tds = this.typeDefinitions.values();
      Iterator var3 = tds.iterator();

      while(var3.hasNext()) {
         TypeDescription typeDescription = (TypeDescription)var3.next();
         typeDescription.setPropertyUtils(propertyUtils);
      }

   }

   protected MappingNode representJavaBean(Set properties, Object javaBean) {
      List value = new ArrayList(properties.size());
      Tag customTag = (Tag)this.classTags.get(javaBean.getClass());
      Tag tag = customTag != null ? customTag : new Tag(javaBean.getClass());
      MappingNode node = new MappingNode(tag, value, (Boolean)null);
      this.representedObjects.put(javaBean, node);
      boolean bestStyle = true;
      Iterator var8 = properties.iterator();

      while(true) {
         NodeTuple tuple;
         do {
            if (!var8.hasNext()) {
               if (this.defaultFlowStyle != DumperOptions$FlowStyle.AUTO) {
                  node.setFlowStyle(this.defaultFlowStyle.getStyleBoolean());
               } else {
                  node.setFlowStyle(bestStyle);
               }

               return node;
            }

            Property property = (Property)var8.next();
            Object memberValue = property.get(javaBean);
            Tag customPropertyTag = memberValue == null ? null : (Tag)this.classTags.get(memberValue.getClass());
            tuple = this.representJavaBeanProperty(javaBean, property, memberValue, customPropertyTag);
         } while(tuple == null);

         if (((ScalarNode)tuple.getKeyNode()).getStyle() != null) {
            bestStyle = false;
         }

         Node nodeValue = tuple.getValueNode();
         if (!(nodeValue instanceof ScalarNode) || ((ScalarNode)nodeValue).getStyle() != null) {
            bestStyle = false;
         }

         value.add(tuple);
      }
   }

   protected NodeTuple representJavaBeanProperty(Object javaBean, Property property, Object propertyValue, Tag customTag) {
      ScalarNode nodeKey = (ScalarNode)this.representData(property.getName());
      boolean hasAlias = this.representedObjects.containsKey(propertyValue);
      Node nodeValue = this.representData(propertyValue);
      if (propertyValue != null && !hasAlias) {
         NodeId nodeId = nodeValue.getNodeId();
         if (customTag == null) {
            if (nodeId == NodeId.scalar) {
               if (property.getType() == propertyValue.getClass() && propertyValue instanceof Enum) {
                  nodeValue.setTag(Tag.STR);
               }
            } else {
               if (nodeId == NodeId.mapping && property.getType() == propertyValue.getClass() && !(propertyValue instanceof Map) && !nodeValue.getTag().equals(Tag.SET)) {
                  nodeValue.setTag(Tag.MAP);
               }

               this.checkGlobalTag(property, nodeValue, propertyValue);
            }
         }
      }

      return new NodeTuple(nodeKey, nodeValue);
   }

   protected void checkGlobalTag(Property property, Node node, Object object) {
      if (!object.getClass().isArray() || !object.getClass().getComponentType().isPrimitive()) {
         Class[] arguments = property.getActualTypeArguments();
         if (arguments != null) {
            Class t;
            Iterator iter;
            Iterator var9;
            if (node.getNodeId() == NodeId.sequence) {
               t = arguments[0];
               SequenceNode snode = (SequenceNode)node;
               Iterable memberList = Collections.EMPTY_LIST;
               if (object.getClass().isArray()) {
                  memberList = Arrays.asList((Object[])((Object[])object));
               } else if (object instanceof Iterable) {
                  memberList = (Iterable)object;
               }

               iter = ((Iterable)memberList).iterator();
               if (iter.hasNext()) {
                  var9 = snode.getValue().iterator();

                  while(var9.hasNext()) {
                     Node childNode = (Node)var9.next();
                     Object member = iter.next();
                     if (member != null && t.equals(member.getClass()) && childNode.getNodeId() == NodeId.mapping) {
                        childNode.setTag(Tag.MAP);
                     }
                  }
               }
            } else if (object instanceof Set) {
               t = arguments[0];
               MappingNode mnode = (MappingNode)node;
               Iterator iter = mnode.getValue().iterator();
               Set set = (Set)object;
               var9 = set.iterator();

               while(var9.hasNext()) {
                  Object member = var9.next();
                  NodeTuple tuple = (NodeTuple)iter.next();
                  Node keyNode = tuple.getKeyNode();
                  if (t.equals(member.getClass()) && keyNode.getNodeId() == NodeId.mapping) {
                     keyNode.setTag(Tag.MAP);
                  }
               }
            } else if (object instanceof Map) {
               t = arguments[0];
               Class valueType = arguments[1];
               MappingNode mnode = (MappingNode)node;
               iter = mnode.getValue().iterator();

               while(iter.hasNext()) {
                  NodeTuple tuple = (NodeTuple)iter.next();
                  this.resetTag(t, tuple.getKeyNode());
                  this.resetTag(valueType, tuple.getValueNode());
               }
            }
         }

      }
   }

   private void resetTag(Class type, Node node) {
      Tag tag = node.getTag();
      if (tag.matches(type)) {
         if (Enum.class.isAssignableFrom(type)) {
            node.setTag(Tag.STR);
         } else {
            node.setTag(Tag.MAP);
         }
      }

   }

   protected Set getProperties(Class type) {
      return this.typeDefinitions.containsKey(type) ? ((TypeDescription)this.typeDefinitions.get(type)).getProperties() : this.getPropertyUtils().getProperties(type);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void setTimeZone(TimeZone var1) {
      super.setTimeZone(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TimeZone getTimeZone() {
      return super.getTimeZone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Tag addClassTag(Class var1, Tag var2) {
      return super.addClassTag(var1, var2);
   }
}
