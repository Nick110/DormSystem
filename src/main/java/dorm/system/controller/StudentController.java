package dorm.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dorm.system.entity.Student;
import dorm.system.service.StudentService;

@Controller
@RequestMapping("/user")
public class StudentController {
	
	@Autowired
	private StudentService stuService;
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@RequestMapping(value="/student")
	public ModelAndView addStu() {
		ModelAndView mv=new ModelAndView("stu");
		//Student student=stuService.getStu();
		//mv.addObject("student", student);
		logger.info("进入");
		return mv;
	}
}
