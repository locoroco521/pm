package cn.csxy.dao;

import org.apache.ibatis.annotations.Param;
import cn.csxy.bean.User;

/**
 * �û�Dao��ӿ�
 */
public interface UserDao {
	/**
	 * ͨ���˺ź������ѯ�û�
	 */
	public User findUser(@Param("usercode") String usercode, @Param("password") String password);
}
