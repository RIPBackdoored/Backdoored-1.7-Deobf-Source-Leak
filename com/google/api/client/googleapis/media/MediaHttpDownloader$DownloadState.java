package com.google.api.client.googleapis.media;

public final class MediaHttpDownloader$DownloadState extends Enum {
   public static final MediaHttpDownloader$DownloadState NOT_STARTED = new MediaHttpDownloader$DownloadState("NOT_STARTED", 0);
   public static final MediaHttpDownloader$DownloadState MEDIA_IN_PROGRESS = new MediaHttpDownloader$DownloadState("MEDIA_IN_PROGRESS", 1);
   public static final MediaHttpDownloader$DownloadState MEDIA_COMPLETE = new MediaHttpDownloader$DownloadState("MEDIA_COMPLETE", 2);
   // $FF: synthetic field
   private static final MediaHttpDownloader$DownloadState[] $VALUES = new MediaHttpDownloader$DownloadState[]{NOT_STARTED, MEDIA_IN_PROGRESS, MEDIA_COMPLETE};

   public static MediaHttpDownloader$DownloadState[] values() {
      return (MediaHttpDownloader$DownloadState[])$VALUES.clone();
   }

   public static MediaHttpDownloader$DownloadState valueOf(String name) {
      return (MediaHttpDownloader$DownloadState)Enum.valueOf(MediaHttpDownloader$DownloadState.class, name);
   }

   private MediaHttpDownloader$DownloadState(String var1, int var2) {
      super(var1, var2);
   }
}
