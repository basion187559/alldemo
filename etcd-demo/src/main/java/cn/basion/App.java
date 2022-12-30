package cn.basion;

import io.etcd.jetcd.ByteSequence;
import io.etcd.jetcd.Client;
import io.etcd.jetcd.KV;
import io.etcd.jetcd.KeyValue;
import io.etcd.jetcd.kv.GetResponse;
import io.etcd.jetcd.options.GetOption;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        Charset utf8 = Charset.forName("utf-8");
        String sourceUrl ="http://10.201.0.69:37716";
        String targetUrl ="http://10.201.0.69:33534";
        KV sourceClient = Client.builder().endpoints(sourceUrl).build().getKVClient();
        ByteSequence key = ByteSequence.from("\0", utf8);
        GetOption option = GetOption.newBuilder()
                .withSortField(GetOption.SortTarget.KEY)
                .withSortOrder(GetOption.SortOrder.DESCEND)
                .withRange(key)
                .build();
        CompletableFuture<GetResponse> futureResponse = sourceClient.get(key, option);
        GetResponse response = futureResponse.get();


        KV targetClient = Client.builder().endpoints(targetUrl).build().getKVClient();
        for (KeyValue kv : response.getKvs()) {
            System.out.println(kv.getKey().toString(utf8)+":"+kv.getValue().toString(utf8));
            targetClient.put(kv.getKey(), kv.getValue());
            sourceClient.delete(kv.getKey());
        }
        targetClient.close();
        sourceClient.close();
    }
}
