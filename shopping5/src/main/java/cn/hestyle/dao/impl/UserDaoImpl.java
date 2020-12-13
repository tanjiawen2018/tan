package cn.hestyle.dao.impl;

import cn.hestyle.bean.User;
import cn.hestyle.dao.UserDao;
import cn.hestyle.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean insert(User user) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        try {
            //第1步：建立连接(Connection)
            conn = DBUtil.getConnection();
            //第2步：构建sql语句
            String sql = "INSERT INTO users VALUES(?, ?, ?, ?);";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, user.getUserName());
            preStatement.setString(2, user.getPassword());
            preStatement.setString(3, user.getGender());
            preStatement.setString(4, user.getEmailAddr());
            //第3步：执行sql语句
            int resCnt = preStatement.executeUpdate();
            if (resCnt == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //第4步：关闭资源
            DBUtil.closeAll(conn, preStatement, null);
        }
        return false;
    }

    @Override
    public User findUser(String userName, String password) {
        User user = null;
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        try {
            //第1步：建立连接(Connection)
            conn = DBUtil.getConnection();
            //第2步：构建sql语句
            String sql = "SELECT * FROM users where userName = ? AND password = ?;";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, userName);
            preStatement.setString(2, password);
            //第3步：执行sql语句
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setUserName(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setGender(resultSet.getString(3));
                user.setEmailAddr(resultSet.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //第4步：关闭资源
            DBUtil.closeAll(conn, preStatement, resultSet);
        }
        return user;
    }

    @Override
    public User findUser(String userName) {
        User user = null;
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        try {
            //第1步：建立连接(Connection)
            conn = DBUtil.getConnection();
            //第2步：构建sql语句
            String sql = "SELECT * FROM users where userName = ?;";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, userName);
            //第3步：执行sql语句
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setUserName(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setGender(resultSet.getString(3));
                user.setEmailAddr(resultSet.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //第4步：关闭资源
            DBUtil.closeAll(conn, preStatement, resultSet);
        }
        return user;
    }

    @Override
    public boolean delUser(String userName) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        try {
            //第1步：建立连接(Connection)
            conn = DBUtil.getConnection();
            //第2步：构建sql语句
            String sql = "DELETE FROM users WHERE userName = ?;";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, userName);
            //第3步：执行sql语句
            int resCnt = preStatement.executeUpdate();
            if (resCnt == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //第4步：关闭资源
            DBUtil.closeAll(conn, preStatement, null);
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> usersList = null;
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //第1步：建立连接(Connection)
            conn = DBUtil.getConnection();
            //第2步：构建sql语句
            String sql = "SELECT * FROM users;";
            statement = conn.createStatement();
            //第3步：执行sql语句
            //第3步：执行sql语句
            resultSet = statement.executeQuery(sql);
            usersList = new ArrayList<User>();
            while (resultSet.next()) {
                User user = new User();
                user.setUserName(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setGender(resultSet.getString(3));
                user.setEmailAddr(resultSet.getString(4));
                usersList.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //第4步：关闭资源
            DBUtil.closeAll(conn, statement, resultSet);
        }
        return usersList;
    }

}
