package cn.csxy.service;

import cn.csxy.bean.User;

/**
 * �û�Service��ӿ�
 */
public interface UserService {
	// ͨ���˺ź������ѯ�û�
	public User findUser(String usercode, String password);
}
