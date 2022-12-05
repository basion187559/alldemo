package cn.basion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Copyright © DEEPEXI Technologies Co., Ltd. 2020-2022. All rights reserved.
 *
 * @author wupeineng
 * @Description:
 * @date 2022/11/27
 */
public class Main {

    public static void main(String[] args) throws  SQLException {


        Connection connection = DriverManager.getConnection("url", "user", "password");
        connection.prepareStatement("select * from table ");

        System.out.println(connection);

    }
}
