package org.spongepowered.asm.util;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.spongepowered.asm.lib.signature.SignatureReader;
import org.spongepowered.asm.lib.signature.SignatureVisitor;
import org.spongepowered.asm.lib.tree.ClassNode;

public class ClassSignature {
   protected static final String OBJECT = "java/lang/Object";
   private final Map types = new LinkedHashMap();
   private ClassSignature$Token superClass = new ClassSignature$Token("java/lang/Object");
   private final List interfaces = new ArrayList();
   private final Deque rawInterfaces = new LinkedList();

   ClassSignature() {
   }

   private ClassSignature read(String signature) {
      if (signature != null) {
         try {
            (new SignatureReader(signature)).accept(new ClassSignature$SignatureParser(this));
         } catch (Exception var3) {
            var3.printStackTrace();
         }
      }

      return this;
   }

   protected ClassSignature$TypeVar getTypeVar(String varName) {
      Iterator var2 = this.types.keySet().iterator();

      ClassSignature$TypeVar typeVar;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         typeVar = (ClassSignature$TypeVar)var2.next();
      } while(!typeVar.matches(varName));

      return typeVar;
   }

   protected ClassSignature$TokenHandle getType(String varName) {
      Iterator var2 = this.types.keySet().iterator();

      ClassSignature$TypeVar typeVar;
      do {
         if (!var2.hasNext()) {
            ClassSignature$TokenHandle handle = new ClassSignature$TokenHandle(this);
            this.types.put(new ClassSignature$TypeVar(varName), handle);
            return handle;
         }

         typeVar = (ClassSignature$TypeVar)var2.next();
      } while(!typeVar.matches(varName));

      return (ClassSignature$TokenHandle)this.types.get(typeVar);
   }

   protected String getTypeVar(ClassSignature$TokenHandle handle) {
      Iterator var2 = this.types.entrySet().iterator();

      ClassSignature$TypeVar typeVar;
      ClassSignature$TokenHandle typeHandle;
      do {
         if (!var2.hasNext()) {
            return handle.token.asType();
         }

         Entry type = (Entry)var2.next();
         typeVar = (ClassSignature$TypeVar)type.getKey();
         typeHandle = (ClassSignature$TokenHandle)type.getValue();
      } while(handle != typeHandle && handle.asToken() != typeHandle.asToken());

      return "T" + typeVar + ";";
   }

   protected void addTypeVar(ClassSignature$TypeVar typeVar, ClassSignature$TokenHandle handle) throws IllegalArgumentException {
      if (this.types.containsKey(typeVar)) {
         throw new IllegalArgumentException("TypeVar " + typeVar + " is already present on " + this);
      } else {
         this.types.put(typeVar, handle);
      }
   }

   protected void setSuperClass(ClassSignature$Token superClass) {
      this.superClass = superClass;
   }

   public String getSuperClass() {
      return this.superClass.asType(true);
   }

   protected void addInterface(ClassSignature$Token iface) {
      if (!iface.isRaw()) {
         String raw = iface.asType(true);
         ListIterator iter = this.interfaces.listIterator();

         while(iter.hasNext()) {
            ClassSignature$Token intrface = (ClassSignature$Token)iter.next();
            if (intrface.isRaw() && intrface.asType(true).equals(raw)) {
               iter.set(iface);
               return;
            }
         }
      }

      this.interfaces.add(iface);
   }

   public void addInterface(String iface) {
      this.rawInterfaces.add(iface);
   }

   protected void addRawInterface(String iface) {
      ClassSignature$Token token = new ClassSignature$Token(iface);
      String raw = token.asType(true);
      Iterator var4 = this.interfaces.iterator();

      ClassSignature$Token intrface;
      do {
         if (!var4.hasNext()) {
            this.interfaces.add(token);
            return;
         }

         intrface = (ClassSignature$Token)var4.next();
      } while(!intrface.asType(true).equals(raw));

   }

   public void merge(ClassSignature other) {
      try {
         Set typeVars = new HashSet();
         Iterator var3 = this.types.keySet().iterator();

         while(true) {
            if (!var3.hasNext()) {
               other.conform(typeVars);
               break;
            }

            ClassSignature$TypeVar typeVar = (ClassSignature$TypeVar)var3.next();
            typeVars.add(typeVar.toString());
         }
      } catch (IllegalStateException var5) {
         var5.printStackTrace();
         return;
      }

      Iterator var6 = other.types.entrySet().iterator();

      while(var6.hasNext()) {
         Entry type = (Entry)var6.next();
         this.addTypeVar((ClassSignature$TypeVar)type.getKey(), (ClassSignature$TokenHandle)type.getValue());
      }

      var6 = other.interfaces.iterator();

      while(var6.hasNext()) {
         ClassSignature$Token iface = (ClassSignature$Token)var6.next();
         this.addInterface(iface);
      }

   }

   private void conform(Set typeVars) {
      Iterator var2 = this.types.keySet().iterator();

      while(var2.hasNext()) {
         ClassSignature$TypeVar typeVar = (ClassSignature$TypeVar)var2.next();
         String name = this.findUniqueName(typeVar.getOriginalName(), typeVars);
         typeVar.rename(name);
         typeVars.add(name);
      }

   }

   private String findUniqueName(String typeVar, Set typeVars) {
      if (!typeVars.contains(typeVar)) {
         return typeVar;
      } else {
         String name;
         if (typeVar.length() == 1) {
            name = this.findOffsetName(typeVar.charAt(0), typeVars);
            if (name != null) {
               return name;
            }
         }

         name = this.findOffsetName('T', typeVars, "", typeVar);
         if (name != null) {
            return name;
         } else {
            name = this.findOffsetName('T', typeVars, typeVar, "");
            if (name != null) {
               return name;
            } else {
               name = this.findOffsetName('T', typeVars, "T", typeVar);
               if (name != null) {
                  return name;
               } else {
                  name = this.findOffsetName('T', typeVars, "", typeVar + "Type");
                  if (name != null) {
                     return name;
                  } else {
                     throw new IllegalStateException("Failed to conform type var: " + typeVar);
                  }
               }
            }
         }
      }
   }

   private String findOffsetName(char c, Set typeVars) {
      return this.findOffsetName(c, typeVars, "", "");
   }

   private String findOffsetName(char c, Set typeVars, String prefix, String suffix) {
      String name = String.format("%s%s%s", prefix, c, suffix);
      if (!typeVars.contains(name)) {
         return name;
      } else {
         if (c > '@' && c < '[') {
            for(int s = c - 64; s + 65 != c; s %= 26) {
               name = String.format("%s%s%s", prefix, (char)(s + 65), suffix);
               if (!typeVars.contains(name)) {
                  return name;
               }

               ++s;
            }
         }

         return null;
      }
   }

   public SignatureVisitor getRemapper() {
      return new ClassSignature$SignatureRemapper(this);
   }

   public String toString() {
      while(this.rawInterfaces.size() > 0) {
         this.addRawInterface((String)this.rawInterfaces.remove());
      }

      StringBuilder sb = new StringBuilder();
      if (this.types.size() > 0) {
         boolean valid = false;
         StringBuilder types = new StringBuilder();
         Iterator var4 = this.types.entrySet().iterator();

         while(var4.hasNext()) {
            Entry type = (Entry)var4.next();
            String bound = ((ClassSignature$TokenHandle)type.getValue()).asBound();
            if (!bound.isEmpty()) {
               types.append(type.getKey()).append(':').append(bound);
               valid = true;
            }
         }

         if (valid) {
            sb.append('<').append(types).append('>');
         }
      }

      sb.append(this.superClass.asType());
      Iterator var7 = this.interfaces.iterator();

      while(var7.hasNext()) {
         ClassSignature$Token iface = (ClassSignature$Token)var7.next();
         sb.append(iface.asType());
      }

      return sb.toString();
   }

   public ClassSignature wake() {
      return this;
   }

   public static ClassSignature of(String signature) {
      return (new ClassSignature()).read(signature);
   }

   public static ClassSignature of(ClassNode classNode) {
      return classNode.signature != null ? of(classNode.signature) : generate(classNode);
   }

   public static ClassSignature ofLazy(ClassNode classNode) {
      return (ClassSignature)(classNode.signature != null ? new ClassSignature$Lazy(classNode.signature) : generate(classNode));
   }

   private static ClassSignature generate(ClassNode classNode) {
      ClassSignature generated = new ClassSignature();
      generated.setSuperClass(new ClassSignature$Token(classNode.superName != null ? classNode.superName : "java/lang/Object"));
      Iterator var2 = classNode.interfaces.iterator();

      while(var2.hasNext()) {
         String iface = (String)var2.next();
         generated.addInterface(new ClassSignature$Token(iface));
      }

      return generated;
   }
}
