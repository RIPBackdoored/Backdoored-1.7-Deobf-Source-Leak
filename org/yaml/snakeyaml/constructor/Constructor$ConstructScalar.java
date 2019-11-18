package org.yaml.snakeyaml.constructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.Tag;

public class Constructor$ConstructScalar extends AbstractConstruct {
   // $FF: synthetic field
   final Constructor this$0;

   protected Constructor$ConstructScalar(Constructor this$0) {
      this.this$0 = this$0;
   }

   public Object construct(Node nnode) {
      ScalarNode node = (ScalarNode)nnode;
      Class type = node.getType();

      Object var10000;
      try {
         var10000 = this.this$0.newInstance(type, node, false);
      } catch (InstantiationException var15) {
         Object result;
         if (!type.isPrimitive() && type != String.class && !Number.class.isAssignableFrom(type) && type != Boolean.class && !Date.class.isAssignableFrom(type) && type != Character.class && type != BigInteger.class && type != BigDecimal.class && !Enum.class.isAssignableFrom(type) && !Tag.BINARY.equals(node.getTag()) && !Calendar.class.isAssignableFrom(type) && type != UUID.class) {
            java.lang.reflect.Constructor[] javaConstructors = type.getDeclaredConstructors();
            int oneArgCount = 0;
            java.lang.reflect.Constructor javaConstructor = null;
            java.lang.reflect.Constructor[] var8 = javaConstructors;
            int var9 = javaConstructors.length;

            for(int var10 = 0; var10 < var9; ++var10) {
               java.lang.reflect.Constructor c = var8[var10];
               if (c.getParameterTypes().length == 1) {
                  ++oneArgCount;
                  javaConstructor = c;
               }
            }

            if (javaConstructor == null) {
               try {
                  var10000 = this.this$0.newInstance(type, node, false);
               } catch (InstantiationException var12) {
                  throw new YAMLException("No single argument constructor found for " + type + " : " + var12.getMessage());
               }

               return var10000;
            }

            Object argument;
            if (oneArgCount == 1) {
               argument = this.constructStandardJavaInstance(javaConstructor.getParameterTypes()[0], node);
            } else {
               argument = this.this$0.constructScalar(node);

               try {
                  javaConstructor = type.getDeclaredConstructor(String.class);
               } catch (Exception var14) {
                  throw new YAMLException("Can't construct a java object for scalar " + node.getTag() + "; No String constructor found. Exception=" + var14.getMessage(), var14);
               }
            }

            try {
               javaConstructor.setAccessible(true);
               result = javaConstructor.newInstance(argument);
            } catch (Exception var13) {
               throw new ConstructorException((String)null, (Mark)null, "Can't construct a java object for scalar " + node.getTag() + "; exception=" + var13.getMessage(), node.getStartMark(), var13);
            }
         } else {
            result = this.constructStandardJavaInstance(type, node);
         }

         return result;
      }

      return var10000;
   }

   private Object constructStandardJavaInstance(Class type, ScalarNode node) {
      Object result;
      Construct doubleConstructor;
      if (type == String.class) {
         doubleConstructor = (Construct)this.this$0.yamlConstructors.get(Tag.STR);
         result = doubleConstructor.construct(node);
      } else if (type != Boolean.class && type != Boolean.TYPE) {
         if (type != Character.class && type != Character.TYPE) {
            if (Date.class.isAssignableFrom(type)) {
               doubleConstructor = (Construct)this.this$0.yamlConstructors.get(Tag.TIMESTAMP);
               Date date = (Date)doubleConstructor.construct(node);
               if (type == Date.class) {
                  result = date;
               } else {
                  try {
                     java.lang.reflect.Constructor constr = type.getConstructor(Long.TYPE);
                     result = constr.newInstance(date.getTime());
                  } catch (RuntimeException var8) {
                     throw var8;
                  } catch (Exception var9) {
                     throw new YAMLException("Cannot construct: '" + type + "'");
                  }
               }
            } else if (type != Float.class && type != Double.class && type != Float.TYPE && type != Double.TYPE && type != BigDecimal.class) {
               if (type != Byte.class && type != Short.class && type != Integer.class && type != Long.class && type != BigInteger.class && type != Byte.TYPE && type != Short.TYPE && type != Integer.TYPE && type != Long.TYPE) {
                  if (Enum.class.isAssignableFrom(type)) {
                     String enumValueName = node.getValue();

                     try {
                        result = Enum.valueOf(type, enumValueName);
                     } catch (Exception var7) {
                        throw new YAMLException("Unable to find enum value '" + enumValueName + "' for enum class: " + type.getName());
                     }
                  } else if (Calendar.class.isAssignableFrom(type)) {
                     SafeConstructor$ConstructYamlTimestamp contr = new SafeConstructor$ConstructYamlTimestamp();
                     contr.construct(node);
                     result = contr.getCalendar();
                  } else if (Number.class.isAssignableFrom(type)) {
                     SafeConstructor$ConstructYamlFloat contr = new SafeConstructor$ConstructYamlFloat(this.this$0);
                     result = contr.construct(node);
                  } else if (UUID.class == type) {
                     result = UUID.fromString(node.getValue());
                  } else {
                     if (!this.this$0.yamlConstructors.containsKey(node.getTag())) {
                        throw new YAMLException("Unsupported class: " + type);
                     }

                     result = ((Construct)this.this$0.yamlConstructors.get(node.getTag())).construct(node);
                  }
               } else {
                  doubleConstructor = (Construct)this.this$0.yamlConstructors.get(Tag.INT);
                  result = doubleConstructor.construct(node);
                  if (type != Byte.class && type != Byte.TYPE) {
                     if (type != Short.class && type != Short.TYPE) {
                        if (type != Integer.class && type != Integer.TYPE) {
                           if (type != Long.class && type != Long.TYPE) {
                              result = new BigInteger(result.toString());
                           } else {
                              result = Long.valueOf(result.toString());
                           }
                        } else {
                           result = Integer.parseInt(result.toString());
                        }
                     } else {
                        result = Short.valueOf(result.toString());
                     }
                  } else {
                     result = Byte.valueOf(result.toString());
                  }
               }
            } else if (type == BigDecimal.class) {
               result = new BigDecimal(node.getValue());
            } else {
               doubleConstructor = (Construct)this.this$0.yamlConstructors.get(Tag.FLOAT);
               result = doubleConstructor.construct(node);
               if (type == Float.class || type == Float.TYPE) {
                  result = new Float((Double)result);
               }
            }
         } else {
            doubleConstructor = (Construct)this.this$0.yamlConstructors.get(Tag.STR);
            String ch = (String)doubleConstructor.construct(node);
            if (ch.length() == 0) {
               result = null;
            } else {
               if (ch.length() != 1) {
                  throw new YAMLException("Invalid node Character: '" + ch + "'; length: " + ch.length());
               }

               result = ch.charAt(0);
            }
         }
      } else {
         doubleConstructor = (Construct)this.this$0.yamlConstructors.get(Tag.BOOL);
         result = doubleConstructor.construct(node);
      }

      return result;
   }
}
