package cn.basion.bean;

import lombok.Data;

/**
 * @description:
 * @author: wupeineng
 * @create: 2022-12-09 8:59
 */
@Data
public class UserService {
    private String uId;

    private UserDao userDao;
    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));
    }
}
