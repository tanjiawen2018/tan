package cn.hestyle.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {
    //连接数据库的用户名、密码
    private static String url;
    private static String user;
    private static String password;
    private static String driverClass;

    static{
        //从db.properties文件中读取数据库配置信息
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        url = resourceBundle.getString("url");
        user = resourceBundle.getString("user");
        password = resourceBundle.getString("password");
        driverClass = resourceBundle.getString("driverClass");
        //静态代码块，在加载该类的时候加载
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 获取Connection
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 关闭三个资源，dao层有多个方法会用到关闭资源的操作，所以进行封装
     * @param conn
     * @param statement
     * @param resultSet
     */
    public static void closeAll(Connection conn, Statement statement, ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

