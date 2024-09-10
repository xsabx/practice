package com.visma.testtask.dto;

import java.time.LocalDateTime;

public class InstitutionDto {
    private String name;
    private String regNum;
    private LocalDateTime regDate;
    private String type;

    @Override
    public String toString() {
        return "InstitutionDto{" +
                "name='" + name + '\'' +
                ", regNum='" + regNum + '\'' +
                ", regDate=" + regDate +
                ", type='" + type + '\'' +
                '}';
    }

    public InstitutionDto(String name, String regNum, LocalDateTime regDate, String type) {
        this.name = name;
        this.regNum = regNum;
        this.regDate = regDate;
        this.type = type;
    }

    public InstitutionDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
