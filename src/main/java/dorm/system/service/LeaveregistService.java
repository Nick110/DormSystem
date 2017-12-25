package dorm.system.service;

import dorm.system.dto.LeaveregistDto;
import dorm.system.dto.StaffDto;

import java.util.List;

public interface LeaveregistService {
    public List<LeaveregistDto> showLeaveRegist(StaffDto staffDto, int page);
    public int pageNumber(String staffId);
}
