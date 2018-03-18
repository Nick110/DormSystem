package dorm.system.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Leaveregist {
	private int id;
	private Timestamp leavetime;
	private String destination;
	private Timestamp returntime;
	private String tel;
	private Student stuId;
	private int state;
	private Building buildId;

	public Building getBuildId() {
		return buildId;
	}

	public void setBuildId(Building buildId) {
		this.buildId = buildId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getLeavetime() {
		return leavetime;
	}
	public void setLeavetime(Timestamp leavetime) {
		this.leavetime = leavetime;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Timestamp getReturntime() {
		return returntime;
	}
	public void setReturntime(Timestamp returntime) {
		this.returntime = returntime;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	

	public Student getStuId() {
		return stuId;
	}
	public void setStuId(Student stuId) {
		this.stuId = stuId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

}
