package dorm.system;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dorm.system.entity.Student;
import dorm.system.service.StudentService;

public class SpringHibernate {
	@Test
	public void addStudent() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService stuService=(StudentService)context.getBean("studentServiceImpl");

		//Session session=sf.getCurrentSession();
		
		//stuService.getStu();
	}
}
