package com.ming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接
        Connection connection = DriverManager.getConnection("cdb-1yfd1mlm.cd.tencentcdb.com:10056/test05", "root", "ABCcba20170607");

    }
}
