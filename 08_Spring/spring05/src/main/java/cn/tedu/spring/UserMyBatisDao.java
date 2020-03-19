package cn.tedu.spring;

import org.springframework.stereotype.Repository;

@Repository
public class UserMyBatisDao implements UserDao {
    public void login() {
        System.out.println("\tUserMyBatis.login()");
    }
}