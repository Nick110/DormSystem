package dorm.system.service.impl;

import dorm.system.dao.DormitoryDao;
import dorm.system.dao.MaintenanceDao;
import dorm.system.dto.MaintenanceDto;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Maintenance;
import dorm.system.service.MaintenanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MaintenanceServiceImpl implements MaintenanceService {
    Logger logger = LoggerFactory.getLogger(MaintenanceServiceImpl.class);
    @Autowired
    private MaintenanceDao maintenanceDao;

    @Autowired
    private DormitoryDao dormitoryDao;

    //查看报修表
    @Override
    public List<MaintenanceDto> showMaintenance(StaffDto staffDto) {
        String staffId = staffDto.getId();
        logger.info(staffId);
        String hql = "from Maintenance m where m.staffId = " + staffId;
        List<Maintenance> maintenanceList = maintenanceDao.find(hql);
//        logger.info(String.valueOf(maintenanceList.get(1).getStuId().getId()));
//        logger.info(String.valueOf(maintenanceList.get(1).getDormId().getId()));
        List<MaintenanceDto> maintenanceDtoList = new ArrayList<MaintenanceDto>();
        if (maintenanceList == null || maintenanceList.size() == 0) {
            return null;
        }
        for (Maintenance maintenance : maintenanceList) {
            MaintenanceDto md = new MaintenanceDto();
            BeanUtils.copyProperties(maintenance, md);
//            logger.info(String.valueOf(md.getDormId()));
            md.setDormName(maintenance.getDormId().getRoomNo());
            md.setStaffId(maintenance.getStaffId().getId());
            md.setStuId(maintenance.getStuId().getId());
            maintenanceDtoList.add(md);
        }
        return maintenanceDtoList;
    }

    //标记修复
    public void doRepair (int id) {
        Maintenance maintenance = maintenanceDao.get(Maintenance.class, id);
        maintenance.setState("已修复");
        maintenanceDao.update(maintenance);
    }

}