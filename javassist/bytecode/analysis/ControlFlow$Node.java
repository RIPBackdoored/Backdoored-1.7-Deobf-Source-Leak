package javassist.bytecode.analysis;

import javassist.bytecode.stackmap.BasicBlock;

public class ControlFlow$Node {
   private ControlFlow$Block block;
   private ControlFlow$Node parent;
   private ControlFlow$Node[] children;

   ControlFlow$Node(ControlFlow$Block b) {
      this.block = b;
      this.parent = null;
   }

   public String toString() {
      StringBuffer sbuf = new StringBuffer();
      sbuf.append("Node[pos=").append(this.block().position());
      sbuf.append(", parent=");
      sbuf.append(this.parent == null ? "*" : Integer.toString(this.parent.block().position()));
      sbuf.append(", children{");

      for(int i = 0; i < this.children.length; ++i) {
         sbuf.append(this.children[i].block().position()).append(", ");
      }

      sbuf.append("}]");
      return sbuf.toString();
   }

   public ControlFlow$Block block() {
      return this.block;
   }

   public ControlFlow$Node parent() {
      return this.parent;
   }

   public int children() {
      return this.children.length;
   }

   public ControlFlow$Node child(int n) {
      return this.children[n];
   }

   int makeDepth1stTree(ControlFlow$Node caller, boolean[] visited, int counter, int[] distance, ControlFlow$Access access) {
      int index = this.block.index;
      if (visited[index]) {
         return counter;
      } else {
         visited[index] = true;
         this.parent = caller;
         BasicBlock[] exits = access.exits(this);
         if (exits != null) {
            for(int i = 0; i < exits.length; ++i) {
               ControlFlow$Node n = access.node(exits[i]);
               counter = n.makeDepth1stTree(this, visited, counter, distance, access);
            }
         }

         distance[index] = counter++;
         return counter;
      }
   }

   boolean makeDominatorTree(boolean[] visited, int[] distance, ControlFlow$Access access) {
      int index = this.block.index;
      if (visited[index]) {
         return false;
      } else {
         visited[index] = true;
         boolean changed = false;
         BasicBlock[] exits = access.exits(this);
         if (exits != null) {
            for(int i = 0; i < exits.length; ++i) {
               ControlFlow$Node n = access.node(exits[i]);
               if (n.makeDominatorTree(visited, distance, access)) {
                  changed = true;
               }
            }
         }

         BasicBlock[] entrances = access.entrances(this);
         if (entrances != null) {
            for(int i = 0; i < entrances.length; ++i) {
               if (this.parent != null) {
                  ControlFlow$Node n = getAncestor(this.parent, access.node(entrances[i]), distance);
                  if (n != this.parent) {
                     this.parent = n;
                     changed = true;
                  }
               }
            }
         }

         return changed;
      }
   }

   private static ControlFlow$Node getAncestor(ControlFlow$Node n1, ControlFlow$Node n2, int[] distance) {
      while(true) {
         if (n1 != n2) {
            if (distance[n1.block.index] < distance[n2.block.index]) {
               n1 = n1.parent;
            } else {
               n2 = n2.parent;
            }

            if (n1 != null && n2 != null) {
               continue;
            }

            return null;
         }

         return n1;
      }
   }

   private static void setChildren(ControlFlow$Node[] all) {
      int size = all.length;
      int[] nchildren = new int[size];

      int i;
      for(i = 0; i < size; ++i) {
         nchildren[i] = 0;
      }

      ControlFlow$Node n;
      for(i = 0; i < size; ++i) {
         n = all[i].parent;
         if (n != null) {
            ++nchildren[n.block.index];
         }
      }

      for(i = 0; i < size; ++i) {
         all[i].children = new ControlFlow$Node[nchildren[i]];
      }

      for(i = 0; i < size; ++i) {
         nchildren[i] = 0;
      }

      for(i = 0; i < size; ++i) {
         n = all[i];
         ControlFlow$Node p = n.parent;
         if (p != null) {
            p.children[nchildren[p.block.index]++] = n;
         }
      }

   }

   // $FF: synthetic method
   static ControlFlow$Block access$200(ControlFlow$Node x0) {
      return x0.block;
   }

   // $FF: synthetic method
   static void access$300(ControlFlow$Node[] x0) {
      setChildren(x0);
   }
}
