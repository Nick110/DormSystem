package dorm.system.entity;

import java.sql.Timestamp;

public class Maintenance {
	private int id;
	private Timestamp time;
	private Student stuId;
	private String description;
	private Dormitory dormId;
	private Staff staffId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

}
