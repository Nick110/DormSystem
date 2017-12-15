package dorm.system.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dorm.system.dao.StudentDao;
import dorm.system.dao.impl.StudentDaoImpl;
import dorm.system.dto.StudentDto;
import dorm.system.entity.Administrator;
import dorm.system.entity.Student;
import dorm.system.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	private StudentDao studentDao;

	public Student getStu() {
		return studentDao.get(Student.class,1150299035);
	}
	
	public void addStu(Student stu) {
		studentDao.save(stu);
	}

	public StudentDto login(StudentDto stu) {
		// TODO Auto-generated method stub
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("id", stu.getId());
		params.put("pwd", stu.getPassword());
		String hql="from Student s where s.id=:id and s.password=:pwd";
		Student t=studentDao.get(hql, params);
		if(t!=null) {
			BeanUtils.copyProperties(t, stu);
			return stu;
		}
		return null;
	}
}
