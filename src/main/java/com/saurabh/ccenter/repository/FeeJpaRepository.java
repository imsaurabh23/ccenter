package com.saurabh.ccenter.repository;

import com.saurabh.ccenter.model.FeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeJpaRepository extends JpaRepository<FeeModel,Integer> {
}
