package dorm.system.entity;

import java.sql.Timestamp;

public class Hygienegrades {
	private int id;
	private Timestamp date;
	private int grade;
	private String remarks;
	private Dormitory dormId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Dormitory getDormId() {
		return dormId;
	}
	public void setDormId(Dormitory dormId) {
		this.dormId = dormId;
	}
	
	

}
