package javassist.bytecode;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SignatureAttribute extends AttributeInfo {
   public static final String tag = "Signature";

   SignatureAttribute(ConstPool cp, int n, DataInputStream in) throws IOException {
      super(cp, n, in);
   }

   public SignatureAttribute(ConstPool cp, String signature) {
      super(cp, "Signature");
      int index = cp.addUtf8Info(signature);
      byte[] bvalue = new byte[]{(byte)(index >>> 8), (byte)index};
      this.set(bvalue);
   }

   public String getSignature() {
      return this.getConstPool().getUtf8Info(ByteArray.readU16bit(this.get(), 0));
   }

   public void setSignature(String sig) {
      int index = this.getConstPool().addUtf8Info(sig);
      ByteArray.write16bit(index, this.info, 0);
   }

   public AttributeInfo copy(ConstPool newCp, Map classnames) {
      return new SignatureAttribute(newCp, this.getSignature());
   }

   void renameClass(String oldname, String newname) {
      String sig = renameClass(this.getSignature(), oldname, newname);
      this.setSignature(sig);
   }

   void renameClass(Map classnames) {
      String sig = renameClass(this.getSignature(), classnames);
      this.setSignature(sig);
   }

   static String renameClass(String desc, String oldname, String newname) {
      Map map = new HashMap();
      map.put(oldname, newname);
      return renameClass(desc, (Map)map);
   }

   static String renameClass(String desc, Map map) {
      if (map == null) {
         return desc;
      } else {
         StringBuilder newdesc = new StringBuilder();
         int head = 0;
         int i = 0;

         int j;
         while(true) {
            j = desc.indexOf(76, i);
            if (j < 0) {
               break;
            }

            StringBuilder nameBuf = new StringBuilder();
            int k = j;

            char c;
            try {
               while(true) {
                  ++k;
                  if ((c = desc.charAt(k)) == ';') {
                     break;
                  }

                  nameBuf.append(c);
                  if (c == '<') {
                     while(true) {
                        ++k;
                        if ((c = desc.charAt(k)) == '>') {
                           nameBuf.append(c);
                           break;
                        }

                        nameBuf.append(c);
                     }
                  }
               }
            } catch (IndexOutOfBoundsException var11) {
               break;
            }

            i = k + 1;
            String name = nameBuf.toString();
            String name2 = (String)map.get(name);
            if (name2 != null) {
               newdesc.append(desc.substring(head, j));
               newdesc.append('L');
               newdesc.append(name2);
               newdesc.append(c);
               head = i;
            }
         }

         if (head == 0) {
            return desc;
         } else {
            j = desc.length();
            if (head < j) {
               newdesc.append(desc.substring(head, j));
            }

            return newdesc.toString();
         }
      }
   }

   private static boolean isNamePart(int c) {
      return c != 59 && c != 60;
   }

   public static SignatureAttribute$ClassSignature toClassSignature(String sig) throws BadBytecode {
      SignatureAttribute$ClassSignature var10000;
      try {
         var10000 = parseSig(sig);
      } catch (IndexOutOfBoundsException var2) {
         throw error(sig);
      }

      return var10000;
   }

   public static SignatureAttribute$MethodSignature toMethodSignature(String sig) throws BadBytecode {
      SignatureAttribute$MethodSignature var10000;
      try {
         var10000 = parseMethodSig(sig);
      } catch (IndexOutOfBoundsException var2) {
         throw error(sig);
      }

      return var10000;
   }

   public static SignatureAttribute$ObjectType toFieldSignature(String sig) throws BadBytecode {
      SignatureAttribute$ObjectType var10000;
      try {
         var10000 = parseObjectType(sig, new SignatureAttribute$Cursor((SignatureAttribute$1)null), false);
      } catch (IndexOutOfBoundsException var2) {
         throw error(sig);
      }

      return var10000;
   }

   public static SignatureAttribute$Type toTypeSignature(String sig) throws BadBytecode {
      SignatureAttribute$Type var10000;
      try {
         var10000 = parseType(sig, new SignatureAttribute$Cursor((SignatureAttribute$1)null));
      } catch (IndexOutOfBoundsException var2) {
         throw error(sig);
      }

      return var10000;
   }

   private static SignatureAttribute$ClassSignature parseSig(String sig) throws BadBytecode, IndexOutOfBoundsException {
      SignatureAttribute$Cursor cur = new SignatureAttribute$Cursor((SignatureAttribute$1)null);
      SignatureAttribute$TypeParameter[] tp = parseTypeParams(sig, cur);
      SignatureAttribute$ClassType superClass = parseClassType(sig, cur);
      int sigLen = sig.length();
      ArrayList ifArray = new ArrayList();

      while(cur.position < sigLen && sig.charAt(cur.position) == 'L') {
         ifArray.add(parseClassType(sig, cur));
      }

      SignatureAttribute$ClassType[] ifs = (SignatureAttribute$ClassType[])((SignatureAttribute$ClassType[])ifArray.toArray(new SignatureAttribute$ClassType[ifArray.size()]));
      return new SignatureAttribute$ClassSignature(tp, superClass, ifs);
   }

   private static SignatureAttribute$MethodSignature parseMethodSig(String sig) throws BadBytecode {
      SignatureAttribute$Cursor cur = new SignatureAttribute$Cursor((SignatureAttribute$1)null);
      SignatureAttribute$TypeParameter[] tp = parseTypeParams(sig, cur);
      if (sig.charAt(cur.position++) != '(') {
         throw error(sig);
      } else {
         ArrayList params = new ArrayList();

         SignatureAttribute$Type ret;
         while(sig.charAt(cur.position) != ')') {
            ret = parseType(sig, cur);
            params.add(ret);
         }

         ++cur.position;
         ret = parseType(sig, cur);
         int sigLen = sig.length();
         ArrayList exceptions = new ArrayList();

         while(cur.position < sigLen && sig.charAt(cur.position) == '^') {
            ++cur.position;
            SignatureAttribute$ObjectType t = parseObjectType(sig, cur, false);
            if (t instanceof SignatureAttribute$ArrayType) {
               throw error(sig);
            }

            exceptions.add(t);
         }

         SignatureAttribute$Type[] p = (SignatureAttribute$Type[])((SignatureAttribute$Type[])params.toArray(new SignatureAttribute$Type[params.size()]));
         SignatureAttribute$ObjectType[] ex = (SignatureAttribute$ObjectType[])((SignatureAttribute$ObjectType[])exceptions.toArray(new SignatureAttribute$ObjectType[exceptions.size()]));
         return new SignatureAttribute$MethodSignature(tp, p, ret, ex);
      }
   }

   private static SignatureAttribute$TypeParameter[] parseTypeParams(String sig, SignatureAttribute$Cursor cur) throws BadBytecode {
      ArrayList typeParam = new ArrayList();
      if (sig.charAt(cur.position) == '<') {
         ++cur.position;

         while(sig.charAt(cur.position) != '>') {
            int nameBegin = cur.position;
            int nameEnd = cur.indexOf(sig, 58);
            SignatureAttribute$ObjectType classBound = parseObjectType(sig, cur, true);
            ArrayList ifBound = new ArrayList();

            while(sig.charAt(cur.position) == ':') {
               ++cur.position;
               SignatureAttribute$ObjectType t = parseObjectType(sig, cur, false);
               ifBound.add(t);
            }

            SignatureAttribute$TypeParameter p = new SignatureAttribute$TypeParameter(sig, nameBegin, nameEnd, classBound, (SignatureAttribute$ObjectType[])((SignatureAttribute$ObjectType[])ifBound.toArray(new SignatureAttribute$ObjectType[ifBound.size()])));
            typeParam.add(p);
         }

         ++cur.position;
      }

      return (SignatureAttribute$TypeParameter[])((SignatureAttribute$TypeParameter[])typeParam.toArray(new SignatureAttribute$TypeParameter[typeParam.size()]));
   }

   private static SignatureAttribute$ObjectType parseObjectType(String sig, SignatureAttribute$Cursor c, boolean dontThrow) throws BadBytecode {
      int begin = c.position;
      switch(sig.charAt(begin)) {
      case 'L':
         return parseClassType2(sig, c, (SignatureAttribute$ClassType)null);
      case 'T':
         int i = c.indexOf(sig, 59);
         return new SignatureAttribute$TypeVariable(sig, begin + 1, i);
      case '[':
         return parseArray(sig, c);
      default:
         if (dontThrow) {
            return null;
         } else {
            throw error(sig);
         }
      }
   }

   private static SignatureAttribute$ClassType parseClassType(String sig, SignatureAttribute$Cursor c) throws BadBytecode {
      if (sig.charAt(c.position) == 'L') {
         return parseClassType2(sig, c, (SignatureAttribute$ClassType)null);
      } else {
         throw error(sig);
      }
   }

   private static SignatureAttribute$ClassType parseClassType2(String sig, SignatureAttribute$Cursor c, SignatureAttribute$ClassType parent) throws BadBytecode {
      int start = ++c.position;

      char t;
      do {
         t = sig.charAt(c.position++);
      } while(t != '$' && t != '<' && t != ';');

      int end = c.position - 1;
      SignatureAttribute$TypeArgument[] targs;
      if (t == '<') {
         targs = parseTypeArgs(sig, c);
         t = sig.charAt(c.position++);
      } else {
         targs = null;
      }

      SignatureAttribute$ClassType thisClass = SignatureAttribute$ClassType.make(sig, start, end, targs, parent);
      if (t != '$' && t != '.') {
         return thisClass;
      } else {
         --c.position;
         return parseClassType2(sig, c, thisClass);
      }
   }

   private static SignatureAttribute$TypeArgument[] parseTypeArgs(String sig, SignatureAttribute$Cursor c) throws BadBytecode {
      ArrayList args;
      char t;
      SignatureAttribute$TypeArgument ta;
      for(args = new ArrayList(); (t = sig.charAt(c.position++)) != '>'; args.add(ta)) {
         if (t == '*') {
            ta = new SignatureAttribute$TypeArgument((SignatureAttribute$ObjectType)null, '*');
         } else {
            if (t != '+' && t != '-') {
               t = ' ';
               --c.position;
            }

            ta = new SignatureAttribute$TypeArgument(parseObjectType(sig, c, false), t);
         }
      }

      return (SignatureAttribute$TypeArgument[])((SignatureAttribute$TypeArgument[])args.toArray(new SignatureAttribute$TypeArgument[args.size()]));
   }

   private static SignatureAttribute$ObjectType parseArray(String sig, SignatureAttribute$Cursor c) throws BadBytecode {
      int dim;
      for(dim = 1; sig.charAt(++c.position) == '['; ++dim) {
      }

      return new SignatureAttribute$ArrayType(dim, parseType(sig, c));
   }

   private static SignatureAttribute$Type parseType(String sig, SignatureAttribute$Cursor c) throws BadBytecode {
      SignatureAttribute$Type t = parseObjectType(sig, c, true);
      if (t == null) {
         t = new SignatureAttribute$BaseType(sig.charAt(c.position++));
      }

      return (SignatureAttribute$Type)t;
   }

   private static BadBytecode error(String sig) {
      return new BadBytecode("bad signature: " + sig);
   }

   // $FF: synthetic method
   static BadBytecode access$000(String x0) {
      return error(x0);
   }
}
