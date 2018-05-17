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
@Table(name = "batch")
public class BatchModel {
    @Id
    @GeneratedValue
    public Integer id;
    public String name;
    public String className;
    public String boardName;
    public String subjectName;
    public String fee;
    public String batchTime;
    public String teacherName;
}

