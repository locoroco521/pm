package cn.csxy.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.csxy.bean.Department;
import cn.csxy.bean.Employee;
import cn.csxy.bean.EmployeeExample;
import cn.csxy.dao.DepartmentMapper;
//����dao��Ĺ���
import cn.csxy.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfigurationָ��Spring�����ļ���λ��
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
//	ֱ��AutowiredҪʹ�õ����
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession sqlSession;
	
//	����DepartmentMapper
	@Test
	public void testCRUD() {
		System.out.println(departmentMapper);
//		���뼸������
//		departmentMapper.insertSelective(new Department(null, "������"));
//		departmentMapper.insertSelective(new Department(null, "���Բ�"));
//		����Ա������ ����Ա������
//		employeeMapper.insertSelective(new Employee(null,"lzl","M","lzl@csxy.com",1));
//		����������Ա�� ʹ�ÿ���ִ������������sqlSession
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++) {
			String uid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@csxy.com",1));
		}
		System.out.println("�������");
	}
}


