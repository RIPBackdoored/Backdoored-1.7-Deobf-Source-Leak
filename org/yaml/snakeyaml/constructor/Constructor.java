package org.yaml.snakeyaml.constructor;

import java.util.Collection;
import java.util.Iterator;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.Tag;

public class Constructor extends SafeConstructor {
   public Constructor() {
      this(Object.class);
   }

   public Constructor(Class theRoot) {
      this(new TypeDescription(checkRoot(theRoot)));
   }

   private static Class checkRoot(Class theRoot) {
      if (theRoot == null) {
         throw new NullPointerException("Root class must be provided.");
      } else {
         return theRoot;
      }
   }

   public Constructor(TypeDescription theRoot) {
      this(theRoot, (Collection)null);
   }

   public Constructor(TypeDescription theRoot, Collection moreTDs) {
      if (theRoot == null) {
         throw new NullPointerException("Root type must be provided.");
      } else {
         this.yamlConstructors.put((Object)null, new Constructor$ConstructYamlObject(this));
         if (!Object.class.equals(theRoot.getType())) {
            this.rootTag = new Tag(theRoot.getType());
         }

         this.yamlClassConstructors.put(NodeId.scalar, new Constructor$ConstructScalar(this));
         this.yamlClassConstructors.put(NodeId.mapping, new Constructor$ConstructMapping(this));
         this.yamlClassConstructors.put(NodeId.sequence, new Constructor$ConstructSequence(this));
         this.addTypeDescription(theRoot);
         if (moreTDs != null) {
            Iterator var3 = moreTDs.iterator();

            while(var3.hasNext()) {
               TypeDescription td = (TypeDescription)var3.next();
               this.addTypeDescription(td);
            }
         }

      }
   }

   public Constructor(String theRoot) throws ClassNotFoundException {
      this(Class.forName(check(theRoot)));
   }

   private static final String check(String s) {
      if (s == null) {
         throw new NullPointerException("Root type must be provided.");
      } else if (s.trim().length() == 0) {
         throw new YAMLException("Root type must be provided.");
      } else {
         return s;
      }
   }

   protected Class getClassForNode(Node node) {
      Class classForTag = (Class)this.typeTags.get(node.getTag());
      if (classForTag == null) {
         String name = node.getTag().getClassName();

         Class cl;
         try {
            cl = this.getClassForName(name);
         } catch (ClassNotFoundException var6) {
            throw new YAMLException("Class not found: " + name);
         }

         this.typeTags.put(node.getTag(), cl);
         return cl;
      } else {
         return classForTag;
      }
   }

   protected Class getClassForName(String name) throws ClassNotFoundException {
      Class var10000;
      try {
         var10000 = Class.forName(name, true, Thread.currentThread().getContextClassLoader());
      } catch (ClassNotFoundException var3) {
         return Class.forName(name);
      }

      return var10000;
   }
}
