package cn.tedu.spring;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserJdbcDao implements UserDao {
    public void login() {
        System.out.println("\tUserJdbcDao.login()");
    }
}