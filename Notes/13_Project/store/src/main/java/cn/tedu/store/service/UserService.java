package cn.tedu.store.service;

import cn.tedu.store.entity.User;

/**
 * 处理用户数据的业务层接口
 * @author yuyu
 *
 */
public interface UserService {
	/**
	 * 用户注册
	 * @param user 欲注册的用户信息
	 */
	void reg(User user);
}
