package cn.sy.service.impl;

import cn.sy.cn.sy.dao.UserDao;
import cn.sy.cn.sy.dao.impl.UserDaoImpl;
import cn.sy.entry.User;
import cn.sy.service.UserService;

import java.sql.SQLException;

/**
 * @ClassName: UserServiceImpl
 * @Descriptin: TODO
 * @author: lkk
 * @Date: 2020/7/10 17:07
 * @Version: 1.0
 **/
public class UserServiceImpl implements UserService {

    @Override
    public boolean loginService(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        return userDao.select(user);
    }

    @Override
    public void registerService(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        userDao.update(user);
    }

    @Override
    public User showService(String username) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        return userDao.show(username);
    }
}
