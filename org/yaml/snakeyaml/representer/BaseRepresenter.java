package org.yaml.snakeyaml.representer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.yaml.snakeyaml.DumperOptions$FlowStyle;
import org.yaml.snakeyaml.DumperOptions$ScalarStyle;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

public abstract class BaseRepresenter {
   protected final Map representers = new HashMap();
   protected Represent nullRepresenter;
   protected final Map multiRepresenters = new LinkedHashMap();
   protected Character defaultScalarStyle;
   protected DumperOptions$FlowStyle defaultFlowStyle;
   protected final Map representedObjects;
   protected Object objectToRepresent;
   private PropertyUtils propertyUtils;
   private boolean explicitPropertyUtils;

   public BaseRepresenter() {
      this.defaultFlowStyle = DumperOptions$FlowStyle.AUTO;
      this.representedObjects = new BaseRepresenter$1(this);
      this.explicitPropertyUtils = false;
   }

   public Node represent(Object data) {
      Node node = this.representData(data);
      this.representedObjects.clear();
      this.objectToRepresent = null;
      return node;
   }

   protected final Node representData(Object data) {
      this.objectToRepresent = data;
      Node node;
      if (this.representedObjects.containsKey(this.objectToRepresent)) {
         node = (Node)this.representedObjects.get(this.objectToRepresent);
         return node;
      } else if (data == null) {
         node = this.nullRepresenter.representData((Object)null);
         return node;
      } else {
         Class clazz = data.getClass();
         Represent representer;
         if (this.representers.containsKey(clazz)) {
            representer = (Represent)this.representers.get(clazz);
            node = representer.representData(data);
         } else {
            Iterator var7 = this.multiRepresenters.keySet().iterator();

            while(var7.hasNext()) {
               Class repr = (Class)var7.next();
               if (repr != null && repr.isInstance(data)) {
                  Represent representer = (Represent)this.multiRepresenters.get(repr);
                  node = representer.representData(data);
                  return node;
               }
            }

            if (this.multiRepresenters.containsKey((Object)null)) {
               representer = (Represent)this.multiRepresenters.get((Object)null);
               node = representer.representData(data);
            } else {
               representer = (Represent)this.representers.get((Object)null);
               node = representer.representData(data);
            }
         }

         return node;
      }
   }

   protected Node representScalar(Tag tag, String value, Character style) {
      if (style == null) {
         style = this.defaultScalarStyle;
      }

      Node node = new ScalarNode(tag, value, (Mark)null, (Mark)null, style);
      return node;
   }

   protected Node representScalar(Tag tag, String value) {
      return this.representScalar(tag, value, (Character)null);
   }

   protected Node representSequence(Tag tag, Iterable sequence, Boolean flowStyle) {
      int size = 10;
      if (sequence instanceof List) {
         size = ((List)sequence).size();
      }

      List value = new ArrayList(size);
      SequenceNode node = new SequenceNode(tag, value, flowStyle);
      this.representedObjects.put(this.objectToRepresent, node);
      boolean bestStyle = true;

      Node nodeItem;
      for(Iterator var8 = sequence.iterator(); var8.hasNext(); value.add(nodeItem)) {
         Object item = var8.next();
         nodeItem = this.representData(item);
         if (!(nodeItem instanceof ScalarNode) || ((ScalarNode)nodeItem).getStyle() != null) {
            bestStyle = false;
         }
      }

      if (flowStyle == null) {
         if (this.defaultFlowStyle != DumperOptions$FlowStyle.AUTO) {
            node.setFlowStyle(this.defaultFlowStyle.getStyleBoolean());
         } else {
            node.setFlowStyle(bestStyle);
         }
      }

      return node;
   }

   protected Node representMapping(Tag tag, Map mapping, Boolean flowStyle) {
      List value = new ArrayList(mapping.size());
      MappingNode node = new MappingNode(tag, value, flowStyle);
      this.representedObjects.put(this.objectToRepresent, node);
      boolean bestStyle = true;

      Node nodeKey;
      Node nodeValue;
      for(Iterator var7 = mapping.entrySet().iterator(); var7.hasNext(); value.add(new NodeTuple(nodeKey, nodeValue))) {
         Entry entry = (Entry)var7.next();
         nodeKey = this.representData(entry.getKey());
         nodeValue = this.representData(entry.getValue());
         if (!(nodeKey instanceof ScalarNode) || ((ScalarNode)nodeKey).getStyle() != null) {
            bestStyle = false;
         }

         if (!(nodeValue instanceof ScalarNode) || ((ScalarNode)nodeValue).getStyle() != null) {
            bestStyle = false;
         }
      }

      if (flowStyle == null) {
         if (this.defaultFlowStyle != DumperOptions$FlowStyle.AUTO) {
            node.setFlowStyle(this.defaultFlowStyle.getStyleBoolean());
         } else {
            node.setFlowStyle(bestStyle);
         }
      }

      return node;
   }

   public void setDefaultScalarStyle(DumperOptions$ScalarStyle defaultStyle) {
      this.defaultScalarStyle = defaultStyle.getChar();
   }

   public DumperOptions$ScalarStyle getDefaultScalarStyle() {
      return DumperOptions$ScalarStyle.createStyle(this.defaultScalarStyle);
   }

   public void setDefaultFlowStyle(DumperOptions$FlowStyle defaultFlowStyle) {
      this.defaultFlowStyle = defaultFlowStyle;
   }

   public DumperOptions$FlowStyle getDefaultFlowStyle() {
      return this.defaultFlowStyle;
   }

   public void setPropertyUtils(PropertyUtils propertyUtils) {
      this.propertyUtils = propertyUtils;
      this.explicitPropertyUtils = true;
   }

   public final PropertyUtils getPropertyUtils() {
      if (this.propertyUtils == null) {
         this.propertyUtils = new PropertyUtils();
      }

      return this.propertyUtils;
   }

   public final boolean isExplicitPropertyUtils() {
      return this.explicitPropertyUtils;
   }
}
