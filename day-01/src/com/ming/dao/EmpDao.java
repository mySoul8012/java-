package com.ming.dao;


import com.ming.util.jdbcUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpDao {
    // 根据id修改姓名
    public int update(String empId, String empName) throws SQLException {
        // 获取连接
        Connection connection = jdbcUtils.getConnection();
        // 编写sql
        String sql = "update emp set name = ? where id = ?";
        // 获取预编译对象
        PreparedStatement preparedStatement  = connection.prepareStatement(sql);
        // 设置参数
        preparedStatement.setObject(1, empName);
        preparedStatement.setObject(2, empId);
        // 执行返回结果
        int i = preparedStatement.executeUpdate();
        // 进行资源释放
        jdbcUtils.close(preparedStatement, connection);
        // 返回结果一
        return i;

    }
}
