package cn.sy.cn.sy.dao;

import cn.sy.entry.User;

import java.sql.SQLException;

/**
 * @author 20677
 */
public interface UserDao {
    /**
     * 查询
     * @param user
     * @return
     * @throws SQLException
     */
    public boolean select(User user) throws SQLException;

    /**
     * 更新
     * @param user
     * @return
     * @throws SQLException
     */
    public void update(User user) throws SQLException;

    /**
     * 显示
     * @param username
     * @return
     * @throws SQLException
     */
    public User show(String username) throws SQLException;
}
