package dorm.system.service.impl;

import dorm.system.dao.BuildingDao;
import dorm.system.dao.DormitoryDao;
import dorm.system.dao.HygienegradesDao;
import dorm.system.dto.HygieneDormDto;
import dorm.system.dto.HygieneDto;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Building;
import dorm.system.entity.Dormitory;
import dorm.system.service.HygienegradesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HygienegradesServiceImpl implements HygienegradesService {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DormitoryDao dormitoryDao;
    @Autowired
    private BuildingDao buildingDao;
    @Autowired
    private HygienegradesDao hygienegradesDao;

    @Override
    public List<HygieneDormDto> showDorm(StaffDto staffDto, int floor) {
        String staffId = staffDto.getId();
        String floorStr = floor + "%";
        Building building = buildingDao.get("from Building b where b.staff = " +staffId);
        int buildId = building.getId();
        String hql = "from Dormitory d where d.buildId = " + buildId + " and d.roomNo like :floor";
        Map<String,Object> params=new HashMap<String,Object>();
//        params.put("buildId", String.valueOf(buildId));
        params.put("floor", floorStr);
        logger.info(String.valueOf(params.get("floor")));
        List<Dormitory> dormitoryList = dormitoryDao.find(hql,params);
        List<HygieneDormDto> hygieneDormDtoList = new ArrayList<HygieneDormDto>();
        if (dormitoryList == null || dormitoryList.size() == 0){
            return null;
        }
        for (Dormitory dormitory : dormitoryList) {
            HygieneDormDto hygieneDormDto = new HygieneDormDto();
            hygieneDormDto.setFloor(floor);
            hygieneDormDto.setRoomNo(dormitory.getRoomNo());
            hygieneDormDtoList.add(hygieneDormDto);
        }
        return hygieneDormDtoList;
    }
}
