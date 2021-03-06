package com.backdoored.mixin;

import  l. c. q;
import  l. c. w;
import  l. c. n. t;
import com.google.common.base.Throwables;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import net.minecraft.crash.CrashReport;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({CrashReport.class})
public class MixinCrashReport {
   @Final
   @Shadow
   private Throwable field_71511_b;

   @Redirect(
      method = {"getCompleteReport"},
      at = @At(
   value = "INVOKE",
   target = "Ljava/lang/StringBuilder;toString()Ljava/lang/String;"
)
   )
   public String interceptReport(StringBuilder stringBuilder) {
      String var10000;
      try {
         var10000 =  w.k(stringBuilder);
      } catch (Throwable var3) {
         return stringBuilder.toString();
      }

      return var10000;
   }

   @Inject(
      method = {"saveToFile"},
      at = {@At("RETURN")}
   )
   private void showDialog(File toFile, CallbackInfoReturnable cir) {
      if ( q.fyb.func_71372_G()) {
          q.fyb.func_71352_k();
      }

      Frame frame = new Frame();
      frame.setAlwaysOnTop(true);
      frame.setState(1);
      JPanel panel = new JPanel();
      panel.setBorder(new EmptyBorder(5, 5, 5, 5));
      panel.setLayout(new BorderLayout(0, 0));
      String fullReport = ((CrashReport)this).func_71502_e();

      String hasteBinUrl;
      try {
         hasteBinUrl =  t.k("http://paste.dimdev.org", "mccrash", fullReport);
      } catch (Exception var10) {
         hasteBinUrl = var10.getMessage();
      }

      JTextArea comp = new JTextArea("Uploaded crash report: " + hasteBinUrl + "\n" + Throwables.getStackTraceAsString(this.field_71511_b));
      comp.setEditable(false);
      JScrollPane scroll = new JScrollPane(comp, 22, 32);
      panel.add(scroll);
      StackTraceElement trace;
      if (this.field_71511_b.getStackTrace().length > 0) {
         trace = this.field_71511_b.getStackTrace()[0];
      } else {
         trace = new StackTraceElement("", "", "", -1);
      }

      JOptionPane.showMessageDialog(frame, panel, "ERROR encountered at " + trace.toString(), 0);
      frame.requestFocus();
   }
}
