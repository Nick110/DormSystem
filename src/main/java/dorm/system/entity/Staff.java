package dorm.system.entity;

import java.util.HashSet;
import java.util.Set;

public class Staff {
	private String id;
	private String password;
	private String realName;
	private String tel;
	private Building buildId;
	private Set<Notice> notice=new HashSet<Notice>(0);
	public Set<Notice> getNotice() {
		return notice;
	}
	public void setNotice(Set<Notice> notice) {
		this.notice = notice;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Building getBuildId() {
		return buildId;
	}
	public void setBuildId(Building buildId) {
		this.buildId = buildId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

}
