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
//测试dao层的工作
import cn.csxy.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration指定Spring配置文件的位置
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
//	直接Autowired要使用的组件
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession sqlSession;
	
//	测试DepartmentMapper
	@Test
	public void testCRUD() {
		System.out.println(departmentMapper);
//		插入几个部门
//		departmentMapper.insertSelective(new Department(null, "开发部"));
//		departmentMapper.insertSelective(new Department(null, "测试部"));
//		生成员工数据 测试员工插入
//		employeeMapper.insertSelective(new Employee(null,"lzl","M","lzl@csxy.com",1));
//		批量插入多个员工 使用可以执行批量操作的sqlSession
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++) {
			String uid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@csxy.com",1));
		}
		System.out.println("批量完成");
	}
}


