package dorm.system.entity;

import java.util.HashSet;
import java.util.Set;

public class Major {
	private int id;
	private String department;
	private String major;
	private Set<Student> student=new HashSet<Student>();
	
	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}
