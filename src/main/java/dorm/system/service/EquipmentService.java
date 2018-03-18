package dorm.system.service;

import dorm.system.dto.EquipmentDto;

import java.util.List;

public interface EquipmentService {
    public List<EquipmentDto> showEquipments (String staffId, int page);
    public String addEquipment (EquipmentDto equipmentDto);
    public int pageNumber (String staffId);
    public void returned(int id);
}
