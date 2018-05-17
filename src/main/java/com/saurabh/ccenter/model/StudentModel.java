package com.saurabh.ccenter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "student")
public class StudentModel {
    @Id
    @GeneratedValue
    public Integer id;
    public String name;
    public String mobileNumber;
    public String fatherName;
    public String motherName;
    public String address;
    public String schoolName;
    public String className;
    public String dateOfAdmission;
    public String fatherMobileNumber;
    public String motherMobileNumber;
    public String remarks;
}
