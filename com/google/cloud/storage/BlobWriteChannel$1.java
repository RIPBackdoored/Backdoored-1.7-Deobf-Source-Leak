package com.google.cloud.storage;

class BlobWriteChannel$1 implements Runnable {
   // $FF: synthetic field
   final int val$length;
   // $FF: synthetic field
   final boolean val$last;
   // $FF: synthetic field
   final BlobWriteChannel this$0;

   BlobWriteChannel$1(BlobWriteChannel this$0, int var2, boolean var3) {
      this.this$0 = this$0;
      this.val$length = var2;
      this.val$last = var3;
   }

   public void run() {
      ((StorageOptions)BlobWriteChannel.access$300(this.this$0)).getStorageRpcV1().write(BlobWriteChannel.access$000(this.this$0), BlobWriteChannel.access$100(this.this$0), 0, BlobWriteChannel.access$200(this.this$0), this.val$length, this.val$last);
   }
}
