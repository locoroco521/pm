package cn.csxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.csxy.bean.User;
import cn.csxy.dao.UserDao;
import cn.csxy.service.UserService;

/**
 * 用户Service层接口实现类
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

//	注入UserDao
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findUser(String usercode, String password) {
		User user= this.userDao.findUser(usercode, password);
		return user;
	}

}
