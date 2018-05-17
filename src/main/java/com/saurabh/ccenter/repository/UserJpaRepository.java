package com.saurabh.ccenter.repository;

import com.saurabh.ccenter.model.BatchModel;
import com.saurabh.ccenter.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserModel,Integer> {
}
