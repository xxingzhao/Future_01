package org.xiaoxz.auto.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author : xiaoxz
 * @Date: Created in 2017/11/10
 * @Modified by :
 **/
public class DataSourceUtil {

    private static String driver;
    private static String url;
    private static String username;
    private static String psssword;

    private Connection conn;
    private Statement statement;
    private ResultSet resultSet;

    static {
        try{
            String path = DataSourceUtil.class.getClassLoader().getResource("").getPath() + "org/xiaoxz/auto/config.properties";
            InputStream in  = new FileInputStream(new File(path));
            Properties prop = new Properties();
            prop.load(in);
            //获取数据库配置信息
            driver   = prop.getProperty("jdbc.driverClass");
            url      = prop.getProperty("jdbc.url");
            username = prop.getProperty("jdbc.username");
            psssword = prop.getProperty("jdbc.password");
            //加载驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public void getConnection() {
        try {
            this.conn = DriverManager.getConnection(url, username, psssword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建一个状态通道
     */
    public void createStatement() {
        this.getConnection();
        try {
            this.statement = this.conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于状态通道的查询方法
     * @param sql
     * @return
     */
    public ResultSet query(String sql) {
        this.createStatement();
        try {
            resultSet = this.statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void close() {
      if(this.resultSet != null) {
          try {
              this.resultSet.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }

      if(this.statement != null) {
          try {
              this.statement.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }

      if(this.conn != null) {
          try {
              this.conn.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
    }
}
