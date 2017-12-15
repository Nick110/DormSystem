package dorm.system.service;

import dorm.system.dto.AdministratorDto;
import dorm.system.dto.StudentDto;
import dorm.system.entity.Student;

public interface StudentService {
	public StudentDto login(StudentDto stu);
	public void addStu(Student stu);
	
}
