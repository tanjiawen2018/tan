package cn.hestyle.service.impl;

import cn.hestyle.bean.User;
import cn.hestyle.dao.UserDao;
import cn.hestyle.dao.impl.UserDaoImpl;
import cn.hestyle.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public boolean userNameIsValidate(String userName) {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUser(userName);
        return user == null;
    }

    @Override
    public boolean register(User user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.insert(user);
    }

    @Override
    public boolean login(String userName, String password) {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUser(userName, password);
        return user != null;
    }
}
