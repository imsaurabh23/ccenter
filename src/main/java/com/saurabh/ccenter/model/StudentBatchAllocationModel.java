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
@Table(name = "studentBatchAllocation")
public class StudentBatchAllocationModel {
    @Id
    @GeneratedValue
    public Integer id;
    public String batchId;
    public String studentId;
    public String allocationDate;
    public String amount;
}

