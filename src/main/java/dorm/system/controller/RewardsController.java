package dorm.system.controller;

import dorm.system.dto.RewardsDto;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Staff;
import dorm.system.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RewardsController {
    @Autowired
    private RewardsService rewardsService;
//    @Autowired
//    HttpSession httpSession;

    @PostMapping("/staff/addAwards")
    public String addAwards(RewardsDto rewardsDto) {
//        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        rewardsService.addRewards(rewardsDto);
        return "redirect:/staffHome";
    }
}
