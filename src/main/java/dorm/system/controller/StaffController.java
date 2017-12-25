package dorm.system.controller;

import dorm.system.dto.*;
import dorm.system.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    private EquipmentService equipmentService;
    @Autowired
    private LeaveregistService leaveregistService;

    @Autowired
    HttpSession httpSession;

    @RequestMapping("/staffHome")
    public ModelAndView staffHome() {
        Logger logger = LoggerFactory.getLogger(StaffController.class);
        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        if (staffDto == null){
            return new ModelAndView("redirect:/user/login");
        }
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
//        System.out.println(rewardsDtoList.size());
        mav.addObject("rewardsList", rewardsDtoList);

        //显示借物记录
        List<EquipmentDto> equipmentDtoList = equipmentService.showEquipments(staffDto.getId(), 1);
        mav.addObject("equipments", equipmentDtoList);
        int pageNumber = equipmentService.pageNumber(staffDto.getId());
        mav.addObject("pageNumber", pageNumber);

        //显示离校登记
        List<LeaveregistDto> leaveregistDtoList = leaveregistService.showLeaveRegist(staffDto, 1);
//        logger.info(String.valueOf(leaveregistDtoList.size()));
        mav.addObject("leaveList", leaveregistDtoList);
        int leavePageNumber = leaveregistService.pageNumber(staffDto.getId());
        mav.addObject("leavePageNumber", leavePageNumber);

        return mav;
    }

    @GetMapping("/staff/logout")
    public String logout(){
        if (httpSession != null){
            httpSession.invalidate();
        }
        return "redirect:/user/login";
    }
}
