package dorm.system.controller;

import dorm.system.dto.HygieneDormDto;
import dorm.system.dto.HygieneDto;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Hygienegrades;
import dorm.system.service.HygienegradesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class HygieneController {
    @Autowired
    private HygienegradesService hygienegradesService;
    Logger logger = LoggerFactory.getLogger(HygieneController.class);


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

    @GetMapping("/staff/seeHygiene")
    public ModelAndView seeHygiene(HttpSession httpSession){
        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        ModelAndView mav = new ModelAndView("hygiene-list");
        List<HygieneDto> hygieneDtoList = hygienegradesService.seeHygiene(staffDto);
        mav.addObject("hygieneList", hygieneDtoList);
        String aptName = hygienegradesService.selectAptName(staffDto);
        mav.addObject("aptName", aptName);
        return mav;
    }

    @PostMapping("/staff/hygieneRemarks")
    @ResponseBody
    public void addHygieneRemarks (@RequestBody HygieneDto[] hygieneDtos, HttpSession httpSession) {
        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        String staffId = staffDto.getId();
        for (HygieneDto hygieneDto : hygieneDtos) {
            hygieneDto.setStaffId(staffId);
        }
        //将数组转为List
        List<HygieneDto> hygieneDtoList = Arrays.asList(hygieneDtos);
        logger.info(hygieneDtoList.get(0).getRemarks());
        hygienegradesService.addHygieneRemarks(hygieneDtoList);
    }
}
