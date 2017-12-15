package dorm.system.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dorm.system.dao.AdministratorDao;
import dorm.system.dto.AdministratorDto;
import dorm.system.entity.Administrator;
import dorm.system.service.AdministratorService;

@Service
@Transactional
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	private AdministratorDao administratorDao;
	
	public AdministratorDto login(AdministratorDto admin) {
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("id", admin.getId());
		params.put("pwd", admin.getPassword());
		String hql="from Administrator a where a.id=:id and a.password=:pwd";
		Administrator t=administratorDao.get(hql, params);
		if(t!=null) {
			BeanUtils.copyProperties(t, admin);
			return admin;
		}
		return null;
	}
	

}
