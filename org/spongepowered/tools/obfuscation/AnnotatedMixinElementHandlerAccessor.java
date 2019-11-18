package org.spongepowered.tools.obfuscation;

import com.google.common.base.Strings;
import java.util.Iterator;
import javax.tools.Diagnostic.Kind;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.MixinEnvironment$Option;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.gen.AccessorInfo;
import org.spongepowered.asm.mixin.gen.AccessorInfo$AccessorType;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.refmap.IReferenceMapper;
import org.spongepowered.asm.mixin.refmap.ReferenceMapper;
import org.spongepowered.asm.mixin.transformer.ext.Extensions;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.mirror.FieldHandle;
import org.spongepowered.tools.obfuscation.mirror.MethodHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;

public class AnnotatedMixinElementHandlerAccessor extends AnnotatedMixinElementHandler implements IMixinContext {
   public AnnotatedMixinElementHandlerAccessor(IMixinAnnotationProcessor ap, AnnotatedMixin mixin) {
      super(ap, mixin);
   }

   public ReferenceMapper getReferenceMapper() {
      return null;
   }

   public String getClassName() {
      return this.mixin.getClassRef().replace('/', '.');
   }

   public String getClassRef() {
      return this.mixin.getClassRef();
   }

   public String getTargetClassRef() {
      throw new UnsupportedOperationException("Target class not available at compile time");
   }

   public IMixinInfo getMixin() {
      throw new UnsupportedOperationException("MixinInfo not available at compile time");
   }

   public Extensions getExtensions() {
      throw new UnsupportedOperationException("Mixin Extensions not available at compile time");
   }

   public boolean getOption(MixinEnvironment$Option option) {
      throw new UnsupportedOperationException("Options not available at compile time");
   }

   public int getPriority() {
      throw new UnsupportedOperationException("Priority not available at compile time");
   }

   public Target getTargetMethod(MethodNode into) {
      throw new UnsupportedOperationException("Target not available at compile time");
   }

   public void registerAccessor(AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor elem) {
      if (elem.getAccessorType() == null) {
         elem.printMessage(this.ap, Kind.WARNING, "Unsupported accessor type");
      } else {
         String targetName = this.getAccessorTargetName(elem);
         if (targetName == null) {
            elem.printMessage(this.ap, Kind.WARNING, "Cannot inflect accessor target name");
         } else {
            elem.setTargetName(targetName);
            Iterator var3 = this.mixin.getTargets().iterator();

            while(var3.hasNext()) {
               TypeHandle target = (TypeHandle)var3.next();
               if (elem.getAccessorType() == AccessorInfo$AccessorType.METHOD_PROXY) {
                  this.registerInvokerForTarget((AnnotatedMixinElementHandlerAccessor$AnnotatedElementInvoker)elem, target);
               } else {
                  this.registerAccessorForTarget(elem, target);
               }
            }

         }
      }
   }

   private void registerAccessorForTarget(AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor elem, TypeHandle target) {
      FieldHandle targetField = target.findField(elem.getTargetName(), elem.getTargetTypeName(), false);
      if (targetField == null) {
         if (!target.isImaginary()) {
            elem.printMessage(this.ap, Kind.ERROR, "Could not locate @Accessor target " + elem + " in target " + target);
            return;
         }

         targetField = new FieldHandle(target.getName(), elem.getTargetName(), elem.getDesc());
      }

      if (elem.shouldRemap()) {
         ObfuscationData obfData = this.obf.getDataProvider().getObfField(targetField.asMapping(false).move(target.getName()));
         if (obfData.isEmpty()) {
            String info = this.mixin.isMultiTarget() ? " in target " + target : "";
            elem.printMessage(this.ap, Kind.WARNING, "Unable to locate obfuscation mapping" + info + " for @Accessor target " + elem);
         } else {
            obfData = AnnotatedMixinElementHandler.stripOwnerData(obfData);

            try {
               this.obf.getReferenceManager().addFieldMapping(this.mixin.getClassRef(), elem.getTargetName(), elem.getContext(), obfData);
            } catch (ReferenceManager$ReferenceConflictException var6) {
               elem.printMessage(this.ap, Kind.ERROR, "Mapping conflict for @Accessor target " + elem + ": " + var6.getNew() + " for target " + target + " conflicts with existing mapping " + var6.getOld());
            }

         }
      }
   }

   private void registerInvokerForTarget(AnnotatedMixinElementHandlerAccessor$AnnotatedElementInvoker elem, TypeHandle target) {
      MethodHandle targetMethod = target.findMethod(elem.getTargetName(), elem.getTargetTypeName(), false);
      if (targetMethod == null) {
         if (!target.isImaginary()) {
            elem.printMessage(this.ap, Kind.ERROR, "Could not locate @Invoker target " + elem + " in target " + target);
            return;
         }

         targetMethod = new MethodHandle(target, elem.getTargetName(), elem.getDesc());
      }

      if (elem.shouldRemap()) {
         ObfuscationData obfData = this.obf.getDataProvider().getObfMethod(targetMethod.asMapping(false).move(target.getName()));
         if (obfData.isEmpty()) {
            String info = this.mixin.isMultiTarget() ? " in target " + target : "";
            elem.printMessage(this.ap, Kind.WARNING, "Unable to locate obfuscation mapping" + info + " for @Accessor target " + elem);
         } else {
            obfData = AnnotatedMixinElementHandler.stripOwnerData(obfData);

            try {
               this.obf.getReferenceManager().addMethodMapping(this.mixin.getClassRef(), elem.getTargetName(), elem.getContext(), obfData);
            } catch (ReferenceManager$ReferenceConflictException var6) {
               elem.printMessage(this.ap, Kind.ERROR, "Mapping conflict for @Invoker target " + elem + ": " + var6.getNew() + " for target " + target + " conflicts with existing mapping " + var6.getOld());
            }

         }
      }
   }

   private String getAccessorTargetName(AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor elem) {
      String value = elem.getAnnotationValue();
      return Strings.isNullOrEmpty(value) ? this.inflectAccessorTarget(elem) : value;
   }

   private String inflectAccessorTarget(AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor elem) {
      return AccessorInfo.inflectTarget(elem.getSimpleName(), elem.getAccessorType(), "", this, false);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IReferenceMapper getReferenceMapper() {
      return this.getReferenceMapper();
   }
}
