package org.spongepowered.tools.agent;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.transformer.MixinTransformer;
import org.spongepowered.asm.mixin.transformer.ext.IHotSwap;

public class MixinAgent implements IHotSwap {
   public static final byte[] ERROR_BYTECODE = new byte[]{1};
   static final MixinAgentClassLoader classLoader = new MixinAgentClassLoader();
   static final Logger logger = LogManager.getLogger("mixin.agent");
   static Instrumentation instrumentation = null;
   private static List agents = new ArrayList();
   final MixinTransformer classTransformer;

   public MixinAgent(MixinTransformer classTransformer) {
      this.classTransformer = classTransformer;
      agents.add(this);
      if (instrumentation != null) {
         this.initTransformer();
      }

   }

   private void initTransformer() {
      instrumentation.addTransformer(new MixinAgent$Transformer(this), true);
   }

   public void registerMixinClass(String name) {
      classLoader.addMixinClass(name);
   }

   public void registerTargetClass(String name, byte[] bytecode) {
      classLoader.addTargetClass(name, bytecode);
   }

   public static void init(Instrumentation instrumentation) {
      MixinAgent.instrumentation = instrumentation;
      if (!MixinAgent.instrumentation.isRedefineClassesSupported()) {
         logger.error("The instrumentation doesn't support re-definition of classes");
      }

      Iterator var1 = agents.iterator();

      while(var1.hasNext()) {
         MixinAgent agent = (MixinAgent)var1.next();
         agent.initTransformer();
      }

   }

   public static void premain(String arg, Instrumentation instrumentation) {
      System.setProperty("mixin.hotSwap", "true");
      init(instrumentation);
   }

   public static void agentmain(String arg, Instrumentation instrumentation) {
      init(instrumentation);
   }
}
