package dorm.system.entity;

import java.sql.Timestamp;

public class Maintenance {
	private int id;
	private Timestamp time;
	private Student stuId;
	private String decribtion;
	private Dormitory dormId;
	private String state;
	private String position;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getTime() {
		return time;
	}

	public Student getStuId() {
		return stuId;
	}
	public void setStuId(Student stuId) {
		this.stuId = stuId;
	}
	public String getDecribtion() {
		return decribtion;
	}
	public void setDecribtion(String decribtion) {
		this.decribtion = decribtion;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}


	public Dormitory getDormId() {
		return dormId;
	}
	public void setDormId(Dormitory dormId) {
		this.dormId = dormId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

}
