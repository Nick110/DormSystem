package dorm.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dorm.system.dto.AdministratorDto;
import dorm.system.dto.Json;
import dorm.system.dto.SessionInfo;
import dorm.system.service.AdministratorService;

@Controller
public class AdminController {
	Logger logger=LoggerFactory.getLogger(AdminController.class);
	@Autowired
	AdministratorService administratorService;
	
	
}
