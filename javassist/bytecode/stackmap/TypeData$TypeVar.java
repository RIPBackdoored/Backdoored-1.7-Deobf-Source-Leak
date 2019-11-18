package javassist.bytecode.stackmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;

public class TypeData$TypeVar extends TypeData$AbsTypeVar {
   protected ArrayList lowers = new ArrayList(2);
   protected ArrayList usedBy = new ArrayList(2);
   protected ArrayList uppers = null;
   protected String fixedType;
   private boolean is2WordType;
   private int visited = 0;
   private int smallest = 0;
   private boolean inList = false;
   private int dimension = 0;

   public TypeData$TypeVar(TypeData t) {
      this.merge(t);
      this.fixedType = null;
      this.is2WordType = t.is2WordType();
   }

   public String getName() {
      return this.fixedType == null ? ((TypeData)this.lowers.get(0)).getName() : this.fixedType;
   }

   public TypeData$BasicType isBasicType() {
      return this.fixedType == null ? ((TypeData)this.lowers.get(0)).isBasicType() : null;
   }

   public boolean is2WordType() {
      return this.fixedType == null ? this.is2WordType : false;
   }

   public boolean isNullType() {
      return this.fixedType == null ? ((TypeData)this.lowers.get(0)).isNullType() : false;
   }

   public boolean isUninit() {
      return this.fixedType == null ? ((TypeData)this.lowers.get(0)).isUninit() : false;
   }

   public void merge(TypeData t) {
      this.lowers.add(t);
      if (t instanceof TypeData$TypeVar) {
         ((TypeData$TypeVar)t).usedBy.add(this);
      }

   }

   public int getTypeTag() {
      return this.fixedType == null ? ((TypeData)this.lowers.get(0)).getTypeTag() : super.getTypeTag();
   }

   public int getTypeData(ConstPool cp) {
      return this.fixedType == null ? ((TypeData)this.lowers.get(0)).getTypeData(cp) : super.getTypeData(cp);
   }

   public void setType(String typeName, ClassPool cp) throws BadBytecode {
      if (this.uppers == null) {
         this.uppers = new ArrayList();
      }

      this.uppers.add(typeName);
   }

   protected TypeData$TypeVar toTypeVar(int dim) {
      this.dimension = dim;
      return this;
   }

   public TypeData getArrayType(int dim) throws NotFoundException {
      if (dim == 0) {
         return this;
      } else {
         TypeData$BasicType bt = this.isBasicType();
         if (bt == null) {
            return (TypeData)(this.isNullType() ? new TypeData$NullType() : (new TypeData$ClassName(this.getName())).getArrayType(dim));
         } else {
            return bt.getArrayType(dim);
         }
      }
   }

   public int dfs(ArrayList preOrder, int index, ClassPool cp) throws NotFoundException {
      if (this.visited > 0) {
         return index;
      } else {
         ++index;
         this.visited = this.smallest = index;
         preOrder.add(this);
         this.inList = true;
         int n = this.lowers.size();

         TypeData$TypeVar child;
         for(int i = 0; i < n; ++i) {
            child = ((TypeData)this.lowers.get(i)).toTypeVar(this.dimension);
            if (child != null) {
               if (child.visited == 0) {
                  index = child.dfs(preOrder, index, cp);
                  if (child.smallest < this.smallest) {
                     this.smallest = child.smallest;
                  }
               } else if (child.inList && child.visited < this.smallest) {
                  this.smallest = child.visited;
               }
            }
         }

         if (this.visited == this.smallest) {
            ArrayList scc = new ArrayList();

            do {
               child = (TypeData$TypeVar)preOrder.remove(preOrder.size() - 1);
               child.inList = false;
               scc.add(child);
            } while(child != this);

            this.fixTypes(scc, cp);
         }

         return index;
      }
   }

   private void fixTypes(ArrayList scc, ClassPool cp) throws NotFoundException {
      HashSet lowersSet = new HashSet();
      boolean isBasicType = false;
      TypeData kind = null;
      int size = scc.size();

      for(int i = 0; i < size; ++i) {
         TypeData$TypeVar tvar = (TypeData$TypeVar)scc.get(i);
         ArrayList tds = tvar.lowers;
         int size2 = tds.size();

         for(int j = 0; j < size2; ++j) {
            TypeData td = (TypeData)tds.get(j);
            TypeData d = td.getArrayType(tvar.dimension);
            TypeData$BasicType bt = d.isBasicType();
            if (kind == null) {
               if (bt == null) {
                  isBasicType = false;
                  kind = d;
                  if (d.isUninit()) {
                     break;
                  }
               } else {
                  isBasicType = true;
                  kind = bt;
               }
            } else if (bt == null && isBasicType || bt != null && kind != bt) {
               isBasicType = true;
               kind = TypeTag.TOP;
               break;
            }

            if (bt == null && !d.isNullType()) {
               lowersSet.add(d.getName());
            }
         }
      }

      if (isBasicType) {
         this.is2WordType = ((TypeData)kind).is2WordType();
         this.fixTypes1(scc, (TypeData)kind);
      } else {
         String typeName = this.fixTypes2(scc, lowersSet, cp);
         this.fixTypes1(scc, new TypeData$ClassName(typeName));
      }

   }

   private void fixTypes1(ArrayList scc, TypeData kind) throws NotFoundException {
      int size = scc.size();

      for(int i = 0; i < size; ++i) {
         TypeData$TypeVar cv = (TypeData$TypeVar)scc.get(i);
         TypeData kind2 = kind.getArrayType(-cv.dimension);
         if (kind2.isBasicType() == null) {
            cv.fixedType = kind2.getName();
         } else {
            cv.lowers.clear();
            cv.lowers.add(kind2);
            cv.is2WordType = kind2.is2WordType();
         }
      }

   }

   private String fixTypes2(ArrayList scc, HashSet lowersSet, ClassPool cp) throws NotFoundException {
      Iterator it = lowersSet.iterator();
      if (lowersSet.size() == 0) {
         return null;
      } else if (lowersSet.size() == 1) {
         return (String)it.next();
      } else {
         CtClass cc;
         for(cc = cp.get((String)it.next()); it.hasNext(); cc = commonSuperClassEx(cc, cp.get((String)it.next()))) {
         }

         if (cc.getSuperclass() == null || isObjectArray(cc)) {
            cc = this.fixByUppers(scc, cp, new HashSet(), cc);
         }

         return cc.isArray() ? Descriptor.toJvmName(cc) : cc.getName();
      }
   }

   private static boolean isObjectArray(CtClass cc) throws NotFoundException {
      return cc.isArray() && cc.getComponentType().getSuperclass() == null;
   }

   private CtClass fixByUppers(ArrayList users, ClassPool cp, HashSet visited, CtClass type) throws NotFoundException {
      if (users == null) {
         return type;
      } else {
         int size = users.size();

         for(int i = 0; i < size; ++i) {
            TypeData$TypeVar t = (TypeData$TypeVar)users.get(i);
            if (!visited.add(t)) {
               return type;
            }

            if (t.uppers != null) {
               int s = t.uppers.size();

               for(int k = 0; k < s; ++k) {
                  CtClass cc = cp.get((String)t.uppers.get(k));
                  if (cc.subtypeOf(type)) {
                     type = cc;
                  }
               }
            }

            type = this.fixByUppers(t.usedBy, cp, visited, type);
         }

         return type;
      }
   }

   String toString2(HashSet hash) {
      hash.add(this);
      if (this.lowers.size() > 0) {
         TypeData e = (TypeData)this.lowers.get(0);
         if (e != null && !hash.contains(e)) {
            return e.toString2(hash);
         }
      }

      return "?";
   }
}
