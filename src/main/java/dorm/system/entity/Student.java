package dorm.system.entity;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private String id;
	private String password;
	private String realName;
	private String gender;
	private String grade;	
	private Dormitory dormId;
	private Major majorId;
	private Set<Leaveregist> leaveregist=new HashSet<Leaveregist>(0);
	private Set<Equipment> equipment=new HashSet<Equipment>(0);
	private Set<Maintenance> maintenance=new HashSet<Maintenance>(0); 	
	
	public Set<Leaveregist> getLeaveregist() {
		return leaveregist;
	}
	public void setLeaveregist(Set<Leaveregist> leaveregist) {
		this.leaveregist = leaveregist;
	}
	public Set<Equipment> getEquipment() {
		return equipment;
	}
	public void setEquipment(Set<Equipment> equipment) {
		this.equipment = equipment;
	}
	public Set<Maintenance> getMaintenance() {
		return maintenance;
	}
	public void setMaintenance(Set<Maintenance> maintenance) {
		this.maintenance = maintenance;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Major getMajorId() {
		return majorId;
	}
	public Dormitory getDormId() {
		return dormId;
	}
	public void setDormId(Dormitory dormId) {
		this.dormId = dormId;
	}
	public void setMajorId(Major majorId) {
		this.majorId = majorId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}


}
