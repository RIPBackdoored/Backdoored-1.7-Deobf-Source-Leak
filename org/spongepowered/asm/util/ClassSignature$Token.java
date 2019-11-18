package org.spongepowered.asm.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ClassSignature$Token implements ClassSignature$IToken {
   static final String SYMBOLS = "+-*";
   private final boolean inner;
   private boolean array;
   private char symbol;
   private String type;
   private List classBound;
   private List ifaceBound;
   private List signature;
   private List suffix;
   private ClassSignature$Token tail;

   ClassSignature$Token() {
      this(false);
   }

   ClassSignature$Token(String type) {
      this(type, false);
   }

   ClassSignature$Token(char symbol) {
      this();
      this.symbol = symbol;
   }

   ClassSignature$Token(boolean inner) {
      this((String)null, inner);
   }

   ClassSignature$Token(String type, boolean inner) {
      this.symbol = 0;
      this.inner = inner;
      this.type = type;
   }

   ClassSignature$Token setSymbol(char symbol) {
      if (this.symbol == 0 && "+-*".indexOf(symbol) > -1) {
         this.symbol = symbol;
      }

      return this;
   }

   ClassSignature$Token setType(String type) {
      if (this.type == null) {
         this.type = type;
      }

      return this;
   }

   boolean hasClassBound() {
      return this.classBound != null;
   }

   boolean hasInterfaceBound() {
      return this.ifaceBound != null;
   }

   public ClassSignature$IToken setArray(boolean array) {
      this.array |= array;
      return this;
   }

   public ClassSignature$IToken setWildcard(char wildcard) {
      return "+-".indexOf(wildcard) == -1 ? this : this.setSymbol(wildcard);
   }

   private List getClassBound() {
      if (this.classBound == null) {
         this.classBound = new ArrayList();
      }

      return this.classBound;
   }

   private List getIfaceBound() {
      if (this.ifaceBound == null) {
         this.ifaceBound = new ArrayList();
      }

      return this.ifaceBound;
   }

   private List getSignature() {
      if (this.signature == null) {
         this.signature = new ArrayList();
      }

      return this.signature;
   }

   private List getSuffix() {
      if (this.suffix == null) {
         this.suffix = new ArrayList();
      }

      return this.suffix;
   }

   ClassSignature$IToken addTypeArgument(char symbol) {
      if (this.tail != null) {
         return this.tail.addTypeArgument(symbol);
      } else {
         ClassSignature$Token token = new ClassSignature$Token(symbol);
         this.getSignature().add(token);
         return token;
      }
   }

   ClassSignature$IToken addTypeArgument(String name) {
      if (this.tail != null) {
         return this.tail.addTypeArgument(name);
      } else {
         ClassSignature$Token token = new ClassSignature$Token(name);
         this.getSignature().add(token);
         return token;
      }
   }

   ClassSignature$IToken addTypeArgument(ClassSignature$Token token) {
      if (this.tail != null) {
         return this.tail.addTypeArgument(token);
      } else {
         this.getSignature().add(token);
         return token;
      }
   }

   ClassSignature$IToken addTypeArgument(ClassSignature$TokenHandle token) {
      if (this.tail != null) {
         return this.tail.addTypeArgument(token);
      } else {
         ClassSignature$TokenHandle handle = token.clone();
         this.getSignature().add(handle);
         return handle;
      }
   }

   ClassSignature$Token addBound(String bound, boolean classBound) {
      return classBound ? this.addClassBound(bound) : this.addInterfaceBound(bound);
   }

   ClassSignature$Token addClassBound(String bound) {
      ClassSignature$Token token = new ClassSignature$Token(bound);
      this.getClassBound().add(token);
      return token;
   }

   ClassSignature$Token addInterfaceBound(String bound) {
      ClassSignature$Token token = new ClassSignature$Token(bound);
      this.getIfaceBound().add(token);
      return token;
   }

   ClassSignature$Token addInnerClass(String name) {
      this.tail = new ClassSignature$Token(name, true);
      this.getSuffix().add(this.tail);
      return this.tail;
   }

   public String toString() {
      return this.asType();
   }

   public String asBound() {
      StringBuilder sb = new StringBuilder();
      if (this.type != null) {
         sb.append(this.type);
      }

      Iterator var2;
      ClassSignature$Token token;
      if (this.classBound != null) {
         var2 = this.classBound.iterator();

         while(var2.hasNext()) {
            token = (ClassSignature$Token)var2.next();
            sb.append(token.asType());
         }
      }

      if (this.ifaceBound != null) {
         var2 = this.ifaceBound.iterator();

         while(var2.hasNext()) {
            token = (ClassSignature$Token)var2.next();
            sb.append(':').append(token.asType());
         }
      }

      return sb.toString();
   }

   public String asType() {
      return this.asType(false);
   }

   public String asType(boolean raw) {
      StringBuilder sb = new StringBuilder();
      if (this.array) {
         sb.append('[');
      }

      if (this.symbol != 0) {
         sb.append(this.symbol);
      }

      if (this.type == null) {
         return sb.toString();
      } else {
         if (!this.inner) {
            sb.append('L');
         }

         sb.append(this.type);
         if (!raw) {
            Iterator var3;
            ClassSignature$IToken token;
            if (this.signature != null) {
               sb.append('<');
               var3 = this.signature.iterator();

               while(var3.hasNext()) {
                  token = (ClassSignature$IToken)var3.next();
                  sb.append(token.asType());
               }

               sb.append('>');
            }

            if (this.suffix != null) {
               var3 = this.suffix.iterator();

               while(var3.hasNext()) {
                  token = (ClassSignature$IToken)var3.next();
                  sb.append('.').append(token.asType());
               }
            }
         }

         if (!this.inner) {
            sb.append(';');
         }

         return sb.toString();
      }
   }

   boolean isRaw() {
      return this.signature == null;
   }

   String getClassType() {
      return this.type != null ? this.type : "java/lang/Object";
   }

   public ClassSignature$Token asToken() {
      return this;
   }
}
