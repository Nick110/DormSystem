package dorm.system.entity;

import java.sql.Timestamp;

public class Visitrecord {
	private int id;
	private String personName;
	private Timestamp visitTime;
	private Timestamp leaveTime;
	private String idCardNo;
	private Building buildId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Timestamp getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Timestamp visitTime) {
		this.visitTime = visitTime;
	}
	public Timestamp getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Timestamp leaveTime) {
		this.leaveTime = leaveTime;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public Building getBuildId() {
		return buildId;
	}
	public void setBuildId(Building buildId) {
		this.buildId = buildId;
	}

	

	

}
