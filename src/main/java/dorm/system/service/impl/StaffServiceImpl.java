package dorm.system.service.impl;

import java.util.HashMap;
import java.util.Map;

import dorm.system.dto.UpdatePasswordDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dorm.system.dao.StaffDao;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Staff;
import dorm.system.entity.Student;
import dorm.system.service.StaffService;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDao staffDao;
	@Autowired
	HttpSession httpSession;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	public StaffDto login(StaffDto staff) {
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("id",staff.getId());
		params.put("pwd", staff.getPassword());
		String hql="from Staff s where s.id=:id and s.password=:pwd";
		Staff t = staffDao.get(hql,params);
		if(t!=null) {
			BeanUtils.copyProperties(t, staff);
			return staff;
		}
		return null;
	}

	public String updatePassword(UpdatePasswordDto updatePasswordDto) {
		String previousPassword = updatePasswordDto.getPreviousPassword();
		String newPassword = updatePasswordDto.getNewPassword();
		StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
		Staff staff = staffDao.get(Staff.class, staffDto.getId());
//		logger.info(previousPassword);
		String password = staff.getPassword();
		logger.info(String.valueOf(password.equals(previousPassword)));
		if (!password.equals(previousPassword)) {
			return "原密码填写错误！";
		}
		staff.setPassword(newPassword);
		return "修改成功！";
	}

}
