package org.spongepowered.asm.mixin.injection.callback;

import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.InsnNode;
import org.spongepowered.asm.lib.tree.JumpInsnNode;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.lib.tree.LdcInsnNode;
import org.spongepowered.asm.lib.tree.LocalVariableNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.TypeInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.Surrogate;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.points.BeforeReturn;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes$InjectionNode;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;
import org.spongepowered.asm.util.Locals;
import org.spongepowered.asm.util.PrettyPrinter;
import org.spongepowered.asm.util.SignaturePrinter;

public class CallbackInjector extends Injector {
   private final boolean cancellable;
   private final LocalCapture localCapture;
   private final String identifier;
   private final Map ids = new HashMap();
   private int totalInjections = 0;
   private int callbackInfoVar = -1;
   private String lastId;
   private String lastDesc;
   private Target lastTarget;
   private String callbackInfoClass;

   public CallbackInjector(InjectionInfo info, boolean cancellable, LocalCapture localCapture, String identifier) {
      super(info);
      this.cancellable = cancellable;
      this.localCapture = localCapture;
      this.identifier = identifier;
   }

   protected void sanityCheck(Target target, List injectionPoints) {
      super.sanityCheck(target, injectionPoints);
      if (target.isStatic != this.isStatic) {
         throw new InvalidInjectionException(this.info, "'static' modifier of callback method does not match target in " + this);
      } else {
         if ("<init>".equals(target.method.name)) {
            Iterator var3 = injectionPoints.iterator();

            while(var3.hasNext()) {
               InjectionPoint injectionPoint = (InjectionPoint)var3.next();
               if (!injectionPoint.getClass().equals(BeforeReturn.class)) {
                  throw new InvalidInjectionException(this.info, "Found injection point type " + injectionPoint.getClass().getSimpleName() + " targetting a ctor in " + this + ". Only RETURN allowed for a ctor target");
               }
            }
         }

      }
   }

   protected void addTargetNode(Target target, List myNodes, AbstractInsnNode node, Set nominators) {
      InjectionNodes$InjectionNode injectionNode = target.addInjectionNode(node);
      Iterator var6 = nominators.iterator();

      while(var6.hasNext()) {
         InjectionPoint ip = (InjectionPoint)var6.next();
         String id = ip.getId();
         if (!Strings.isNullOrEmpty(id)) {
            String existingId = (String)this.ids.get(injectionNode.getId());
            if (existingId != null && !existingId.equals(id)) {
               Injector.logger.warn("Conflicting id for {} insn in {}, found id {} on {}, previously defined as {}", new Object[]{Bytecode.getOpcodeName(node), target.toString(), id, this.info, existingId});
               break;
            }

            this.ids.put(injectionNode.getId(), id);
         }
      }

      myNodes.add(injectionNode);
      ++this.totalInjections;
   }

   protected void inject(Target target, InjectionNodes$InjectionNode node) {
      LocalVariableNode[] locals = null;
      if (this.localCapture.isCaptureLocals() || this.localCapture.isPrintLocals()) {
         locals = Locals.getLocalsAt(this.classNode, target.method, node.getCurrentTarget());
      }

      this.inject(new CallbackInjector$Callback(this, this.methodNode, target, node, locals, this.localCapture.isCaptureLocals()));
   }

   private void inject(CallbackInjector$Callback callback) {
      // $FF: Couldn't be decompiled
   }

   private String generateBadLVTMessage(CallbackInjector$Callback callback) {
      int position = callback.target.indexOf(callback.node);
      List expected = summariseLocals(this.methodNode.desc, callback.target.arguments.length + 1);
      List found = summariseLocals(callback.getDescriptorWithAllLocals(), callback.frameSize);
      return String.format("LVT in %s has incompatible changes at opcode %d in callback %s.\nExpected: %s\n   Found: %s", callback.target, position, this, expected, found);
   }

   private MethodNode generateErrorMethod(CallbackInjector$Callback callback, String errorClass, String message) {
      MethodNode method = this.info.addMethod(this.methodNode.access, this.methodNode.name + "$missing", callback.getDescriptor());
      method.maxLocals = Bytecode.getFirstNonArgLocalIndex(Type.getArgumentTypes(callback.getDescriptor()), !this.isStatic);
      method.maxStack = 3;
      InsnList insns = method.instructions;
      insns.add((AbstractInsnNode)(new TypeInsnNode(187, errorClass)));
      insns.add((AbstractInsnNode)(new InsnNode(89)));
      insns.add((AbstractInsnNode)(new LdcInsnNode(message)));
      insns.add((AbstractInsnNode)(new MethodInsnNode(183, errorClass, "<init>", "(Ljava/lang/String;)V", false)));
      insns.add((AbstractInsnNode)(new InsnNode(191)));
      return method;
   }

   private void printLocals(CallbackInjector$Callback callback) {
      Type[] args = Type.getArgumentTypes(callback.getDescriptorWithAllLocals());
      SignaturePrinter methodSig = new SignaturePrinter(callback.target.method, callback.argNames);
      SignaturePrinter handlerSig = new SignaturePrinter(this.methodNode.name, callback.target.returnType, args, callback.argNames);
      handlerSig.setModifiers(this.methodNode);
      PrettyPrinter printer = new PrettyPrinter();
      printer.kv("Target Class", this.classNode.name.replace('/', '.'));
      printer.kv("Target Method", methodSig);
      printer.kv("Target Max LOCALS", callback.target.getMaxLocals());
      printer.kv("Initial Frame Size", callback.frameSize);
      printer.kv("Callback Name", this.methodNode.name);
      printer.kv("Instruction", "%s %s", callback.node.getClass().getSimpleName(), Bytecode.getOpcodeName(callback.node.getCurrentTarget().getOpcode()));
      printer.hr();
      if (callback.locals.length > callback.frameSize) {
         printer.add("  %s  %20s  %s", "LOCAL", "TYPE", "NAME");

         for(int l = 0; l < callback.locals.length; ++l) {
            String marker = l == callback.frameSize ? ">" : " ";
            if (callback.locals[l] != null) {
               printer.add("%s [%3d]  %20s  %-50s %s", marker, l, SignaturePrinter.getTypeName(callback.localTypes[l], false), meltSnowman(l, callback.locals[l].name), l >= callback.frameSize ? "<capture>" : "");
            } else {
               boolean isTop = l > 0 && callback.localTypes[l - 1] != null && callback.localTypes[l - 1].getSize() > 1;
               printer.add("%s [%3d]  %20s", marker, l, isTop ? "<top>" : "-");
            }
         }

         printer.hr();
      }

      printer.add().add("/**").add(" * Expected callback signature").add(" * /");
      printer.add("%s {", handlerSig);
      printer.add("    // Method body").add("}").add().print(System.err);
   }

   private void createCallbackInfo(CallbackInjector$Callback callback, boolean store) {
      if (callback.target != this.lastTarget) {
         this.lastId = null;
         this.lastDesc = null;
      }

      this.lastTarget = callback.target;
      String id = this.getIdentifier(callback);
      String desc = callback.getCallbackInfoConstructorDescriptor();
      if (!id.equals(this.lastId) || !desc.equals(this.lastDesc) || callback.isAtReturn || this.cancellable) {
         this.instanceCallbackInfo(callback, id, desc, store);
      }
   }

   private void loadOrCreateCallbackInfo(CallbackInjector$Callback callback) {
      if (!this.cancellable && this.totalInjections <= 1) {
         this.createCallbackInfo(callback, false);
      } else {
         callback.add(new VarInsnNode(25, this.callbackInfoVar), false, true);
      }

   }

   private void dupReturnValue(CallbackInjector$Callback callback) {
      if (callback.isAtReturn) {
         callback.add(new InsnNode(89));
         callback.add(new VarInsnNode(callback.target.returnType.getOpcode(54), callback.marshalVar()));
      }
   }

   protected void instanceCallbackInfo(CallbackInjector$Callback callback, String id, String desc, boolean store) {
      this.lastId = id;
      this.lastDesc = desc;
      this.callbackInfoVar = callback.marshalVar();
      this.callbackInfoClass = callback.target.getCallbackInfoClass();
      boolean head = store && this.totalInjections > 1 && !callback.isAtReturn && !this.cancellable;
      callback.add(new TypeInsnNode(187, this.callbackInfoClass), true, !store, head);
      callback.add(new InsnNode(89), true, true, head);
      callback.add(new LdcInsnNode(id), true, !store, head);
      callback.add(new InsnNode(this.cancellable ? 4 : 3), true, !store, head);
      if (callback.isAtReturn) {
         callback.add(new VarInsnNode(callback.target.returnType.getOpcode(21), callback.marshalVar()), true, !store);
         callback.add(new MethodInsnNode(183, this.callbackInfoClass, "<init>", desc, false));
      } else {
         callback.add(new MethodInsnNode(183, this.callbackInfoClass, "<init>", desc, false), false, false, head);
      }

      if (store) {
         callback.target.addLocalVariable(this.callbackInfoVar, "callbackInfo" + this.callbackInfoVar, "L" + this.callbackInfoClass + ";");
         callback.add(new VarInsnNode(58, this.callbackInfoVar), false, false, head);
      }

   }

   private void invokeCallback(CallbackInjector$Callback callback, MethodNode callbackMethod) {
      if (!this.isStatic) {
         callback.add(new VarInsnNode(25, 0), false, true);
      }

      if (callback.captureArgs()) {
         Bytecode.loadArgs(callback.target.arguments, callback, this.isStatic ? 0 : 1, -1);
      }

      this.loadOrCreateCallbackInfo(callback);
      if (callback.canCaptureLocals) {
         Locals.loadLocals(callback.localTypes, callback, callback.frameSize, callback.extraArgs);
      }

      this.invokeHandler(callback, callbackMethod);
   }

   private String getIdentifier(CallbackInjector$Callback callback) {
      String baseId = Strings.isNullOrEmpty(this.identifier) ? callback.target.method.name : this.identifier;
      String locationId = (String)this.ids.get(callback.node.getId());
      return baseId + (Strings.isNullOrEmpty(locationId) ? "" : ":" + locationId);
   }

   protected void injectCancellationCode(CallbackInjector$Callback callback) {
      if (this.cancellable) {
         callback.add(new VarInsnNode(25, this.callbackInfoVar));
         callback.add(new MethodInsnNode(182, this.callbackInfoClass, CallbackInfo.getIsCancelledMethodName(), CallbackInfo.getIsCancelledMethodSig(), false));
         LabelNode notCancelled = new LabelNode();
         callback.add(new JumpInsnNode(153, notCancelled));
         this.injectReturnCode(callback);
         callback.add(notCancelled);
      }
   }

   protected void injectReturnCode(CallbackInjector$Callback callback) {
      if (callback.target.returnType.equals(Type.VOID_TYPE)) {
         callback.add(new InsnNode(177));
      } else {
         callback.add(new VarInsnNode(25, callback.marshalVar()));
         String accessor = CallbackInfoReturnable.getReturnAccessor(callback.target.returnType);
         String descriptor = CallbackInfoReturnable.getReturnDescriptor(callback.target.returnType);
         callback.add(new MethodInsnNode(182, this.callbackInfoClass, accessor, descriptor, false));
         if (callback.target.returnType.getSort() == 10) {
            callback.add(new TypeInsnNode(192, callback.target.returnType.getInternalName()));
         }

         callback.add(new InsnNode(callback.target.returnType.getOpcode(172)));
      }

   }

   protected boolean isStatic() {
      return this.isStatic;
   }

   private static List summariseLocals(String desc, int pos) {
      return summariseLocals(Type.getArgumentTypes(desc), pos);
   }

   private static List summariseLocals(Type[] locals, int pos) {
      List list = new ArrayList();
      if (locals != null) {
         for(; pos < locals.length; ++pos) {
            if (locals[pos] != null) {
               list.add(locals[pos].toString());
            }
         }
      }

      return list;
   }

   static String meltSnowman(int index, String varName) {
      return varName != null && 9731 == varName.charAt(0) ? "var" + index : varName;
   }
}
