package dorm.system.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dorm.system.dao.StaffDao;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Staff;
import dorm.system.entity.Student;
import dorm.system.service.StaffService;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDao staffDao;
	public StaffDto login(StaffDto staff) {
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("id",staff.getId());
		params.put("pwd", staff.getPassword());
		String hql="from Staff s where s.id=:id and s.password=:pwd";
		Staff t=staffDao.get(hql,params);
		if(t!=null) {
			BeanUtils.copyProperties(t, staff);
			return staff;
		}
		return null;
	}

}
