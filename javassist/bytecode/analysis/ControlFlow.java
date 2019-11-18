package javassist.bytecode.analysis;

import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.MethodInfo;

public class ControlFlow {
   private CtClass clazz;
   private MethodInfo methodInfo;
   private ControlFlow$Block[] basicBlocks;
   private Frame[] frames;

   public ControlFlow(CtMethod method) throws BadBytecode {
      this(method.getDeclaringClass(), method.getMethodInfo2());
   }

   public ControlFlow(CtClass ctclazz, MethodInfo minfo) throws BadBytecode {
      this.clazz = ctclazz;
      this.methodInfo = minfo;
      this.frames = null;
      this.basicBlocks = (ControlFlow$Block[])((ControlFlow$Block[])(new ControlFlow$1(this)).make(minfo));
      if (this.basicBlocks == null) {
         this.basicBlocks = new ControlFlow$Block[0];
      }

      int size = this.basicBlocks.length;
      int[] counters = new int[size];

      int i;
      ControlFlow$Block b;
      for(i = 0; i < size; ++i) {
         b = this.basicBlocks[i];
         b.index = i;
         b.entrances = new ControlFlow$Block[b.incomings()];
         counters[i] = 0;
      }

      for(i = 0; i < size; ++i) {
         b = this.basicBlocks[i];

         for(int k = 0; k < b.exits(); ++k) {
            ControlFlow$Block e = b.exit(k);
            e.entrances[counters[e.index]++] = b;
         }

         ControlFlow$Catcher[] catchers = b.catchers();

         for(int k = 0; k < catchers.length; ++k) {
            ControlFlow$Block catchBlock = ControlFlow$Catcher.access$100(catchers[k]);
            catchBlock.entrances[counters[catchBlock.index]++] = b;
         }
      }

   }

   public ControlFlow$Block[] basicBlocks() {
      return this.basicBlocks;
   }

   public Frame frameAt(int pos) throws BadBytecode {
      if (this.frames == null) {
         this.frames = (new Analyzer()).analyze(this.clazz, this.methodInfo);
      }

      return this.frames[pos];
   }

   public ControlFlow$Node[] dominatorTree() {
      int size = this.basicBlocks.length;
      if (size == 0) {
         return null;
      } else {
         ControlFlow$Node[] nodes = new ControlFlow$Node[size];
         boolean[] visited = new boolean[size];
         int[] distance = new int[size];

         for(int i = 0; i < size; ++i) {
            nodes[i] = new ControlFlow$Node(this.basicBlocks[i]);
            visited[i] = false;
         }

         ControlFlow$Access access = new ControlFlow$2(this, nodes);
         nodes[0].makeDepth1stTree((ControlFlow$Node)null, visited, 0, distance, access);

         do {
            for(int i = 0; i < size; ++i) {
               visited[i] = false;
            }
         } while(nodes[0].makeDominatorTree(visited, distance, access));

         ControlFlow$Node.access$300(nodes);
         return nodes;
      }
   }

   public ControlFlow$Node[] postDominatorTree() {
      int size = this.basicBlocks.length;
      if (size == 0) {
         return null;
      } else {
         ControlFlow$Node[] nodes = new ControlFlow$Node[size];
         boolean[] visited = new boolean[size];
         int[] distance = new int[size];

         for(int i = 0; i < size; ++i) {
            nodes[i] = new ControlFlow$Node(this.basicBlocks[i]);
            visited[i] = false;
         }

         ControlFlow$Access access = new ControlFlow$3(this, nodes);
         int counter = 0;

         for(int i = 0; i < size; ++i) {
            if (ControlFlow$Node.access$200(nodes[i]).exits() == 0) {
               counter = nodes[i].makeDepth1stTree((ControlFlow$Node)null, visited, counter, distance, access);
            }
         }

         boolean changed;
         do {
            int i;
            for(i = 0; i < size; ++i) {
               visited[i] = false;
            }

            changed = false;

            for(i = 0; i < size; ++i) {
               if (ControlFlow$Node.access$200(nodes[i]).exits() == 0 && nodes[i].makeDominatorTree(visited, distance, access)) {
                  changed = true;
               }
            }
         } while(changed);

         ControlFlow$Node.access$300(nodes);
         return nodes;
      }
   }

   // $FF: synthetic method
   static MethodInfo access$000(ControlFlow x0) {
      return x0.methodInfo;
   }
}
