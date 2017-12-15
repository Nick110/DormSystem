package dorm.system.entity;

import java.util.HashSet;
import java.util.Set;

public class Dormitory {
	private int id;
	private int pNum;
	private int capacity;
	private String roomNo;
	private Building buildId;
	private Student leaderId;
	private Set<Student> student=new HashSet<Student>(0);	
	private Set<Maintenance> maintenance=new HashSet<Maintenance>(0);
	private Set<Hygienegrades> hygienegrades=new HashSet<Hygienegrades>(0);

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
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public Building getBuildId() {
		return buildId;
	}
	public void setBuildId(Building buildId) {
		this.buildId = buildId;
	}
	public Set<Maintenance> getMaintenance() {
		return maintenance;
	}
	public void setMaintenance(Set<Maintenance> maintenance) {
		this.maintenance = maintenance;
	}
	public Student getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(Student leaderId) {
		this.leaderId = leaderId;
	}
	public Set<Hygienegrades> getHygienegrades() {
		return hygienegrades;
	}
	public void setHygienegrades(Set<Hygienegrades> hygienegrades) {
		this.hygienegrades = hygienegrades;
	}
	


	

	
}
