package dorm.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dorm.system.dto.AdministratorDto;
import dorm.system.dto.StaffDto;
import dorm.system.dto.StudentDto;
import dorm.system.service.AdministratorService;
import dorm.system.service.StaffService;
import dorm.system.service.StudentService;

@Controller
public class HomeController {
	Logger logger=LoggerFactory.getLogger(AdminController.class);
	@Autowired
	AdministratorService administratorService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StaffService staffService;
	
	/**
	 * 进入登录页面
	 * @return
	 */
	@RequestMapping(value="/admin/login",method=RequestMethod.GET)
	public String getLogin(){
		logger.info("进入");
		return "login";
	}
	/**
	 * 
	 * 管理员登录
	 * 
	 */	
	@RequestMapping(value="/admin/login",method=RequestMethod.POST)
	public String loginAdmin(AdministratorDto admin,HttpSession httpSession,HttpServletRequest request) {
		logger.info("管理员"+admin.getId()+"密码"+admin.getPassword());
		AdministratorDto a=administratorService.login(admin);
		if(a!=null) {
			httpSession.setAttribute("name",a.getRealName());	
			return "adminHome";
		}else {
			request.setAttribute("state", "failed");
			return "login";
		}
	}
	
	/**
	 * 
	 * 学生登录
	 * 
	 */	
	@RequestMapping(value="/stu/login",method=RequestMethod.POST)
	public String loginStu(StudentDto stu,HttpSession httpSession,HttpServletRequest request) {
		logger.info("学生"+stu.getId()+"密码"+stu.getPassword());
		StudentDto s=studentService.login(stu);
		if(s!=null) {
			httpSession.setAttribute("name", s.getRealName());	
			return "userHome";
		}else {
			request.setAttribute("state", "failed");
			return "login";
		}
	
	}
	
	
	/**
	 * 
	 * 员工登录
	 * 
	 */	
	@RequestMapping(value="/staff/login",method=RequestMethod.POST)
	public String loginStaff(StaffDto staff,HttpSession httpSession,HttpServletRequest request) {
		logger.info("员工"+staff.getId()+"密码"+staff.getPassword());
		StaffDto s=staffService.login(staff);
		if(s!=null) {
			httpSession.setAttribute("name", s.getRealName());	
			return "userHome";
		}else {
			request.setAttribute("state", "failed");
			return "login";
		}
	
	}	
	
	
}
