package cn.tedu.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.UserService;
/**
 * 处理用户数据的业务层实现类
 * @author yuyu
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserMapper userMapper;
	@Override
	public void reg(User user) {
		// 从参数对象中取出用户名username
		String username = user.getUsername();
		// 调用持久层findByUsername方法，查询用户数据
		User userFromDB = userMapper.findByUsername(username);
		// 判断是否已经存在
		if (userFromDB != null) {// 如果已经存在，则注册失败
			System.err.println("用户已经存了哦");
		} else { // 如果不存在，添加即可
			userMapper.addNew(user);
			System.err.println("添加完成~");
		}
			
			
		
	}



}
