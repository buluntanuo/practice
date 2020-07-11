package cn.sy.service;

import cn.sy.entry.User;

import java.sql.SQLException;

/**
 * @author 20677
 */
public interface UserService {
    /**
     * 登录
     * @param user
     * @return
     * @throws SQLException
     */
    public boolean loginService(User user) throws SQLException;

    /**
     * 注册
     * @param user
     * @throws SQLException
     */
    public void registerService(User user) throws SQLException;

    public User showService(String username) throws SQLException;
}
