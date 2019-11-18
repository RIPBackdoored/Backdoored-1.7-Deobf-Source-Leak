package com.google.api.client.googleapis.media;

public final class MediaHttpUploader$UploadState extends Enum {
   public static final MediaHttpUploader$UploadState NOT_STARTED = new MediaHttpUploader$UploadState("NOT_STARTED", 0);
   public static final MediaHttpUploader$UploadState INITIATION_STARTED = new MediaHttpUploader$UploadState("INITIATION_STARTED", 1);
   public static final MediaHttpUploader$UploadState INITIATION_COMPLETE = new MediaHttpUploader$UploadState("INITIATION_COMPLETE", 2);
   public static final MediaHttpUploader$UploadState MEDIA_IN_PROGRESS = new MediaHttpUploader$UploadState("MEDIA_IN_PROGRESS", 3);
   public static final MediaHttpUploader$UploadState MEDIA_COMPLETE = new MediaHttpUploader$UploadState("MEDIA_COMPLETE", 4);
   // $FF: synthetic field
   private static final MediaHttpUploader$UploadState[] $VALUES = new MediaHttpUploader$UploadState[]{NOT_STARTED, INITIATION_STARTED, INITIATION_COMPLETE, MEDIA_IN_PROGRESS, MEDIA_COMPLETE};

   public static MediaHttpUploader$UploadState[] values() {
      return (MediaHttpUploader$UploadState[])$VALUES.clone();
   }

   public static MediaHttpUploader$UploadState valueOf(String name) {
      return (MediaHttpUploader$UploadState)Enum.valueOf(MediaHttpUploader$UploadState.class, name);
   }

   private MediaHttpUploader$UploadState(String var1, int var2) {
      super(var1, var2);
   }
}
