package dorm.system.controller;

import dorm.system.dto.MaintenanceDto;
import dorm.system.dto.NoticeDto;
import dorm.system.dto.RewardsDto;
import dorm.system.dto.StaffDto;
import dorm.system.service.MaintenanceService;
import dorm.system.service.NoticeService;
import dorm.system.service.RewardsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StaffController {
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private MaintenanceService maintenanceService;
    @Autowired
    private RewardsService rewardsService;

    @Autowired
    HttpSession httpSession;

    @RequestMapping("/staffHome")
    public ModelAndView staffHome() {
        Logger logger = LoggerFactory.getLogger(StaffController.class);
        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        ModelAndView mav = new ModelAndView("dorm-admin");
//        String staffDtoId = staffDto.getId();
//        logger.info(staffDtoId);
//        StaffDto staffDto = noticeService.selectStaff(staffDtoId);
//        logger.info(staffDto.getRealName());
        List<NoticeDto> noticeDtoHistory = noticeService.showNotice(staffDto);
//        logger.info(Integer.toString(noticeDtoHistory.size()));
        mav.addObject("staffDto", staffDto);
        mav.addObject("noticeDtoHistory", noticeDtoHistory);


        //显示报修表
        List<MaintenanceDto> maintenanceDtoList = maintenanceService.showMaintenance(staffDto);
//        logger.info(String.valueOf(maintenanceDtoList.get(1).getDormId()));
        mav.addObject("maintenanceDtoHistory", maintenanceDtoList);


        //显示奖惩表
        List<RewardsDto> rewardsDtoList = rewardsService.showRewards(staffDto);
        System.out.println(rewardsDtoList.size());
        mav.addObject("rewardsList", rewardsDtoList);





        return mav;
    }
}
