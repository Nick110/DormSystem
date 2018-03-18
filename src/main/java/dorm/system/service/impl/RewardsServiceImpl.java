package dorm.system.service.impl;

import com.mchange.v2.beans.BeansUtils;
import dorm.system.dao.DormitoryDao;
import dorm.system.dao.RewardsDao;
import dorm.system.dao.StaffDao;
import dorm.system.dto.RewardsDto;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Dormitory;
import dorm.system.entity.Rewards;
import dorm.system.entity.Staff;
import dorm.system.service.RewardsService;
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
public class RewardsServiceImpl implements RewardsService {
    @Autowired
    private RewardsDao rewardsDao;
    @Autowired
    private DormitoryDao dormitoryDao;
    @Autowired
    private StaffDao staffDao;

    Logger logger = LoggerFactory.getLogger(RewardsServiceImpl.class);

    @Override
    public List<RewardsDto> showRewards(StaffDto staffDto) {
        String staffId = staffDto.getId();
        String hql = "from Rewards r where r.staffId = " + staffId;
        List<Rewards> rewardsList = rewardsDao.find(hql);
        List<RewardsDto> rewardsDtoList = new ArrayList<RewardsDto>();
        if (rewardsList == null || rewardsList.size() == 0) {
            return null;
        }
        for (Rewards rewards : rewardsList) {
            RewardsDto rd = new RewardsDto();
            BeanUtils.copyProperties(rewards, rd);
            rd.setDormId(rewards.getDormId().getId());
            rd.setStaffId(rewards.getStaffId().getId());
            rd.setRoomNo(rewards.getDormId().getRoomNo());
//            logger.info(String.valueOf(rd.getDormId()));
            rewardsDtoList.add(rd);
        }
        return rewardsDtoList;
    }

    @Override
    public String addRewards(RewardsDto rewardsDto) {
        Rewards rewards = new Rewards();
//        logger.info(String.valueOf(rewardsDto.getRoomNo()));
        BeanUtils.copyProperties(rewardsDto, rewards);
        Staff staff = staffDao.get(Staff.class, rewardsDto.getStaffId());
        Dormitory dormitory = dormitoryDao.get("from Dormitory d where d.roomNo = " + rewardsDto.getRoomNo());
        if (dormitory == null) {
            return "该寝室不存在！";
        }
        rewards.setStaffId(staff);
        rewards.setDormId(dormitory);
        rewardsDao.save(rewards);
        return "添加成功！";
    }

    @Override
    public List<RewardsDto> selectRewards(int roomNo, String staffId) {
        Dormitory dormitory = dormitoryDao.get("from Dormitory d where d.roomNo = " + roomNo);
        if (dormitory == null) {
            return null;
        }
        int dormId = dormitory.getId();
        String hql = "from Rewards r where r.staffId = " + staffId + "and r.dormId = " + dormId;
        List<Rewards> rewardsList = rewardsDao.find(hql);
        List<RewardsDto> rewardsDtoList = new ArrayList<RewardsDto>();
        if (rewardsList == null || rewardsList.size() == 0) {
            return null;
        }
        for (Rewards rewards : rewardsList) {
            RewardsDto rd = new RewardsDto();
            BeanUtils.copyProperties(rewards, rd);
            rd.setDormId(rewards.getDormId().getId());
            rd.setStaffId(rewards.getStaffId().getId());
            rd.setRoomNo(rewards.getDormId().getRoomNo());
            logger.info(String.valueOf(rd.getDormId()));
            rewardsDtoList.add(rd);
        }
        return rewardsDtoList;
    }


}
