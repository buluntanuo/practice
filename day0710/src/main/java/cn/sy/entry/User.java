package cn.sy.entry;

/**
 * @ClassName: User
 * @Descriptin: TODO
 * @author: lkk
 * @Date: 2020/7/10 16:40
 * @Version: 1.0
 **/
public class User {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String insert_time;
    private String update_time;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public User(String username, String password, String email, String phone, String insert_time, String update_time) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.insert_time = insert_time;
        this.update_time = update_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInsert_time() {
        return insert_time;
    }

    public void setInsert_time(String insert_time) {
        this.insert_time = insert_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", insert_time='" + insert_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
