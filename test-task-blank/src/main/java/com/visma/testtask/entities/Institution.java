package com.visma.testtask.entities;

import com.visma.testtask.InstitutionStatus;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "institutions")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "reg_num", nullable = false, unique = true)
    private String regNum;

    @Column(name = "reg_date", nullable = false)
    private LocalDateTime regDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "classifier_id")
    private ClassifierTranslation type;

    // Assuming InstitutionStatus is an enum you've defined elsewhere
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private InstitutionStatus status;

    // Default constructor
    public Institution() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ClassifierTranslation getType() {
        return type;
    }

    public void setType(ClassifierTranslation type) {
        this.type = type;
    }

    public InstitutionStatus getStatus() {
        return status;
    }

    public void setStatus(InstitutionStatus status) {
        this.status = status;
    }
}