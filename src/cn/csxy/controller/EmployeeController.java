package cn.csxy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.csxy.bean.Employee;
import cn.csxy.bean.Msg;
import cn.csxy.service.EmployeeService;

//����Ա��CRUD����
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	//Ա��ɾ������
	@ResponseBody
	@RequestMapping(value = "/emp/{ids}",method = RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids) {
		if(ids.contains("-")) {
			List<Integer> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			//��װid�ļ���
			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			employeeService.deleteBatch(del_ids);
		}else {
			Integer id = Integer.parseInt(ids);
			employeeService.deleteEmp(id);
		}
		return Msg.success();
	}

//	Ա�����·���
	@ResponseBody
	@RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
	public Msg saveEmp(Employee employee, HttpServletRequest request) {
		employeeService.updateEmp(employee);
		return Msg.success();
	}

//	����id��ѯԱ��
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id") Integer id) {
		Employee employee = employeeService.getEmp(id);
		return Msg.success().add("emp", employee);
	}

//	���Ա�����Ƿ����	
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkuser(@RequestParam("empName") String empName) {
//		���ж�Ա�����Ƿ��ǺϷ��ı��ʽ
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if (!empName.matches(regx)) {
			return Msg.fail().add("va_msg", "��������д2-5λ���Ļ�6-16λӢ�ĺ����ֵ���ϣ�");
		}
//		���ݿ�Ա�����ظ�У��
		boolean b = employeeService.checkUser(empName);
		if (b) {
			return Msg.success();
		} else {
			return Msg.fail().add("va_msg", "����������");
		}
	}

//	Ա������
//	֧��JSR303У��
//	����Hibernate-Validator
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid Employee employee, BindingResult result) {
		if (result.hasErrors()) {
//			У��ʧ�� ����ʧ�� ��ģ̬������ʾУ��ʧ�ܵĴ�����Ϣ
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("������ֶ�����" + fieldError.getField());
				System.out.println("������Ϣ��" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		} else {
			employeeService.saveEmp(employee);
			return Msg.success();
		}
	}

	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
//		����PageHelper��ҳ���
//		�ڲ�ѯ֮ǰֻ��Ҫ����PageHelper ����ҳ���Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 10);
//		startPage��������������ѯ����һ����ҳ��ѯ
		List<Employee> emps = employeeService.getAll();
//		ʹ��PageInfo��װ��ѯ��Ľ�� ֻ��Ҫ��PageInfo����ҳ�漴��
//		��װ����ϸ�ķ�ҳ��Ϣ ���������ǲ�ѯ���������� ����������ʾ��ҳ��
		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("pageInfo", page);
	}

//	��ѯԱ�����ݣ���ҳ��ѯ��
//	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
//		����PageHelper��ҳ���
//		�ڲ�ѯ֮ǰֻ��Ҫ����PageHelper ����ҳ���Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 10);
//		startPage��������������ѯ����һ����ҳ��ѯ
		List<Employee> emps = employeeService.getAll();
//		ʹ��PageInfo��װ��ѯ��Ľ�� ֻ��Ҫ��PageInfo����ҳ�漴��
//		��װ����ϸ�ķ�ҳ��Ϣ ���������ǲ�ѯ���������� ����������ʾ��ҳ��
		PageInfo page = new PageInfo(emps, 5);
		model.addAttribute("pageInfo", page);
		return "list";
	}
}
