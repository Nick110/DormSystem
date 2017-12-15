package dorm.system.controller;

import dorm.system.dto.NoticeDto;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Notice;
import dorm.system.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class NoticeController {
    Logger logger = LoggerFactory.getLogger(NoticeController.class);
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/staffHome")
    public ModelAndView staffHome() {
        ModelAndView mav = new ModelAndView("notice-test");
        StaffDto staffDto = noticeService.selectStaff("1");
        System.out.println(staffDto.getRealName());
        logger.info(staffDto.getRealName());
        List<NoticeDto> noticeDtoHistory = noticeService.showNotice(staffDto);
        logger.info(Integer.toString(noticeDtoHistory.size()));
        mav.addObject("noticeDtoHistory", noticeDtoHistory);
        return mav;
    }

//    @RequestMapping("/doAddNotice")
//    public ModelAndView addNotice(NoticeDto noticeDto) {
//        noticeService.addNotice(noticeDto);
//        return new ModelAndView("redirect:/dorm-admin");
//    }
}
