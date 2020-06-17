package cn.csxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.csxy.bean.Department;
import cn.csxy.bean.Msg;
import cn.csxy.service.DepartmentService;

//处理部门请求
@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

//	返回所有的部门信息
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts() {
//		查出的所有部门信息
		List<Department> list = departmentService.getDepts();
		return Msg.success().add("depts", list);
	}
}
