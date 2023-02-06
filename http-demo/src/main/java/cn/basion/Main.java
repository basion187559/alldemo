package cn.basion;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.List;
import java.util.Map;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2020-2022. All rights reserved.
 *
 * @author wupeineng
 * @Description:
 * @date 2022/12/17
 */
public class Main {

    public static void main(String[] args) {
        String authorization = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySW5mbyI6eyJhY2NvdW50SWQiOiI1MjkwIiwiZW50ZXJwcmlzZUNvZGUiOiJ3b3JrYmVuY2giLCJ0ZW5hbnRJZCI6Ijc5NTllMDllZjc4MDQ5M2ZhZmIxOWVmNzViNzEzMmJhIiwidXNlcklkIjoiODQyNCIsInVzZXJuYW1lIjoid29ya2JlbmNoIn0sImlhbVR5cGUiOiJjbGllbnQiLCJ1c2VyX25hbWUiOiJ3b3JrYmVuY2giLCJzY29wZSI6WyJhbGwiXSwiaWFtX2NsaWVudF9pZGVudGlmaWVyIjoiZmRiMDcwOWE0Y2E4MzA0Yzc0YmUzNmEyODExZjNhYjUiLCJleHAiOjE2NzEzMTE1NzksImp0aSI6ImJhYWMyOGE1LThhMTQtNDZjNi05ZjI1LWFkZGE4NzVhNjdhOSIsImNsaWVudF9pZCI6ImRlZXBleGkifQ.PBZE8kRJoWnvln8Qfg3pqI93BhBFZjNZvKPuVHzMIS0";
        String url = "https://dev-workbench.deepexi.com/deepexi-console/api/v1/dscatalog/tree";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization",authorization)
                .build();
        try {

            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                Map<String, List<String>> headers = response.headers().toMultimap();
                for(String key : headers.keySet()){
                    System.out.println(key+":"+headers.get(key).get(0));
                }



                byte[] bytes  = response.body().bytes();
                System.out.println(new String(bytes));
                for (byte b : bytes ){
                    System.out.print(Integer.toHexString(b)+" ");
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
