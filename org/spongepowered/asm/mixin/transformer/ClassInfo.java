package org.spongepowered.asm.mixin.transformer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.service.MixinService;
import org.spongepowered.asm.util.ClassSignature;
import org.spongepowered.asm.util.perf.Profiler;
import org.spongepowered.asm.util.perf.Profiler$Section;

public final class ClassInfo {
   public static final int INCLUDE_PRIVATE = 2;
   public static final int INCLUDE_STATIC = 8;
   public static final int INCLUDE_ALL = 10;
   private static final Logger logger = LogManager.getLogger("mixin");
   private static final Profiler profiler = MixinEnvironment.getProfiler();
   private static final String JAVA_LANG_OBJECT = "java/lang/Object";
   private static final Map cache = new HashMap();
   private static final ClassInfo OBJECT = new ClassInfo();
   private final String name;
   private final String superName;
   private final String outerName;
   private final boolean isProbablyStatic;
   private final Set interfaces;
   private final Set methods;
   private final Set fields;
   private final Set mixins = new HashSet();
   private final Map correspondingTypes = new HashMap();
   private final MixinInfo mixin;
   private final MethodMapper methodMapper;
   private final boolean isMixin;
   private final boolean isInterface;
   private final int access;
   private ClassInfo superClass;
   private ClassInfo outerClass;
   private ClassSignature signature;

   private ClassInfo() {
      this.name = "java/lang/Object";
      this.superName = null;
      this.outerName = null;
      this.isProbablyStatic = true;
      this.methods = ImmutableSet.of(new ClassInfo$Method(this, "getClass", "()Ljava/lang/Class;"), new ClassInfo$Method(this, "hashCode", "()I"), new ClassInfo$Method(this, "equals", "(Ljava/lang/Object;)Z"), new ClassInfo$Method(this, "clone", "()Ljava/lang/Object;"), new ClassInfo$Method(this, "toString", "()Ljava/lang/String;"), new ClassInfo$Method(this, "notify", "()V"), new ClassInfo$Method[]{new ClassInfo$Method(this, "notifyAll", "()V"), new ClassInfo$Method(this, "wait", "(J)V"), new ClassInfo$Method(this, "wait", "(JI)V"), new ClassInfo$Method(this, "wait", "()V"), new ClassInfo$Method(this, "finalize", "()V")});
      this.fields = Collections.emptySet();
      this.isInterface = false;
      this.interfaces = Collections.emptySet();
      this.access = 1;
      this.isMixin = false;
      this.mixin = null;
      this.methodMapper = null;
   }

   private ClassInfo(ClassNode classNode) {
      Profiler$Section timer = profiler.begin(1, (String)"class.meta");

      try {
         this.name = classNode.name;
         this.superName = classNode.superName != null ? classNode.superName : "java/lang/Object";
         this.methods = new HashSet();
         this.fields = new HashSet();
         this.isInterface = (classNode.access & 512) != 0;
         this.interfaces = new HashSet();
         this.access = classNode.access;
         this.isMixin = classNode instanceof MixinInfo$MixinClassNode;
         this.mixin = this.isMixin ? ((MixinInfo$MixinClassNode)classNode).getMixin() : null;
         this.interfaces.addAll(classNode.interfaces);
         Iterator var3 = classNode.methods.iterator();

         while(var3.hasNext()) {
            MethodNode method = (MethodNode)var3.next();
            this.addMethod(method, this.isMixin);
         }

         boolean isProbablyStatic = true;
         String outerName = classNode.outerClass;

         FieldNode field;
         for(Iterator var5 = classNode.fields.iterator(); var5.hasNext(); this.fields.add(new ClassInfo$Field(this, field, this.isMixin))) {
            field = (FieldNode)var5.next();
            if ((field.access & 4096) != 0 && field.name.startsWith("this$")) {
               isProbablyStatic = false;
               if (outerName == null) {
                  outerName = field.desc;
                  if (outerName != null && outerName.startsWith("L")) {
                     outerName = outerName.substring(1, outerName.length() - 1);
                  }
               }
            }
         }

         this.isProbablyStatic = isProbablyStatic;
         this.outerName = outerName;
         this.methodMapper = new MethodMapper(MixinEnvironment.getCurrentEnvironment(), this);
         this.signature = ClassSignature.ofLazy(classNode);
      } finally {
         timer.end();
      }

   }

   void addInterface(String iface) {
      this.interfaces.add(iface);
      this.getSignature().addInterface(iface);
   }

   void addMethod(MethodNode method) {
      this.addMethod(method, true);
   }

   private void addMethod(MethodNode method, boolean injected) {
      if (!method.name.startsWith("<")) {
         this.methods.add(new ClassInfo$Method(this, method, injected));
      }

   }

   void addMixin(MixinInfo mixin) {
      if (this.isMixin) {
         throw new IllegalArgumentException("Cannot add target " + this.name + " for " + mixin.getClassName() + " because the target is a mixin");
      } else {
         this.mixins.add(mixin);
      }
   }

   public Set getMixins() {
      return Collections.unmodifiableSet(this.mixins);
   }

   public boolean isMixin() {
      return this.isMixin;
   }

   public boolean isPublic() {
      return (this.access & 1) != 0;
   }

   public boolean isAbstract() {
      return (this.access & 1024) != 0;
   }

   public boolean isSynthetic() {
      return (this.access & 4096) != 0;
   }

   public boolean isProbablyStatic() {
      return this.isProbablyStatic;
   }

   public boolean isInner() {
      return this.outerName != null;
   }

   public boolean isInterface() {
      return this.isInterface;
   }

   public Set getInterfaces() {
      return Collections.unmodifiableSet(this.interfaces);
   }

   public String toString() {
      return this.name;
   }

   public MethodMapper getMethodMapper() {
      return this.methodMapper;
   }

   public int getAccess() {
      return this.access;
   }

   public String getName() {
      return this.name;
   }

   public String getClassName() {
      return this.name.replace('/', '.');
   }

   public String getSuperName() {
      return this.superName;
   }

   public ClassInfo getSuperClass() {
      if (this.superClass == null && this.superName != null) {
         this.superClass = forName(this.superName);
      }

      return this.superClass;
   }

   public String getOuterName() {
      return this.outerName;
   }

   public ClassInfo getOuterClass() {
      if (this.outerClass == null && this.outerName != null) {
         this.outerClass = forName(this.outerName);
      }

      return this.outerClass;
   }

   public ClassSignature getSignature() {
      return this.signature.wake();
   }

   List getTargets() {
      if (this.mixin != null) {
         List targets = new ArrayList();
         targets.add(this);
         targets.addAll(this.mixin.getTargets());
         return targets;
      } else {
         return ImmutableList.of(this);
      }
   }

   public Set getMethods() {
      return Collections.unmodifiableSet(this.methods);
   }

   public Set getInterfaceMethods(boolean includeMixins) {
      Set methods = new HashSet();
      ClassInfo supClass = this.addMethodsRecursive(methods, includeMixins);
      if (!this.isInterface) {
         while(supClass != null && supClass != OBJECT) {
            supClass = supClass.addMethodsRecursive(methods, includeMixins);
         }
      }

      Iterator it = methods.iterator();

      while(it.hasNext()) {
         if (!((ClassInfo$Method)it.next()).isAbstract()) {
            it.remove();
         }
      }

      return Collections.unmodifiableSet(methods);
   }

   private ClassInfo addMethodsRecursive(Set methods, boolean includeMixins) {
      Iterator var3;
      ClassInfo$Method method;
      if (this.isInterface) {
         for(var3 = this.methods.iterator(); var3.hasNext(); methods.add(method)) {
            method = (ClassInfo$Method)var3.next();
            if (!method.isAbstract()) {
               methods.remove(method);
            }
         }
      } else if (!this.isMixin && includeMixins) {
         var3 = this.mixins.iterator();

         while(var3.hasNext()) {
            MixinInfo mixin = (MixinInfo)var3.next();
            mixin.getClassInfo().addMethodsRecursive(methods, includeMixins);
         }
      }

      var3 = this.interfaces.iterator();

      while(var3.hasNext()) {
         String iface = (String)var3.next();
         forName(iface).addMethodsRecursive(methods, includeMixins);
      }

      return this.getSuperClass();
   }

   public boolean hasSuperClass(String superClass) {
      return this.hasSuperClass(superClass, ClassInfo$Traversal.NONE);
   }

   public boolean hasSuperClass(String superClass, ClassInfo$Traversal traversal) {
      if ("java/lang/Object".equals(superClass)) {
         return true;
      } else {
         return this.findSuperClass(superClass, traversal) != null;
      }
   }

   public boolean hasSuperClass(ClassInfo superClass) {
      return this.hasSuperClass(superClass, ClassInfo$Traversal.NONE, false);
   }

   public boolean hasSuperClass(ClassInfo superClass, ClassInfo$Traversal traversal) {
      return this.hasSuperClass(superClass, traversal, false);
   }

   public boolean hasSuperClass(ClassInfo superClass, ClassInfo$Traversal traversal, boolean includeInterfaces) {
      if (OBJECT == superClass) {
         return true;
      } else {
         return this.findSuperClass(superClass.name, traversal, includeInterfaces) != null;
      }
   }

   public ClassInfo findSuperClass(String superClass) {
      return this.findSuperClass(superClass, ClassInfo$Traversal.NONE);
   }

   public ClassInfo findSuperClass(String superClass, ClassInfo$Traversal traversal) {
      return this.findSuperClass(superClass, traversal, false, new HashSet());
   }

   public ClassInfo findSuperClass(String superClass, ClassInfo$Traversal traversal, boolean includeInterfaces) {
      return OBJECT.name.equals(superClass) ? null : this.findSuperClass(superClass, traversal, includeInterfaces, new HashSet());
   }

   private ClassInfo findSuperClass(String superClass, ClassInfo$Traversal traversal, boolean includeInterfaces, Set traversed) {
      ClassInfo superClassInfo = this.getSuperClass();
      Iterator var6;
      if (superClassInfo != null) {
         var6 = superClassInfo.getTargets().iterator();

         while(var6.hasNext()) {
            ClassInfo superTarget = (ClassInfo)var6.next();
            if (superClass.equals(superTarget.getName())) {
               return superClassInfo;
            }

            ClassInfo found = superTarget.findSuperClass(superClass, traversal.next(), includeInterfaces, traversed);
            if (found != null) {
               return found;
            }
         }
      }

      if (includeInterfaces) {
         ClassInfo iface = this.findInterface(superClass);
         if (iface != null) {
            return iface;
         }
      }

      if (traversal.canTraverse()) {
         var6 = this.mixins.iterator();

         while(var6.hasNext()) {
            MixinInfo mixin = (MixinInfo)var6.next();
            String mixinClassName = mixin.getClassName();
            if (!traversed.contains(mixinClassName)) {
               traversed.add(mixinClassName);
               ClassInfo mixinClass = mixin.getClassInfo();
               if (superClass.equals(mixinClass.getName())) {
                  return mixinClass;
               }

               ClassInfo targetSuper = mixinClass.findSuperClass(superClass, ClassInfo$Traversal.ALL, includeInterfaces, traversed);
               if (targetSuper != null) {
                  return targetSuper;
               }
            }
         }
      }

      return null;
   }

   private ClassInfo findInterface(String superClass) {
      Iterator var2 = this.getInterfaces().iterator();

      ClassInfo superIface;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         String ifaceName = (String)var2.next();
         ClassInfo iface = forName(ifaceName);
         if (superClass.equals(ifaceName)) {
            return iface;
         }

         superIface = iface.findInterface(superClass);
      } while(superIface == null);

      return superIface;
   }

   ClassInfo findCorrespondingType(ClassInfo mixin) {
      if (mixin != null && mixin.isMixin && !this.isMixin) {
         ClassInfo correspondingType = (ClassInfo)this.correspondingTypes.get(mixin);
         if (correspondingType == null) {
            correspondingType = this.findSuperTypeForMixin(mixin);
            this.correspondingTypes.put(mixin, correspondingType);
         }

         return correspondingType;
      } else {
         return null;
      }
   }

   private ClassInfo findSuperTypeForMixin(ClassInfo mixin) {
      for(ClassInfo superClass = this; superClass != null && superClass != OBJECT; superClass = superClass.getSuperClass()) {
         Iterator var3 = superClass.mixins.iterator();

         while(var3.hasNext()) {
            MixinInfo minion = (MixinInfo)var3.next();
            if (minion.getClassInfo().equals(mixin)) {
               return superClass;
            }
         }
      }

      return null;
   }

   public boolean hasMixinInHierarchy() {
      if (!this.isMixin) {
         return false;
      } else {
         for(ClassInfo supClass = this.getSuperClass(); supClass != null && supClass != OBJECT; supClass = supClass.getSuperClass()) {
            if (supClass.isMixin) {
               return true;
            }
         }

         return false;
      }
   }

   public boolean hasMixinTargetInHierarchy() {
      if (this.isMixin) {
         return false;
      } else {
         for(ClassInfo supClass = this.getSuperClass(); supClass != null && supClass != OBJECT; supClass = supClass.getSuperClass()) {
            if (supClass.mixins.size() > 0) {
               return true;
            }
         }

         return false;
      }
   }

   public ClassInfo$Method findMethodInHierarchy(MethodNode method, ClassInfo$SearchType searchType) {
      return this.findMethodInHierarchy(method.name, method.desc, searchType, ClassInfo$Traversal.NONE);
   }

   public ClassInfo$Method findMethodInHierarchy(MethodNode method, ClassInfo$SearchType searchType, int flags) {
      return this.findMethodInHierarchy(method.name, method.desc, searchType, ClassInfo$Traversal.NONE, flags);
   }

   public ClassInfo$Method findMethodInHierarchy(MethodInsnNode method, ClassInfo$SearchType searchType) {
      return this.findMethodInHierarchy(method.name, method.desc, searchType, ClassInfo$Traversal.NONE);
   }

   public ClassInfo$Method findMethodInHierarchy(MethodInsnNode method, ClassInfo$SearchType searchType, int flags) {
      return this.findMethodInHierarchy(method.name, method.desc, searchType, ClassInfo$Traversal.NONE, flags);
   }

   public ClassInfo$Method findMethodInHierarchy(String name, String desc, ClassInfo$SearchType searchType) {
      return this.findMethodInHierarchy(name, desc, searchType, ClassInfo$Traversal.NONE);
   }

   public ClassInfo$Method findMethodInHierarchy(String name, String desc, ClassInfo$SearchType searchType, ClassInfo$Traversal traversal) {
      return this.findMethodInHierarchy(name, desc, searchType, traversal, 0);
   }

   public ClassInfo$Method findMethodInHierarchy(String name, String desc, ClassInfo$SearchType searchType, ClassInfo$Traversal traversal, int flags) {
      return (ClassInfo$Method)this.findInHierarchy(name, desc, searchType, traversal, flags, ClassInfo$Member$Type.METHOD);
   }

   public ClassInfo$Field findFieldInHierarchy(FieldNode field, ClassInfo$SearchType searchType) {
      return this.findFieldInHierarchy(field.name, field.desc, searchType, ClassInfo$Traversal.NONE);
   }

   public ClassInfo$Field findFieldInHierarchy(FieldNode field, ClassInfo$SearchType searchType, int flags) {
      return this.findFieldInHierarchy(field.name, field.desc, searchType, ClassInfo$Traversal.NONE, flags);
   }

   public ClassInfo$Field findFieldInHierarchy(FieldInsnNode field, ClassInfo$SearchType searchType) {
      return this.findFieldInHierarchy(field.name, field.desc, searchType, ClassInfo$Traversal.NONE);
   }

   public ClassInfo$Field findFieldInHierarchy(FieldInsnNode field, ClassInfo$SearchType searchType, int flags) {
      return this.findFieldInHierarchy(field.name, field.desc, searchType, ClassInfo$Traversal.NONE, flags);
   }

   public ClassInfo$Field findFieldInHierarchy(String name, String desc, ClassInfo$SearchType searchType) {
      return this.findFieldInHierarchy(name, desc, searchType, ClassInfo$Traversal.NONE);
   }

   public ClassInfo$Field findFieldInHierarchy(String name, String desc, ClassInfo$SearchType searchType, ClassInfo$Traversal traversal) {
      return this.findFieldInHierarchy(name, desc, searchType, traversal, 0);
   }

   public ClassInfo$Field findFieldInHierarchy(String name, String desc, ClassInfo$SearchType searchType, ClassInfo$Traversal traversal, int flags) {
      return (ClassInfo$Field)this.findInHierarchy(name, desc, searchType, traversal, flags, ClassInfo$Member$Type.FIELD);
   }

   private ClassInfo$Member findInHierarchy(String name, String desc, ClassInfo$SearchType searchType, ClassInfo$Traversal traversal, int flags, ClassInfo$Member$Type type) {
      Iterator var8;
      ClassInfo$Member mixinMember;
      if (searchType == ClassInfo$SearchType.ALL_CLASSES) {
         ClassInfo$Member member = this.findMember(name, desc, flags, type);
         if (member != null) {
            return member;
         }

         if (traversal.canTraverse()) {
            var8 = this.mixins.iterator();

            while(var8.hasNext()) {
               MixinInfo mixin = (MixinInfo)var8.next();
               mixinMember = mixin.getClassInfo().findMember(name, desc, flags, type);
               if (mixinMember != null) {
                  return this.cloneMember(mixinMember);
               }
            }
         }
      }

      ClassInfo superClassInfo = this.getSuperClass();
      if (superClassInfo != null) {
         var8 = superClassInfo.getTargets().iterator();

         while(var8.hasNext()) {
            ClassInfo superTarget = (ClassInfo)var8.next();
            mixinMember = superTarget.findInHierarchy(name, desc, ClassInfo$SearchType.ALL_CLASSES, traversal.next(), flags & -3, type);
            if (mixinMember != null) {
               return mixinMember;
            }
         }
      }

      if (type == ClassInfo$Member$Type.METHOD && (this.isInterface || MixinEnvironment.getCompatibilityLevel().supportsMethodsInInterfaces())) {
         var8 = this.interfaces.iterator();

         while(var8.hasNext()) {
            String implemented = (String)var8.next();
            ClassInfo iface = forName(implemented);
            if (iface == null) {
               logger.debug("Failed to resolve declared interface {} on {}", new Object[]{implemented, this.name});
            } else {
               ClassInfo$Member member = iface.findInHierarchy(name, desc, ClassInfo$SearchType.ALL_CLASSES, traversal.next(), flags & -3, type);
               if (member != null) {
                  return (ClassInfo$Member)(this.isInterface ? member : new ClassInfo$InterfaceMethod(this, member));
               }
            }
         }
      }

      return null;
   }

   private ClassInfo$Member cloneMember(ClassInfo$Member member) {
      return (ClassInfo$Member)(member instanceof ClassInfo$Method ? new ClassInfo$Method(this, member) : new ClassInfo$Field(this, member));
   }

   public ClassInfo$Method findMethod(MethodNode method) {
      return this.findMethod(method.name, method.desc, method.access);
   }

   public ClassInfo$Method findMethod(MethodNode method, int flags) {
      return this.findMethod(method.name, method.desc, flags);
   }

   public ClassInfo$Method findMethod(MethodInsnNode method) {
      return this.findMethod(method.name, method.desc, 0);
   }

   public ClassInfo$Method findMethod(MethodInsnNode method, int flags) {
      return this.findMethod(method.name, method.desc, flags);
   }

   public ClassInfo$Method findMethod(String name, String desc, int flags) {
      return (ClassInfo$Method)this.findMember(name, desc, flags, ClassInfo$Member$Type.METHOD);
   }

   public ClassInfo$Field findField(FieldNode field) {
      return this.findField(field.name, field.desc, field.access);
   }

   public ClassInfo$Field findField(FieldInsnNode field, int flags) {
      return this.findField(field.name, field.desc, flags);
   }

   public ClassInfo$Field findField(String name, String desc, int flags) {
      return (ClassInfo$Field)this.findMember(name, desc, flags, ClassInfo$Member$Type.FIELD);
   }

   private ClassInfo$Member findMember(String name, String desc, int flags, ClassInfo$Member$Type memberType) {
      Set members = memberType == ClassInfo$Member$Type.METHOD ? this.methods : this.fields;
      Iterator var6 = members.iterator();

      ClassInfo$Member member;
      do {
         if (!var6.hasNext()) {
            return null;
         }

         member = (ClassInfo$Member)var6.next();
      } while(!member.equals(name, desc) || !member.matchesFlags(flags));

      return member;
   }

   public boolean equals(Object other) {
      return !(other instanceof ClassInfo) ? false : ((ClassInfo)other).name.equals(this.name);
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   static ClassInfo fromClassNode(ClassNode classNode) {
      ClassInfo info = (ClassInfo)cache.get(classNode.name);
      if (info == null) {
         info = new ClassInfo(classNode);
         cache.put(classNode.name, info);
      }

      return info;
   }

   public static ClassInfo forName(String className) {
      className = className.replace('.', '/');
      ClassInfo info = (ClassInfo)cache.get(className);
      if (info == null) {
         try {
            ClassNode classNode = MixinService.getService().getBytecodeProvider().getClassNode(className);
            info = new ClassInfo(classNode);
         } catch (Exception var3) {
            logger.catching(Level.TRACE, var3);
            logger.warn("Error loading class: {} ({}: {})", new Object[]{className, var3.getClass().getName(), var3.getMessage()});
         }

         cache.put(className, info);
         logger.trace("Added class metadata for {} to metadata cache", new Object[]{className});
      }

      return info;
   }

   public static ClassInfo forType(Type type) {
      if (type.getSort() == 9) {
         return forType(type.getElementType());
      } else {
         return type.getSort() < 9 ? null : forName(type.getClassName().replace('.', '/'));
      }
   }

   public static ClassInfo getCommonSuperClass(String type1, String type2) {
      return type1 != null && type2 != null ? getCommonSuperClass(forName(type1), forName(type2)) : OBJECT;
   }

   public static ClassInfo getCommonSuperClass(Type type1, Type type2) {
      return type1 != null && type2 != null && type1.getSort() == 10 && type2.getSort() == 10 ? getCommonSuperClass(forType(type1), forType(type2)) : OBJECT;
   }

   private static ClassInfo getCommonSuperClass(ClassInfo type1, ClassInfo type2) {
      return getCommonSuperClass(type1, type2, false);
   }

   public static ClassInfo getCommonSuperClassOrInterface(String type1, String type2) {
      return type1 != null && type2 != null ? getCommonSuperClassOrInterface(forName(type1), forName(type2)) : OBJECT;
   }

   public static ClassInfo getCommonSuperClassOrInterface(Type type1, Type type2) {
      return type1 != null && type2 != null && type1.getSort() == 10 && type2.getSort() == 10 ? getCommonSuperClassOrInterface(forType(type1), forType(type2)) : OBJECT;
   }

   public static ClassInfo getCommonSuperClassOrInterface(ClassInfo type1, ClassInfo type2) {
      return getCommonSuperClass(type1, type2, true);
   }

   private static ClassInfo getCommonSuperClass(ClassInfo type1, ClassInfo type2, boolean includeInterfaces) {
      if (type1.hasSuperClass(type2, ClassInfo$Traversal.NONE, includeInterfaces)) {
         return type2;
      } else if (type2.hasSuperClass(type1, ClassInfo$Traversal.NONE, includeInterfaces)) {
         return type1;
      } else if (!type1.isInterface() && !type2.isInterface()) {
         do {
            type1 = type1.getSuperClass();
            if (type1 == null) {
               return OBJECT;
            }
         } while(!type2.hasSuperClass(type1, ClassInfo$Traversal.NONE, includeInterfaces));

         return type1;
      } else {
         return OBJECT;
      }
   }

   static {
      cache.put("java/lang/Object", OBJECT);
   }
}
