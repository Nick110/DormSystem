package dorm.system.service;

import dorm.system.dao.RewardsDao;
import dorm.system.dto.RewardsDto;
import dorm.system.dto.StaffDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface RewardsService {
    public List<RewardsDto> showRewards (StaffDto staffDto);
    public String addRewards (RewardsDto rewardsDto);
    public List<RewardsDto> selectRewards (int dormId, String staffId);

}
