package dorm.system.service;

import dorm.system.dto.MaintenanceDto;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Maintenance;

import java.util.List;

public interface MaintenanceService {
    public List<MaintenanceDto> showMaintenance (StaffDto staffDto);
    public void doRepair (int id);

}
