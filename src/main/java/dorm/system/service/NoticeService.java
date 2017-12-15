package dorm.system.service;

import dorm.system.dto.NoticeDto;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Notice;
import dorm.system.entity.Staff;

import java.util.List;

public interface NoticeService {
    public void addNotice(NoticeDto noticeDto);
    public List<NoticeDto> showNotice(StaffDto staffDto);
    public StaffDto selectStaff(String id);
}
