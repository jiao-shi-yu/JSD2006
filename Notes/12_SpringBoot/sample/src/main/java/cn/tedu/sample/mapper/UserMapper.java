package cn.tedu.sample.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import cn.tedu.sample.User;


public interface UserMapper {
	// @Insert("INSERT INTO t_user (username, password, age, phone, email) VALUES (#{username}, #{password}, #{age}, #{phone}, #{email})")
	Integer addNew(User user);

	User findUserByName(String username);
}
