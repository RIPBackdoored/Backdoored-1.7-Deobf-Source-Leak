package org.spongepowered.asm.mixin.transformer;

import com.google.common.base.Functions;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.MixinEnvironment$Option;
import org.spongepowered.asm.mixin.MixinEnvironment$Phase;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.extensibility.IMixinConfig;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;
import org.spongepowered.asm.mixin.transformer.throwables.MixinTargetAlreadyLoadedException;
import org.spongepowered.asm.service.IMixinService;
import org.spongepowered.asm.service.MixinService;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.perf.Profiler;
import org.spongepowered.asm.util.perf.Profiler$Section;

class MixinInfo implements Comparable, IMixinInfo {
   private static final IMixinService classLoaderUtil = MixinService.getService();
   static int mixinOrder = 0;
   private final transient Logger logger = LogManager.getLogger("mixin");
   private final transient Profiler profiler = MixinEnvironment.getProfiler();
   private final transient MixinConfig parent;
   private final String name;
   private final String className;
   private final int priority;
   private final boolean virtual;
   private final List targetClasses;
   private final List targetClassNames;
   private final transient int order;
   private final transient IMixinService service;
   private final transient IMixinConfigPlugin plugin;
   private final transient MixinEnvironment$Phase phase;
   private final transient ClassInfo info;
   private final transient MixinInfo$SubType type;
   private final transient boolean strict;
   private transient MixinInfo$State pendingState;
   private transient MixinInfo$State state;

   MixinInfo(IMixinService service, MixinConfig parent, String name, boolean runTransformers, IMixinConfigPlugin plugin, boolean suppressPlugin) {
      this.order = mixinOrder++;
      this.service = service;
      this.parent = parent;
      this.name = name;
      this.className = parent.getMixinPackage() + name;
      this.plugin = plugin;
      this.phase = parent.getEnvironment().getPhase();
      this.strict = parent.getEnvironment().getOption(MixinEnvironment$Option.DEBUG_TARGETS);

      try {
         byte[] mixinBytes = this.loadMixinClass(this.className, runTransformers);
         this.pendingState = new MixinInfo$State(this, mixinBytes);
         this.info = this.pendingState.getClassInfo();
         this.type = MixinInfo$SubType.getTypeFor(this);
      } catch (InvalidMixinException var10) {
         throw var10;
      } catch (Exception var11) {
         throw new InvalidMixinException(this, var11);
      }

      if (!this.type.isLoadable()) {
         classLoaderUtil.registerInvalidClass(this.className);
      }

      try {
         this.priority = this.readPriority(this.pendingState.getClassNode());
         this.virtual = this.readPseudo(this.pendingState.getClassNode());
         this.targetClasses = this.readTargetClasses(this.pendingState.getClassNode(), suppressPlugin);
         this.targetClassNames = Collections.unmodifiableList(Lists.transform(this.targetClasses, Functions.toStringFunction()));
      } catch (InvalidMixinException var8) {
         throw var8;
      } catch (Exception var9) {
         throw new InvalidMixinException(this, var9);
      }

   }

   void validate() {
      if (this.pendingState == null) {
         throw new IllegalStateException("No pending validation state for " + this);
      } else {
         try {
            this.pendingState.validate(this.type, this.targetClasses);
            this.state = this.pendingState;
         } finally {
            this.pendingState = null;
         }

      }
   }

   protected List readTargetClasses(MixinInfo$MixinClassNode classNode, boolean suppressPlugin) {
      if (classNode == null) {
         return Collections.emptyList();
      } else {
         AnnotationNode mixin = Annotations.getInvisible((ClassNode)classNode, Mixin.class);
         if (mixin == null) {
            throw new InvalidMixinException(this, String.format("The mixin '%s' is missing an @Mixin annotation", this.className));
         } else {
            List targets = new ArrayList();
            List publicTargets = (List)Annotations.getValue(mixin, "value");
            List privateTargets = (List)Annotations.getValue(mixin, "targets");
            if (publicTargets != null) {
               this.readTargets(targets, Lists.transform(publicTargets, new MixinInfo$1(this)), suppressPlugin, false);
            }

            if (privateTargets != null) {
               this.readTargets(targets, Lists.transform(privateTargets, new MixinInfo$2(this)), suppressPlugin, true);
            }

            return targets;
         }
      }
   }

   private void readTargets(Collection outTargets, Collection inTargets, boolean suppressPlugin, boolean checkPublic) {
      Iterator var5 = inTargets.iterator();

      while(var5.hasNext()) {
         String targetRef = (String)var5.next();
         String targetName = targetRef.replace('/', '.');
         if (classLoaderUtil.isClassLoaded(targetName) && !this.isReloading()) {
            String message = String.format("Critical problem: %s target %s was already transformed.", this, targetName);
            if (this.parent.isRequired()) {
               throw new MixinTargetAlreadyLoadedException(this, message, targetName);
            }

            this.logger.error(message);
         }

         if (this.shouldApplyMixin(suppressPlugin, targetName)) {
            ClassInfo targetInfo = this.getTarget(targetName, checkPublic);
            if (targetInfo != null && !outTargets.contains(targetInfo)) {
               outTargets.add(targetInfo);
               targetInfo.addMixin(this);
            }
         }
      }

   }

   private boolean shouldApplyMixin(boolean suppressPlugin, String targetName) {
      Profiler$Section pluginTimer = this.profiler.begin("plugin");
      boolean result = this.plugin == null || suppressPlugin || this.plugin.shouldApplyMixin(targetName, this.className);
      pluginTimer.end();
      return result;
   }

   private ClassInfo getTarget(String targetName, boolean checkPublic) throws InvalidMixinException {
      ClassInfo targetInfo = ClassInfo.forName(targetName);
      if (targetInfo == null) {
         if (this.isVirtual()) {
            this.logger.debug("Skipping virtual target {} for {}", new Object[]{targetName, this});
         } else {
            this.handleTargetError(String.format("@Mixin target %s was not found %s", targetName, this));
         }

         return null;
      } else {
         this.type.validateTarget(targetName, targetInfo);
         if (checkPublic && targetInfo.isPublic() && !this.isVirtual()) {
            this.handleTargetError(String.format("@Mixin target %s is public in %s and should be specified in value", targetName, this));
         }

         return targetInfo;
      }
   }

   private void handleTargetError(String message) {
      if (this.strict) {
         this.logger.error(message);
         throw new InvalidMixinException(this, message);
      } else {
         this.logger.warn(message);
      }
   }

   protected int readPriority(ClassNode classNode) {
      if (classNode == null) {
         return this.parent.getDefaultMixinPriority();
      } else {
         AnnotationNode mixin = Annotations.getInvisible(classNode, Mixin.class);
         if (mixin == null) {
            throw new InvalidMixinException(this, String.format("The mixin '%s' is missing an @Mixin annotation", this.className));
         } else {
            Integer priority = (Integer)Annotations.getValue(mixin, "priority");
            return priority == null ? this.parent.getDefaultMixinPriority() : priority;
         }
      }
   }

   protected boolean readPseudo(ClassNode classNode) {
      return Annotations.getInvisible(classNode, Pseudo.class) != null;
   }

   private boolean isReloading() {
      return this.pendingState instanceof MixinInfo$Reloaded;
   }

   private MixinInfo$State getState() {
      return this.state != null ? this.state : this.pendingState;
   }

   ClassInfo getClassInfo() {
      return this.info;
   }

   public IMixinConfig getConfig() {
      return this.parent;
   }

   MixinConfig getParent() {
      return this.parent;
   }

   public int getPriority() {
      return this.priority;
   }

   public String getName() {
      return this.name;
   }

   public String getClassName() {
      return this.className;
   }

   public String getClassRef() {
      return this.getClassInfo().getName();
   }

   public byte[] getClassBytes() {
      return this.getState().getClassBytes();
   }

   public boolean isDetachedSuper() {
      return this.getState().isDetachedSuper();
   }

   public boolean isUnique() {
      return this.getState().isUnique();
   }

   public boolean isVirtual() {
      return this.virtual;
   }

   public boolean isAccessor() {
      return this.type instanceof MixinInfo$SubType$Accessor;
   }

   public boolean isLoadable() {
      return this.type.isLoadable();
   }

   public Level getLoggingLevel() {
      return this.parent.getLoggingLevel();
   }

   public MixinEnvironment$Phase getPhase() {
      return this.phase;
   }

   public MixinInfo$MixinClassNode getClassNode(int flags) {
      return this.getState().createClassNode(flags);
   }

   public List getTargetClasses() {
      return this.targetClassNames;
   }

   List getSoftImplements() {
      return Collections.unmodifiableList(this.getState().getSoftImplements());
   }

   Set getSyntheticInnerClasses() {
      return Collections.unmodifiableSet(this.getState().getSyntheticInnerClasses());
   }

   Set getInnerClasses() {
      return Collections.unmodifiableSet(this.getState().getInnerClasses());
   }

   List getTargets() {
      return Collections.unmodifiableList(this.targetClasses);
   }

   Set getInterfaces() {
      return this.getState().getInterfaces();
   }

   MixinTargetContext createContextFor(TargetClassContext target) {
      MixinInfo$MixinClassNode classNode = this.getClassNode(8);
      Profiler$Section preTimer = this.profiler.begin("pre");
      MixinTargetContext preProcessor = this.type.createPreProcessor(classNode).prepare().createContextFor(target);
      preTimer.end();
      return preProcessor;
   }

   private byte[] loadMixinClass(String mixinClassName, boolean runTransformers) throws ClassNotFoundException {
      Object var3 = null;

      byte[] mixinBytes;
      try {
         if (runTransformers) {
            String restrictions = this.service.getClassRestrictions(mixinClassName);
            if (restrictions.length() > 0) {
               this.logger.error("Classloader restrictions [{}] encountered loading {}, name: {}", new Object[]{restrictions, this, mixinClassName});
            }
         }

         mixinBytes = this.service.getBytecodeProvider().getClassBytes(mixinClassName, runTransformers);
      } catch (ClassNotFoundException var5) {
         throw new ClassNotFoundException(String.format("The specified mixin '%s' was not found", mixinClassName));
      } catch (IOException var6) {
         this.logger.warn("Failed to load mixin {}, the specified mixin will not be applied", new Object[]{mixinClassName});
         throw new InvalidMixinException(this, "An error was encountered whilst loading the mixin class", var6);
      }

      return mixinBytes;
   }

   void reloadMixin(byte[] mixinBytes) {
      if (this.pendingState != null) {
         throw new IllegalStateException("Cannot reload mixin while it is initialising");
      } else {
         this.pendingState = new MixinInfo$Reloaded(this, this.state, mixinBytes);
         this.validate();
      }
   }

   public int compareTo(MixinInfo other) {
      if (other == null) {
         return 0;
      } else {
         return other.priority == this.priority ? this.order - other.order : this.priority - other.priority;
      }
   }

   public void preApply(String transformedName, ClassNode targetClass) {
      if (this.plugin != null) {
         Profiler$Section pluginTimer = this.profiler.begin("plugin");
         this.plugin.preApply(transformedName, targetClass, this.className, this);
         pluginTimer.end();
      }

   }

   public void postApply(String transformedName, ClassNode targetClass) {
      if (this.plugin != null) {
         Profiler$Section pluginTimer = this.profiler.begin("plugin");
         this.plugin.postApply(transformedName, targetClass, this.className, this);
         pluginTimer.end();
      }

      this.parent.postApply(transformedName, targetClass);
   }

   public String toString() {
      return String.format("%s:%s", this.parent.getName(), this.name);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compareTo(Object var1) {
      return this.compareTo((MixinInfo)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public ClassNode getClassNode(int var1) {
      return this.getClassNode(var1);
   }
}
