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
public class NoticeController {
    Logger logger = LoggerFactory.getLogger(NoticeController.class);
    @Autowired
    private NoticeService noticeService;

    @Autowired
    HttpSession httpSession;

    @PostMapping("staffHome/doAddNotice")
    public ModelAndView addNotice(NoticeDto noticeDto) {
        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        logger.info(staffDto.getRealName());
        noticeService.addNotice(noticeDto);
        return new ModelAndView("redirect:/staffHome");
    }
}
