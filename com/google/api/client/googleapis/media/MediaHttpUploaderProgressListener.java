package com.google.api.client.googleapis.media;

import java.io.IOException;

public interface MediaHttpUploaderProgressListener {
   void progressChanged(MediaHttpUploader var1) throws IOException;
}
