package dorm.system.service.impl;

import dorm.system.dao.BuildingDao;
import dorm.system.dao.LeaveregistDao;
import dorm.system.dto.LeaveregistDto;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Building;
import dorm.system.entity.Leaveregist;
import dorm.system.service.LeaveregistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LeaveregistServiceImpl implements LeaveregistService {
    @Autowired
    private LeaveregistDao leaveregistDao;
    @Autowired
    private BuildingDao buildingDao;
    Logger logger = LoggerFactory.getLogger(LeaveregistServiceImpl.class);

    @Override
    public List<LeaveregistDto> showLeaveRegist(StaffDto staffDto, int page) {
        String staffId = staffDto.getId();
        Building building = buildingDao.get("from Building b where b.staff = " +staffId);
        int buildId = building.getId();
        String hql = "from Leaveregist l where l.buildId = " + buildId;
        List<Leaveregist> leaveregistList = leaveregistDao.find(hql, page, 7);
        List<LeaveregistDto> leaveregistDtoList = new ArrayList<LeaveregistDto>();
        if (leaveregistList == null || leaveregistList.size() == 0) {
            logger.info(String.valueOf(buildId));
            return null;
        }
        for (Leaveregist leaveregist : leaveregistList) {
            LeaveregistDto leaveregistDto = new LeaveregistDto();
            BeanUtils.copyProperties(leaveregist, leaveregistDto);
            leaveregistDto.setBuildId(leaveregist.getBuildId().getId());
            leaveregistDto.setStuId(leaveregist.getStuId().getId());
            leaveregistDto.setRoomNo(leaveregist.getStuId().getDormId().getRoomNo());
            leaveregistDto.setStaffId(leaveregist.getBuildId().getStaff().getId());

            //日期格式转换
            String lt;
            String rt;
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH时");
            lt = sdf.format(leaveregist.getLeavetime());
            leaveregistDto.setLeavetime(lt);
            if (leaveregist.getReturntime() != null){
                rt = sdf.format(leaveregist.getReturntime());
                leaveregistDto.setReturntime(rt);
            }
            leaveregistDtoList.add(leaveregistDto);
        }
        return leaveregistDtoList;
    }

    @Override
    public int pageNumber(String staffId) {
        Building building = buildingDao.get("from Building b where b.staff = " + staffId);
        int buildId = building.getId();
        String hql = "from Leaveregist l where l.buildId = " + buildId;
        List<Leaveregist> leaveregistList = leaveregistDao.find(hql);
        Double a = Double.valueOf(leaveregistList.size());
        Double pageNumberD = (a / 7);
        int pageNumber = (int) Math.ceil(pageNumberD);
        /*logger.info(String.valueOf(pageNumberD));
        logger.info(String.valueOf(pageNumber));*/
        return pageNumber;
    }
}
