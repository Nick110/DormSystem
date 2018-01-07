package dorm.system.dto;

public class HygieneDto {
    private String roomNo;
    private String remarks;
    private String yearAndMonth;
    private String staffId;

    public String getYearAndMonth() {
        return yearAndMonth;
    }

    public void setYearAndMonth(String yearAndMonth) {
        this.yearAndMonth = yearAndMonth;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getRoomNo() {
        return roomNo;
    }



    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
