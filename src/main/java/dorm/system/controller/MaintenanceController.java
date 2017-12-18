package dorm.system.controller;

import dorm.system.service.MaintenanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MaintenanceController {
    Logger logger = LoggerFactory.getLogger(MaintenanceController.class);
    @Autowired
    MaintenanceService maintenanceService;
    @PostMapping("/staff/doRepair")
    public String doRepair (@RequestParam("maintenanceId") String maintenanceId) {
        logger.info(maintenanceId);
        maintenanceService.doRepair(Integer.parseInt(maintenanceId.trim()));
        return "redirect:/staffHome";
    }
}
