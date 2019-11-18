package com.google.api.client.googleapis.media;

import java.io.IOException;

public interface MediaHttpDownloaderProgressListener {
   void progressChanged(MediaHttpDownloader var1) throws IOException;
}
