package cn.tedu.store.mapper;

import cn.tedu.store.entity.User;

/**
 * 处理用户数据的持久层接口
 * @author yuyu
 *
 */
public interface UserMapper {
	/**
	 * 插入用户数据
	 * @param user 用户数据
	 * @return 受影响的行数
	 */
	Integer addNew(User user);
	
	/**
	 * 根据用户名查询用户数据
	 * @param username 用户名
	 * @return 匹配的用户数据，如果没有匹配的数据则返回null
	 */
	User findByUsername(String username);
}
