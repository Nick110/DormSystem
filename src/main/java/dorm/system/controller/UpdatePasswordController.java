package dorm.system.controller;

import dorm.system.dto.UpdatePasswordDto;
import dorm.system.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UpdatePasswordController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/staff/updatePassword")
    public ModelAndView updatePassword(UpdatePasswordDto updatePasswordDto, RedirectAttributes redirectAttributes) {
        String message = staffService.updatePassword(updatePasswordDto);
        redirectAttributes.addFlashAttribute("updatePasswordResult", message);
        ModelAndView mav = new ModelAndView("redirect:/staffHome");
        return mav;
    }
}
