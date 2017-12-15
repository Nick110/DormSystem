package dorm.system.entity;

import java.util.HashSet;
import java.util.Set;

public class Building {
	private int id;
	private int buildingNo;
	private String aptName;
	private Staff staff;
	private Set<Dormitory> dormitory=new HashSet<Dormitory>(0);
	private Set<Visitrecord> visitrecord=new HashSet<Visitrecord>(0);
	
	
	public Set<Visitrecord> getVisitrecord() {
		return visitrecord;
	}

	public void setVisitrecord(Set<Visitrecord> visitrecord) {
		this.visitrecord = visitrecord;
	}

	public Set<Dormitory> getDormitory() {
		return dormitory;
	}
	
	public void setDormitory(Set<Dormitory> dormitory) {
		this.dormitory = dormitory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	

}
