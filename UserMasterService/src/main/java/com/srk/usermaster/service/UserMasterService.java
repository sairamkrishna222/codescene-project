package com.srk.usermaster.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srk.usermaster.bean.UserMaster;
import com.srk.usermaster.repo.UserRepo;

@Service
public class UserMasterService {

	@Autowired
	private UserRepo userrepo;
	
	public UserMaster saveUser(UserMaster urm)
	{
       return userrepo.save(urm);		
	}
	
	public Optional<UserMaster> getUser(long userId)
	{
       return userrepo.findById(userId);
	}
	
	public void deleteUser(long userId)
	{
		userrepo.deleteById(userId);
	}
	
	public boolean UserExits(long Id)
	{
		return userrepo.existsById(Id);
	}
	
}
