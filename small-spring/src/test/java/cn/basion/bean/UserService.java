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

    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }

}
