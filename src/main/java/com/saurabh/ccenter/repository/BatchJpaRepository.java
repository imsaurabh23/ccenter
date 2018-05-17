package com.saurabh.ccenter.repository;

import com.saurabh.ccenter.model.BatchModel;
import com.saurabh.ccenter.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchJpaRepository extends JpaRepository<BatchModel,Integer> {
}
