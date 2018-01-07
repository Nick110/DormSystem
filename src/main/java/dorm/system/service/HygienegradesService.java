package dorm.system.service;

import dorm.system.dto.HygieneDormDto;
import dorm.system.dto.HygieneDto;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Hygienegrades;

import java.util.List;

public interface HygienegradesService {
    public List<HygieneDormDto> showDorm (StaffDto staffDto, int floor);
    public void addHygieneRemarks(List<HygieneDto> hygieneDtoList);
    public List<HygieneDto> seeHygiene (StaffDto staffDto);
    public String selectAptName(StaffDto staffDto);
}
