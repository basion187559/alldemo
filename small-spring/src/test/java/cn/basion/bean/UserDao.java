package cn.basion.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-11 15:38
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("1001", "basion");
        hashMap.put("1002", "amy");
        hashMap.put("1003", "amy");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
