package com.google.api.client.repackaged.com.google.common.base;

final class AbstractIterator$State extends Enum {
   public static final AbstractIterator$State READY = new AbstractIterator$State("READY", 0);
   public static final AbstractIterator$State NOT_READY = new AbstractIterator$State("NOT_READY", 1);
   public static final AbstractIterator$State DONE = new AbstractIterator$State("DONE", 2);
   public static final AbstractIterator$State FAILED = new AbstractIterator$State("FAILED", 3);
   // $FF: synthetic field
   private static final AbstractIterator$State[] $VALUES = new AbstractIterator$State[]{READY, NOT_READY, DONE, FAILED};

   public static AbstractIterator$State[] values() {
      return (AbstractIterator$State[])$VALUES.clone();
   }

   public static AbstractIterator$State valueOf(String name) {
      return (AbstractIterator$State)Enum.valueOf(AbstractIterator$State.class, name);
   }

   private AbstractIterator$State(String var1, int var2) {
      super(var1, var2);
   }
}
