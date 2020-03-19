package cn.tedu.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	
	Integer addnew(User user);
	
	Integer deleteById(Integer id);
	
	Integer deleteByIds(Integer... ids);
	
	Integer updatePassword(String password);
	
	Integer updateEmailById(
			@Param("email") String email, 
			@Param("id") Integer id
	);
	
	
	Integer count();
	
	User findUserById(Integer id);
	
	User findUserByName(String username);
	
	User findUserByNameAndPassword(
			@Param("username") String username,
			@Param("password") String password
	);
	
	
	List<User> findAllUsers();
	
	User findUserOfMaxAge();
	
	List<User> find(
			@Param("where") String where,
			@Param("orderBy") String orderBy,
			@Param("offset") Integer offset,
			@Param("count") Integer count
	);
	
	List<User> findAll();
	
	UserVO findUserVOById(Integer id);
}
