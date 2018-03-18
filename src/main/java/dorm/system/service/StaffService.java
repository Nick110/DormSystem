package dorm.system.service;

import dorm.system.dto.StaffDto;
import dorm.system.dto.UpdatePasswordDto;

public interface StaffService {
	public StaffDto login(StaffDto staff);
	public String updatePassword(UpdatePasswordDto updatePasswordDto);

}
