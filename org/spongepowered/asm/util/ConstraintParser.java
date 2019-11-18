package org.spongepowered.asm.util;

import org.spongepowered.asm.lib.tree.AnnotationNode;

public final class ConstraintParser {
   private ConstraintParser() {
   }

   public static ConstraintParser$Constraint parse(String expr) {
      if (expr != null && expr.length() != 0) {
         String[] exprs = expr.replaceAll("\\s", "").toUpperCase().split(";");
         ConstraintParser$Constraint head = null;
         String[] var3 = exprs;
         int var4 = exprs.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            String subExpr = var3[var5];
            ConstraintParser$Constraint next = new ConstraintParser$Constraint(subExpr);
            if (head == null) {
               head = next;
            } else {
               head.append(next);
            }
         }

         return head != null ? head : ConstraintParser$Constraint.NONE;
      } else {
         return ConstraintParser$Constraint.NONE;
      }
   }

   public static ConstraintParser$Constraint parse(AnnotationNode annotation) {
      String constraints = (String)Annotations.getValue(annotation, "constraints", (Object)"");
      return parse(constraints);
   }
}
