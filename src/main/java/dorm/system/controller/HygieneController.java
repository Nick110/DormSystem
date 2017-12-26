package dorm.system.controller;

import dorm.system.dto.HygieneDormDto;
import dorm.system.dto.StaffDto;
import dorm.system.service.HygienegradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HygieneController {
    @Autowired
    private HygienegradesService hygienegradesService;


    @GetMapping("/staff/chooseFloor")
    public ModelAndView chooseFloor (@RequestParam("floor") int floor, HttpSession httpSession) {
        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        ModelAndView mav = new ModelAndView("dorm-admin");
        List<HygieneDormDto> hygieneDormDtoList = hygienegradesService.showDorm(staffDto, floor);
        if (hygieneDormDtoList == null) {
            mav.addObject("chooseFlrNull", "该楼层没有可用寝室！");
        }
        else {
            mav.addObject("floor", floor);
            mav.addObject("dormList", hygieneDormDtoList);
        }
        return mav;
    }
}
