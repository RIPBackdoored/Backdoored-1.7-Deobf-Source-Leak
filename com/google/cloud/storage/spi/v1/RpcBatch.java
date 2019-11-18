package com.google.cloud.storage.spi.v1;

import com.google.api.services.storage.model.StorageObject;
import java.util.Map;

public interface RpcBatch {
   void addDelete(StorageObject var1, RpcBatch$Callback var2, Map var3);

   void addPatch(StorageObject var1, RpcBatch$Callback var2, Map var3);

   void addGet(StorageObject var1, RpcBatch$Callback var2, Map var3);

   void submit();
}
