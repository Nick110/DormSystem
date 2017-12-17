package dorm.system.controller;

import dorm.system.dto.NoticeDto;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Notice;
import dorm.system.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping
public class NoticeController {
    Logger logger = LoggerFactory.getLogger(NoticeController.class);
    @Autowired
    private NoticeService noticeService;

//    HttpSession httpSession;
//    StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");

    @RequestMapping("/staffHome")
    public ModelAndView staffHome(HttpSession httpSession) {
        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        ModelAndView mav = new ModelAndView("dorm-admin");
        String staffDtoId = staffDto.getId();
        logger.info(staffDtoId);
//        StaffDto staffDto = noticeService.selectStaff(staffDtoId);
//        logger.info(staffDto.getRealName());
        List<NoticeDto> noticeDtoHistory = noticeService.showNotice(staffDto);
        logger.info(Integer.toString(noticeDtoHistory.size()));
        mav.addObject("staffDto", staffDto);
        mav.addObject("noticeDtoHistory", noticeDtoHistory);
        return mav;
    }

    @PostMapping("staffHome/doAddNotice")
    public ModelAndView addNotice(NoticeDto noticeDto, HttpSession httpSession) {
        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        logger.info(staffDto.getRealName());
        noticeService.addNotice(noticeDto);
        return new ModelAndView("redirect:/dorm-admin");
    }
}
