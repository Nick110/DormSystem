package dorm.system.service.impl;

import dorm.system.dao.NoticeDao;
import dorm.system.dao.StaffDao;
import dorm.system.dto.NoticeDto;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Notice;
import dorm.system.entity.Staff;
import dorm.system.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.*;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

    Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private StaffDao staffDao;
    //添加公告
    @Override
    public void addNotice(NoticeDto noticeDto) {
        Date date = new Date();
        Notice notice = new Notice();
        Staff staff = staffDao.get(Staff.class, noticeDto.getStaffId());
        //将noticeDto的值赋给notice
        BeanUtils.copyProperties(noticeDto, notice);
        notice.setStaffId(staff);
        notice.setTime(new Timestamp(date.getTime()));
        noticeDao.save(notice);
    }

    @Override
    public List<NoticeDto> showNotice(StaffDto staffDto) {
//        logger.info(staffDto.getId());
//        System.out.println(staffDto.getRealName());
        String hql = "from Notice n where n.staffId = " + staffDto.getId();
        List<Notice> noticeList = noticeDao.find(hql);
        List<NoticeDto> noticeDtoList = new ArrayList<NoticeDto>();
        if (noticeList == null || noticeList.size() == 0) {
            return null;
        }
        for (Notice notice : noticeList) {
            NoticeDto nd = new NoticeDto();
            BeanUtils.copyProperties(notice, nd);
            noticeDtoList.add(nd);
        }
        return noticeDtoList;
    }

    @Override
    public StaffDto selectStaff(String id) {
        Staff staff = staffDao.get(Staff.class, id);
        StaffDto staffDto = new StaffDto();
        BeanUtils.copyProperties(staff, staffDto);
        return staffDto;
    }


}

