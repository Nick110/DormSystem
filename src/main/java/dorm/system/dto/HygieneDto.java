package dorm.system.dto;

import dorm.system.entity.Hygienegrades;

import java.util.List;

public class HygieneDto {
    List<Hygienegrades> hygienegradesList;

    public List<Hygienegrades> getHygienegradesList() {
        return hygienegradesList;
    }

    public void setHygienegradesList(List<Hygienegrades> hygienegradesList) {
        this.hygienegradesList = hygienegradesList;
    }
}
