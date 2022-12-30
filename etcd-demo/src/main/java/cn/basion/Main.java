package cn.basion;

import cn.hutool.core.io.FileUtil;
import com.google.protobuf.ByteString;
import io.etcd.jetcd.ByteSequence;
import io.etcd.jetcd.Client;
import io.etcd.jetcd.KV;
import io.etcd.jetcd.KeyValue;
import io.etcd.jetcd.kv.GetResponse;
import io.etcd.jetcd.options.GetOption;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2020-2022. All rights reserved.
 *
 * @author wupeineng
 * @Description:
 * @date 2022/12/30
 */
public class Main {

    public static final File file  = new File("/Users/basion/workspace/alldemo/etcd-demo/src/main/resources/value.txt");
    public static final String seperator="___";
    public  static  Charset utf8 = Charset.forName("utf-8");
    public  static String sourceUrl ="http://10.0.0.10:31889";
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        saveValueToFile();
        copyValueFromFile();

    }



    public static void saveValueToFile() throws ExecutionException, InterruptedException {
        KV sourceClient = Client.builder().endpoints(sourceUrl).build().getKVClient();
        ByteSequence key = ByteSequence.from("\0", utf8);
        GetOption option = GetOption.newBuilder()
                .withSortField(GetOption.SortTarget.KEY)
                .withSortOrder(GetOption.SortOrder.DESCEND)
                .withRange(key)
                .build();
        CompletableFuture<GetResponse> futureResponse = sourceClient.get(key, option);
        GetResponse response = futureResponse.get();
            Map<String,String> map = new HashMap<>();
            for (KeyValue kv : response.getKvs()) {
                map.put(kv.getKey().toString(utf8),kv.getValue().toString(utf8));
            }
            FileUtil.writeMap(map,file,utf8,seperator,false);
    }


    public static void copyValueFromFile() throws ExecutionException, InterruptedException {


        KV targetClient = Client.builder().endpoints(sourceUrl).build().getKVClient();
        ByteSequence key = ByteSequence.from(ByteString.copyFrom("name", utf8));
        ByteSequence value = ByteSequence.from(ByteString.copyFrom("basion", utf8));
        targetClient.put(key,value);

//        List<String> list = new ArrayList<>();
//        FileUtil.readLines(file,utf8,list);
//        list.forEach(data->{
//            String[] datas = data.split(seperator);
//
//            targetClient.put(ByteSequence.from(datas[0],utf8), ByteSequence.from(datas[1],utf8));
//        });
        targetClient.close();
    }



}
