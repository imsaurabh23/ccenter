package com.saurabh.ccenter.repository;

import com.saurabh.ccenter.model.StudentBatchAllocationModel;
import com.saurabh.ccenter.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBatchAllocationJpaRepository extends JpaRepository<StudentBatchAllocationModel,Integer> {
}
