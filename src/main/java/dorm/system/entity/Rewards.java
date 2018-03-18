package dorm.system.entity;

public class Rewards {
    private int id;
    private Dormitory dormId;
    private String context;
    private String term;
    private Staff staffId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dormitory getDormId() {
        return dormId;
    }

    public void setDormId(Dormitory dormId) {
        this.dormId = dormId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }
}
