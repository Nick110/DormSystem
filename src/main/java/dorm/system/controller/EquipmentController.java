package dorm.system.controller;

import dorm.system.dto.EquipmentDto;
import dorm.system.dto.StaffDto;
import dorm.system.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    HttpSession httpSession;
    @GetMapping("/staffHome/filp")
    public ModelAndView filp(@RequestParam("page") int page) {
//        int pageString = Integer.getInteger(page);
        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        String staffId = staffDto.getId();
        ModelAndView mav = new ModelAndView("dorm-admin");
        List<EquipmentDto> equipmentDtoList = equipmentService.showEquipments(staffId, page);
        mav.addObject("equipments", equipmentDtoList);
        int pageNumber = equipmentService.pageNumber(staffId);
        mav.addObject("pageNumber", pageNumber);
        return mav;
    }

    @PostMapping("/staff/return")
    public String returned (@RequestParam("equipmentId") String equipmentId) {
        int id = Integer.parseInt(equipmentId.trim());
        equipmentService.returned(id);
        return "redirect:/staffHome";
    }

    @PostMapping("/staff/borrow")
    public ModelAndView addBorrow(EquipmentDto equipmentDto, HttpServletRequest request) {
        String message = equipmentService.addEquipment(equipmentDto);
        ModelAndView mav = new ModelAndView("dorm-admin");
        mav.addObject("message", message);
        return mav;
    }
}
