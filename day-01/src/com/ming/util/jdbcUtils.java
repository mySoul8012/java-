package com.ming.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class  jdbcUtils {
    // 声明成员变量
    private static DataSource dataSource;

    // 初始化连接池
    static {
        try{
            // 通过类加载器，读取配置文件，获取io流
            InputStream inputStream = jdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            // 创建properties对象
            Properties properties = new Properties();
            // 进行装载
            properties.load(inputStream);
            // 通过工厂创建连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


    // 释放资源的方法
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        // 关闭结果集
        if(resultSet != null){
            try{
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 关闭sql执行对象
        if(statement != null){
            try{
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 关闭连接对象
        if(connection != null){
            try{
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 方法重载
    public static void close(Statement statement, Connection connection){
        close(null, statement, connection);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(DataSource dataSource) {
        jdbcUtils.dataSource = dataSource;
    }
}
