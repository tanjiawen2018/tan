package cn.hestyle.service;

import cn.hestyle.bean.User;

public interface UserService {
    /**
     * 检测用户名是否已被注册
     * @param userName
     * @return
     */
    public boolean userNameIsValidate(String userName);

    /**
     * 注册账号
     * @param user
     * @return
     */
    public boolean register(User user);

    /**
     * 登录账号
     * @param userName
     * @param password
     * @return
     */
    public boolean login(String userName, String password);
}
