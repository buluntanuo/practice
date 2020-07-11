package cn.sy.cn.sy.dao.impl;

import cn.sy.cn.sy.dao.UserDao;
import cn.sy.entry.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: UserDaoImpl
 * @Descriptin: TODO
 * @author: lkk
 * @Date: 2020/7/10 17:05
 * @Version: 1.0
 **/
public class UserDaoImpl implements UserDao {

    @Override
    public boolean select(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
        String sql = "select count(*) from usertable where u_username=? and u_password=?";
        Object count = qr.query(sql,new ScalarHandler(),user.getUsername(),user.getPassword());
        if ((Long) count != 0) {
            return true;
        }
        return false;
    }

    @Override
    public void update(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
        String sql = "insert into usertable values(?,?,?,?,?,?)";
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH-mm-ss");
        qr.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),
                dateFormat.format(date),dateFormat.format(date));
    }

    @Override
    public User show(String username) throws SQLException {
        QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
        String sql = "select * from usertable where u_username = ?";
        Object[] objects = qr.query(sql, new ArrayHandler(),username);
        String password = (String) objects[1];
        String email = (String) objects[2];
        String phone = (String) objects[3];
        String insert_time = objects[4].toString();
        String update_time = objects[5].toString();
        User user = new User(username,password,email,phone,insert_time,update_time);
        System.out.println(user);
        return user;
    }

    public static void main(String[] args) throws SQLException {
        new UserDaoImpl().show("lkk");
    }
}
