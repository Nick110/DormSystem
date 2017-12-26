package dorm.system.service;

import dorm.system.dto.HygieneDormDto;
import dorm.system.dto.HygieneDto;
import dorm.system.dto.StaffDto;

import java.util.List;

public interface HygienegradesService {
    public List<HygieneDormDto> showDorm (StaffDto staffDto, int floor);
}
