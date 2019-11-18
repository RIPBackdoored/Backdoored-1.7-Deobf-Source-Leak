package org.spongepowered.asm.mixin;

import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.GlobalProperties;
import org.spongepowered.asm.mixin.extensibility.IEnvironmentTokenProvider;
import org.spongepowered.asm.mixin.throwables.MixinException;
import org.spongepowered.asm.mixin.transformer.MixinTransformer;
import org.spongepowered.asm.obfuscation.RemapperChain;
import org.spongepowered.asm.service.ILegacyClassTransformer;
import org.spongepowered.asm.service.IMixinService;
import org.spongepowered.asm.service.ITransformer;
import org.spongepowered.asm.service.MixinService;
import org.spongepowered.asm.util.ITokenProvider;
import org.spongepowered.asm.util.PrettyPrinter;
import org.spongepowered.asm.util.perf.Profiler;

public final class MixinEnvironment implements ITokenProvider {
   private static final Set excludeTransformers = Sets.newHashSet(new String[]{"net.minecraftforge.fml.common.asm.transformers.EventSubscriptionTransformer", "cpw.mods.fml.common.asm.transformers.EventSubscriptionTransformer", "net.minecraftforge.fml.common.asm.transformers.TerminalTransformer", "cpw.mods.fml.common.asm.transformers.TerminalTransformer"});
   private static MixinEnvironment currentEnvironment;
   private static MixinEnvironment$Phase currentPhase;
   private static MixinEnvironment$CompatibilityLevel compatibility;
   private static boolean showHeader;
   private static final Logger logger;
   private static final Profiler profiler;
   private final IMixinService service = MixinService.getService();
   private final MixinEnvironment$Phase phase;
   private final String configsKey;
   private final boolean[] options;
   private final Set tokenProviderClasses = new HashSet();
   private final List tokenProviders = new ArrayList();
   private final Map internalTokens = new HashMap();
   private final RemapperChain remappers = new RemapperChain();
   private MixinEnvironment$Side side;
   private List transformers;
   private String obfuscationContext = null;

   MixinEnvironment(MixinEnvironment$Phase phase) {
      this.phase = phase;
      this.configsKey = "mixin.configs." + this.phase.name.toLowerCase();
      Object version = this.getVersion();
      if (version != null && "0.7.11".equals(version)) {
         this.service.checkEnv(this);
         this.options = new boolean[MixinEnvironment$Option.values().length];
         MixinEnvironment$Option[] var3 = MixinEnvironment$Option.values();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            MixinEnvironment$Option option = var3[var5];
            this.options[option.ordinal()] = option.getBooleanValue();
         }

         if (showHeader) {
            showHeader = false;
            this.printHeader(version);
         }

      } else {
         throw new MixinException("Environment conflict, mismatched versions or you didn't call MixinBootstrap.init()");
      }
   }

   private void printHeader(Object version) {
      String codeSource = this.getCodeSource();
      String serviceName = this.service.getName();
      MixinEnvironment$Side side = this.getSide();
      logger.info("SpongePowered MIXIN Subsystem Version={} Source={} Service={} Env={}", new Object[]{version, codeSource, serviceName, side});
      boolean verbose = this.getOption(MixinEnvironment$Option.DEBUG_VERBOSE);
      if (verbose || this.getOption(MixinEnvironment$Option.DEBUG_EXPORT) || this.getOption(MixinEnvironment$Option.DEBUG_PROFILER)) {
         PrettyPrinter printer = new PrettyPrinter(32);
         printer.add("SpongePowered MIXIN%s", verbose ? " (Verbose debugging enabled)" : "").centre().hr();
         printer.kv("Code source", codeSource);
         printer.kv("Internal Version", version);
         printer.kv("Java 8 Supported", MixinEnvironment$CompatibilityLevel.JAVA_8.isSupported()).hr();
         printer.kv("Service Name", serviceName);
         printer.kv("Service Class", this.service.getClass().getName()).hr();
         MixinEnvironment$Option[] var7 = MixinEnvironment$Option.values();
         int var8 = var7.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            MixinEnvironment$Option option = var7[var9];
            StringBuilder indent = new StringBuilder();

            for(int i = 0; i < option.depth; ++i) {
               indent.append("- ");
            }

            printer.kv(option.property, "%s<%s>", indent, option);
         }

         printer.hr().kv("Detected Side", side);
         printer.print(System.err);
      }

   }

   private String getCodeSource() {
      String var10000;
      try {
         var10000 = this.getClass().getProtectionDomain().getCodeSource().getLocation().toString();
      } catch (Throwable var2) {
         return "Unknown";
      }

      return var10000;
   }

   public MixinEnvironment$Phase getPhase() {
      return this.phase;
   }

   /** @deprecated */
   @Deprecated
   public List getMixinConfigs() {
      List mixinConfigs = (List)GlobalProperties.get(this.configsKey);
      if (mixinConfigs == null) {
         mixinConfigs = new ArrayList();
         GlobalProperties.put(this.configsKey, mixinConfigs);
      }

      return (List)mixinConfigs;
   }

   /** @deprecated */
   @Deprecated
   public MixinEnvironment addConfiguration(String config) {
      logger.warn("MixinEnvironment::addConfiguration is deprecated and will be removed. Use Mixins::addConfiguration instead!");
      Mixins.addConfiguration(config, this);
      return this;
   }

   void registerConfig(String config) {
      List configs = this.getMixinConfigs();
      if (!configs.contains(config)) {
         configs.add(config);
      }

   }

   /** @deprecated */
   @Deprecated
   public MixinEnvironment registerErrorHandlerClass(String handlerName) {
      Mixins.registerErrorHandlerClass(handlerName);
      return this;
   }

   public MixinEnvironment registerTokenProviderClass(String providerName) {
      if (!this.tokenProviderClasses.contains(providerName)) {
         try {
            Class providerClass = this.service.getClassProvider().findClass(providerName, true);
            IEnvironmentTokenProvider provider = (IEnvironmentTokenProvider)providerClass.newInstance();
            this.registerTokenProvider(provider);
         } catch (Throwable var4) {
            logger.error("Error instantiating " + providerName, var4);
         }
      }

      return this;
   }

   public MixinEnvironment registerTokenProvider(IEnvironmentTokenProvider provider) {
      if (provider != null && !this.tokenProviderClasses.contains(provider.getClass().getName())) {
         String providerName = provider.getClass().getName();
         MixinEnvironment$TokenProviderWrapper wrapper = new MixinEnvironment$TokenProviderWrapper(provider, this);
         logger.info("Adding new token provider {} to {}", new Object[]{providerName, this});
         this.tokenProviders.add(wrapper);
         this.tokenProviderClasses.add(providerName);
         Collections.sort(this.tokenProviders);
      }

      return this;
   }

   public Integer getToken(String token) {
      token = token.toUpperCase();
      Iterator var2 = this.tokenProviders.iterator();

      Integer value;
      do {
         if (!var2.hasNext()) {
            return (Integer)this.internalTokens.get(token);
         }

         MixinEnvironment$TokenProviderWrapper provider = (MixinEnvironment$TokenProviderWrapper)var2.next();
         value = provider.getToken(token);
      } while(value == null);

      return value;
   }

   /** @deprecated */
   @Deprecated
   public Set getErrorHandlerClasses() {
      return Mixins.getErrorHandlerClasses();
   }

   public Object getActiveTransformer() {
      return GlobalProperties.get("mixin.transformer");
   }

   public void setActiveTransformer(ITransformer transformer) {
      if (transformer != null) {
         GlobalProperties.put("mixin.transformer", transformer);
      }

   }

   public MixinEnvironment setSide(MixinEnvironment$Side side) {
      if (side != null && this.getSide() == MixinEnvironment$Side.UNKNOWN && side != MixinEnvironment$Side.UNKNOWN) {
         this.side = side;
      }

      return this;
   }

   public MixinEnvironment$Side getSide() {
      if (this.side == null) {
         MixinEnvironment$Side[] var1 = MixinEnvironment$Side.values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            MixinEnvironment$Side side = var1[var3];
            if (side.detect()) {
               this.side = side;
               break;
            }
         }
      }

      return this.side != null ? this.side : MixinEnvironment$Side.UNKNOWN;
   }

   public String getVersion() {
      return (String)GlobalProperties.get("mixin.initialised");
   }

   public boolean getOption(MixinEnvironment$Option option) {
      return this.options[option.ordinal()];
   }

   public void setOption(MixinEnvironment$Option option, boolean value) {
      this.options[option.ordinal()] = value;
   }

   public String getOptionValue(MixinEnvironment$Option option) {
      return option.getStringValue();
   }

   public Enum getOption(MixinEnvironment$Option option, Enum defaultValue) {
      return option.getEnumValue(defaultValue);
   }

   public void setObfuscationContext(String context) {
      this.obfuscationContext = context;
   }

   public String getObfuscationContext() {
      return this.obfuscationContext;
   }

   public String getRefmapObfuscationContext() {
      String overrideObfuscationType = MixinEnvironment$Option.OBFUSCATION_TYPE.getStringValue();
      return overrideObfuscationType != null ? overrideObfuscationType : this.obfuscationContext;
   }

   public RemapperChain getRemappers() {
      return this.remappers;
   }

   public void audit() {
      Object activeTransformer = this.getActiveTransformer();
      if (activeTransformer instanceof MixinTransformer) {
         MixinTransformer transformer = (MixinTransformer)activeTransformer;
         transformer.audit(this);
      }

   }

   public List getTransformers() {
      if (this.transformers == null) {
         this.buildTransformerDelegationList();
      }

      return Collections.unmodifiableList(this.transformers);
   }

   public void addTransformerExclusion(String name) {
      excludeTransformers.add(name);
      this.transformers = null;
   }

   private void buildTransformerDelegationList() {
      logger.debug("Rebuilding transformer delegation list:");
      this.transformers = new ArrayList();
      Iterator var1 = this.service.getTransformers().iterator();

      while(true) {
         while(true) {
            ITransformer transformer;
            do {
               if (!var1.hasNext()) {
                  logger.debug("Transformer delegation list created with {} entries", new Object[]{this.transformers.size()});
                  return;
               }

               transformer = (ITransformer)var1.next();
            } while(!(transformer instanceof ILegacyClassTransformer));

            ILegacyClassTransformer legacyTransformer = (ILegacyClassTransformer)transformer;
            String transformerName = legacyTransformer.getName();
            boolean include = true;
            Iterator var6 = excludeTransformers.iterator();

            while(var6.hasNext()) {
               String excludeClass = (String)var6.next();
               if (transformerName.contains(excludeClass)) {
                  include = false;
                  break;
               }
            }

            if (include && !legacyTransformer.isDelegationExcluded()) {
               logger.debug("  Adding:    {}", new Object[]{transformerName});
               this.transformers.add(legacyTransformer);
            } else {
               logger.debug("  Excluding: {}", new Object[]{transformerName});
            }
         }
      }
   }

   public String toString() {
      return String.format("%s[%s]", this.getClass().getSimpleName(), this.phase);
   }

   private static MixinEnvironment$Phase getCurrentPhase() {
      if (currentPhase == MixinEnvironment$Phase.NOT_INITIALISED) {
         init(MixinEnvironment$Phase.PREINIT);
      }

      return currentPhase;
   }

   public static void init(MixinEnvironment$Phase phase) {
      if (currentPhase == MixinEnvironment$Phase.NOT_INITIALISED) {
         currentPhase = phase;
         MixinEnvironment env = getEnvironment(phase);
         getProfiler().setActive(env.getOption(MixinEnvironment$Option.DEBUG_PROFILER));
         MixinEnvironment$MixinLogWatcher.begin();
      }

   }

   public static MixinEnvironment getEnvironment(MixinEnvironment$Phase phase) {
      return phase == null ? MixinEnvironment$Phase.DEFAULT.getEnvironment() : phase.getEnvironment();
   }

   public static MixinEnvironment getDefaultEnvironment() {
      return getEnvironment(MixinEnvironment$Phase.DEFAULT);
   }

   public static MixinEnvironment getCurrentEnvironment() {
      if (currentEnvironment == null) {
         currentEnvironment = getEnvironment(getCurrentPhase());
      }

      return currentEnvironment;
   }

   public static MixinEnvironment$CompatibilityLevel getCompatibilityLevel() {
      return compatibility;
   }

   /** @deprecated */
   @Deprecated
   public static void setCompatibilityLevel(MixinEnvironment$CompatibilityLevel level) throws IllegalArgumentException {
      StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
      if (!"org.spongepowered.asm.mixin.transformer.MixinConfig".equals(stackTrace[2].getClassName())) {
         logger.warn("MixinEnvironment::setCompatibilityLevel is deprecated and will be removed. Set level via config instead!");
      }

      if (level != compatibility && level.isAtLeast(compatibility)) {
         if (!level.isSupported()) {
            throw new IllegalArgumentException("The requested compatibility level " + level + " could not be set. Level is not supported");
         }

         compatibility = level;
         logger.info("Compatibility level set to {}", new Object[]{level});
      }

   }

   public static Profiler getProfiler() {
      return profiler;
   }

   static void gotoPhase(MixinEnvironment$Phase phase) {
      if (phase != null && phase.ordinal >= 0) {
         if (phase.ordinal > getCurrentPhase().ordinal) {
            MixinService.getService().beginPhase();
         }

         if (phase == MixinEnvironment$Phase.DEFAULT) {
            MixinEnvironment$MixinLogWatcher.end();
         }

         currentPhase = phase;
         currentEnvironment = getEnvironment(getCurrentPhase());
      } else {
         throw new IllegalArgumentException("Cannot go to the specified phase, phase is null or invalid");
      }
   }

   static {
      currentPhase = MixinEnvironment$Phase.NOT_INITIALISED;
      compatibility = (MixinEnvironment$CompatibilityLevel)MixinEnvironment$Option.DEFAULT_COMPATIBILITY_LEVEL.getEnumValue(MixinEnvironment$CompatibilityLevel.JAVA_6);
      showHeader = true;
      logger = LogManager.getLogger("mixin");
      profiler = new Profiler();
   }
}
