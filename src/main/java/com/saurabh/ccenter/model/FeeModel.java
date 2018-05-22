package com.saurabh.ccenter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "fee")
public class FeeModel {
    @Id
    @GeneratedValue
    public Integer id;
    public Integer studentId;
    public Integer batchId;
    public String submittedTo;
    public String transactionDate;
    public String feeType;
    public Integer amount;
}

