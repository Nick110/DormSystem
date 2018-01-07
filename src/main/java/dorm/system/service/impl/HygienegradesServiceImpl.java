package dorm.system.service.impl;

import dorm.system.dao.BuildingDao;
import dorm.system.dao.DormitoryDao;
import dorm.system.dao.HygienegradesDao;
import dorm.system.dto.HygieneDormDto;
import dorm.system.dto.HygieneDto;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Building;
import dorm.system.entity.Dormitory;
import dorm.system.entity.Hygienegrades;
import dorm.system.service.HygienegradesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

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
        Building building = buildingDao.get("from Building b where b.staff = " + staffId);
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


    //登记寝室卫生成绩
    @Override
    public void addHygieneRemarks(List<HygieneDto> hygieneDtoList) {
        for (HygieneDto hd : hygieneDtoList) {
            Dormitory dormitory = dormitoryDao.get("from Dormitory d where d.roomNo = " + hd.getRoomNo());
            Building building = buildingDao.get("from Building b where b.staff = " + hd.getStaffId());
            Hygienegrades hygienegrades = new Hygienegrades();
            BeanUtils.copyProperties(hd, hygienegrades);
            hygienegrades.setDormId(dormitory);
            hygienegrades.setBuildId(building);
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
            SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
            Date date = new Date();
            String nowYear = sdf1.format(date);
            String nowMonth = sdf2.format(date);
            hygienegrades.setDate(new Timestamp (date.getTime()));
//            logger.info("现在是：" + nowYear + nowMonth);
            String hql = "FROM Hygienegrades WHERE MONTH(date) = " + nowMonth +
                    " AND YEAR(date) = " + nowYear + " AND dormId = " + dormitory.getId() ;
            Hygienegrades hygienegrades1 = (Hygienegrades) hygienegradesDao.get(hql);
            if (hygienegrades1 != null) {
                String sql = "UPDATE hygienegrades SET remarks = " + hd.getRemarks() + " WHERE dormId = "
                        + dormitory.getId();
                hygienegradesDao.executeSql(sql);
            }
            else {
                hygienegradesDao.save(hygienegrades);
            }
        }
    }

    @Override
    public List<HygieneDto> seeHygiene(StaffDto staffDto) {
        String staffId = staffDto.getId();
        Building building = buildingDao.get("from Building b where b.staff = " + staffId);
        int buildId = building.getId();
        String hql = "from Hygienegrades h where h.buildId = " + buildId;
        List<Hygienegrades> hygienegradesList = hygienegradesDao.find(hql);
        List<HygieneDto> hygieneDtoList = new ArrayList<HygieneDto>();

        if (hygienegradesList == null || hygienegradesList.size() == 0){
            return null;
        }
        for (Hygienegrades hygienegrades : hygienegradesList) {
            HygieneDto hygieneDto = new HygieneDto();
            BeanUtils.copyProperties(hygienegrades, hygieneDto);
            hygieneDto.setStaffId(staffId);
            hygieneDto.setRoomNo(hygienegrades.getDormId().getRoomNo());

            Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));  //获取东八区时间
            int year = c.get(Calendar.YEAR);    //获取年
            int month = c.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
            String yearAndMonth = year + "年" + month + "月";
            hygieneDto.setYearAndMonth(yearAndMonth);
            hygieneDtoList.add(hygieneDto);
        }
        return hygieneDtoList;
    }


    //查询公寓号
    @Override
    public String selectAptName(StaffDto staffDto) {
        Building building = buildingDao.get("from Building b where b.staff = " + staffDto.getId());
        return building.getAptName();
    }


}
