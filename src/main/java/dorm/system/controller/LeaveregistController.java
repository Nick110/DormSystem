package dorm.system.controller;

import dorm.system.dto.LeaveregistDto;
import dorm.system.dto.StaffDto;
import dorm.system.service.LeaveregistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LeaveregistController {
    @Autowired
    private LeaveregistService leaveregistService;
    @Autowired
    HttpSession httpSession;

    @GetMapping("/staffHome/leave")
    public ModelAndView filp(@RequestParam("page") int page) {
//        int pageString = Integer.getInteger(page);
        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        String staffId = staffDto.getId();
        ModelAndView mav = new ModelAndView("dorm-admin");
        List<LeaveregistDto> leaveregistDtoList = leaveregistService.showLeaveRegist(staffDto, page);
        mav.addObject("leaveList", leaveregistDtoList);
        int leavePageNumber = leaveregistService.pageNumber(staffId);
        mav.addObject("leavePageNumber", leavePageNumber);
        return mav;
    }
}
