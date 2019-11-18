package org.yaml.snakeyaml.constructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.SequenceNode;

public class Constructor$ConstructSequence implements Construct {
   // $FF: synthetic field
   final Constructor this$0;

   protected Constructor$ConstructSequence(Constructor this$0) {
      this.this$0 = this$0;
   }

   public Object construct(Node node) {
      SequenceNode snode = (SequenceNode)node;
      if (Set.class.isAssignableFrom(node.getType())) {
         if (node.isTwoStepsConstruction()) {
            throw new YAMLException("Set cannot be recursive.");
         } else {
            return this.this$0.constructSet(snode);
         }
      } else if (Collection.class.isAssignableFrom(node.getType())) {
         return node.isTwoStepsConstruction() ? this.this$0.newList(snode) : this.this$0.constructSequence(snode);
      } else if (node.getType().isArray()) {
         return node.isTwoStepsConstruction() ? this.this$0.createArray(node.getType(), snode.getValue().size()) : this.this$0.constructArray(snode);
      } else {
         List possibleConstructors = new ArrayList(snode.getValue().size());
         java.lang.reflect.Constructor[] var4 = node.getType().getDeclaredConstructors();
         int var5 = var4.length;

         int index;
         for(index = 0; index < var5; ++index) {
            java.lang.reflect.Constructor constructor = var4[index];
            if (snode.getValue().size() == constructor.getParameterTypes().length) {
               possibleConstructors.add(constructor);
            }
         }

         if (!possibleConstructors.isEmpty()) {
            Object var10000;
            Iterator var18;
            if (possibleConstructors.size() == 1) {
               Object[] argumentList = new Object[snode.getValue().size()];
               java.lang.reflect.Constructor c = (java.lang.reflect.Constructor)possibleConstructors.get(0);
               index = 0;

               Node argumentNode;
               for(var18 = snode.getValue().iterator(); var18.hasNext(); argumentList[index++] = this.this$0.constructObject(argumentNode)) {
                  argumentNode = (Node)var18.next();
                  Class type = c.getParameterTypes()[index];
                  argumentNode.setType(type);
               }

               try {
                  c.setAccessible(true);
                  var10000 = c.newInstance(argumentList);
               } catch (Exception var12) {
                  throw new YAMLException(var12);
               }

               return var10000;
            }

            List argumentList = this.this$0.constructSequence(snode);
            Class[] parameterTypes = new Class[argumentList.size()];
            index = 0;

            for(var18 = argumentList.iterator(); var18.hasNext(); ++index) {
               Object parameter = var18.next();
               parameterTypes[index] = parameter.getClass();
            }

            var18 = possibleConstructors.iterator();

            while(var18.hasNext()) {
               java.lang.reflect.Constructor c = (java.lang.reflect.Constructor)var18.next();
               Class[] argTypes = c.getParameterTypes();
               boolean foundConstructor = true;

               for(int i = 0; i < argTypes.length; ++i) {
                  if (!this.wrapIfPrimitive(argTypes[i]).isAssignableFrom(parameterTypes[i])) {
                     foundConstructor = false;
                     break;
                  }
               }

               if (foundConstructor) {
                  try {
                     c.setAccessible(true);
                     var10000 = c.newInstance(argumentList.toArray());
                  } catch (Exception var13) {
                     throw new YAMLException(var13);
                  }

                  return var10000;
               }
            }
         }

         throw new YAMLException("No suitable constructor with " + String.valueOf(snode.getValue().size()) + " arguments found for " + node.getType());
      }
   }

   private final Class wrapIfPrimitive(Class clazz) {
      if (!clazz.isPrimitive()) {
         return clazz;
      } else if (clazz == Integer.TYPE) {
         return Integer.class;
      } else if (clazz == Float.TYPE) {
         return Float.class;
      } else if (clazz == Double.TYPE) {
         return Double.class;
      } else if (clazz == Boolean.TYPE) {
         return Boolean.class;
      } else if (clazz == Long.TYPE) {
         return Long.class;
      } else if (clazz == Character.TYPE) {
         return Character.class;
      } else if (clazz == Short.TYPE) {
         return Short.class;
      } else if (clazz == Byte.TYPE) {
         return Byte.class;
      } else {
         throw new YAMLException("Unexpected primitive " + clazz);
      }
   }

   public void construct2ndStep(Node node, Object object) {
      SequenceNode snode = (SequenceNode)node;
      if (List.class.isAssignableFrom(node.getType())) {
         List list = (List)object;
         this.this$0.constructSequenceStep2(snode, list);
      } else {
         if (!node.getType().isArray()) {
            throw new YAMLException("Immutable objects cannot be recursive.");
         }

         this.this$0.constructArrayStep2(snode, object);
      }

   }
}
