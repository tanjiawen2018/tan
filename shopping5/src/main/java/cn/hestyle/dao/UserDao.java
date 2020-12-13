package cn.hestyle.dao;

import cn.hestyle.bean.User;

import java.util.List;

public interface UserDao {
    /**
     * 添加user到数据库
     * @param user
     * @return
     */
    public boolean insert(User user);

    /**
     * 依据userName、password查找用户
     * @param userName
     * @param password
     * @return
     */
    public User findUser(String userName, String password);

    /**
     * 依据userName查找用户
     * @param userName
     * @return
     */
    public User findUser(String userName);

    /**
     * 依据userName删除user
     * @param userName
     * @return
     */
    public boolean delUser(String userName);

    /**
     * 获取所有users
     * @return
     */
    public List<User> getAllUsers();
}
