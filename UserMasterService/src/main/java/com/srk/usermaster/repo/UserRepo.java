package com.srk.usermaster.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srk.usermaster.bean.UserMaster;

@Repository
public interface UserRepo extends JpaRepository<UserMaster,Long> {

	 
}
