package dorm.system.entity;

import java.sql.Timestamp;

public class Equipment {
	private int id;
	private String thingsName;
	private Timestamp borrowTime;
	private Timestamp returnTime;
	private Student stuId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getThingsName() {
		return thingsName;
	}
	public void setThingsName(String thingsName) {
		this.thingsName = thingsName;
	}
	public Timestamp getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(Timestamp borrowTime) {
		this.borrowTime = borrowTime;
	}
	public Timestamp getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Timestamp returnTime) {
		this.returnTime = returnTime;
	}
	public Student getStuId() {
		return stuId;
	}
	public void setStuId(Student stuId) {
		this.stuId = stuId;
	}


}
