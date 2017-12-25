package dorm.system.service.impl;

import dorm.system.dao.BuildingDao;
import dorm.system.dao.EquipmentDao;
import dorm.system.dao.StaffDao;
import dorm.system.dao.StudentDao;
import dorm.system.dto.EquipmentDto;
import dorm.system.dto.StaffDto;
import dorm.system.entity.Building;
import dorm.system.entity.Equipment;
import dorm.system.entity.Staff;
import dorm.system.entity.Student;
import dorm.system.service.EquipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {

    Logger logger = LoggerFactory.getLogger(EquipmentServiceImpl.class);

    @Autowired
    private BuildingDao buildingDao;
    @Autowired
    private EquipmentDao equipmentDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private StaffDao staffDao;
    @Autowired
    HttpSession httpSession;

    @Override
    public List<EquipmentDto> showEquipments(String staffId, int page) {
        Building building = buildingDao.get("from Building b where b.staff = " + staffId);
        int buildId = building.getId();
        String hql = "from Equipment e where e.buildId = " + buildId;
        List<Equipment> equipmentList = equipmentDao.find(hql, page, 7);
        List<EquipmentDto> equipmentDtoList = new ArrayList<EquipmentDto>();
        if (equipmentList == null || equipmentList.size() == 0) {
            return null;
        }
        for (Equipment equipment : equipmentList) {

            EquipmentDto equipemntDto = new EquipmentDto();
            BeanUtils.copyProperties(equipment, equipemntDto);
            equipemntDto.setStuId(equipment.getStuId().getId());
            equipemntDto.setBuildId(equipment.getBuildId().getId());
            equipemntDto.setRoomNo(equipment.getStuId().getDormId().getRoomNo());
            equipemntDto.setStaffId(staffId);

            //日期格式转换
            String bt;
            String rt;
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH时");
            bt = sdf.format(equipment.getBorrowTime());
            equipemntDto.setBorrowTime(bt);
            if (equipment.getReturnTime() != null){
                rt = sdf.format(equipment.getReturnTime());
                equipemntDto.setReturnTime(rt);
            }

//            logger.info(equipemntDto.getStuId());
            equipmentDtoList.add(equipemntDto);
        }
        return equipmentDtoList;
    }

    @Override
    public String addEquipment(EquipmentDto equipmentDto) {
        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        String staffId = staffDto.getId();
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(equipmentDto, equipment);
        Staff staff = staffDao.get(Staff.class, staffId);
        Student student = studentDao.get(Student.class, equipmentDto.getStuId());
        if (student == null) {
//            logger.info(student.getRealName());
            return "此学号不存在！";
        }
        Date date = new Date();
        equipment.setStuId(student);
        equipment.setBuildId(staff.getBuildId());
        equipment.setBorrowTime(new Timestamp(date.getTime()));
        equipmentDao.save(equipment);
        return "添加成功！";
    }

    @Override
    public int pageNumber(String staffId) {
        Building building = buildingDao.get("from Building b where b.staff = " + staffId);
        int buildId = building.getId();
        String hql = "from Equipment e where e.buildId = " + buildId;
        List<Equipment> equipmentList = equipmentDao.find(hql);
        Double a = Double.valueOf(equipmentList.size());
        Double pageNumberD = (a / 7);
        int pageNumber = (int) Math.ceil(pageNumberD);
        /*logger.info(String.valueOf(pageNumberD));
        logger.info(String.valueOf(pageNumber));*/
        return pageNumber;
    }

    @Override
    public void returned(int id) {
        Timestamp timestamp = new Timestamp((new Date()).getTime());
        Equipment equipment = equipmentDao.get(Equipment.class, id);
        equipment.setReturnTime(timestamp);
        equipmentDao.update(equipment);
    }
}
