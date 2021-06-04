package com.srk.usermaster.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srk.usermaster.bean.UserMaster;
import com.srk.usermaster.exception.ResourceNotFoundException;
import com.srk.usermaster.service.UserMasterService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserMasterService userserv;
	
	@PostMapping(path = "/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody @Valid UserMaster user)
	{
         UserMaster ur = this.userserv.saveUser(user);
         return new ResponseEntity<>(ur,HttpStatus.CREATED);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUser(@PathVariable(name = "userId",required = true) @Valid long Id)
	{
		 UserMaster usr= userserv.getUser(Id).orElseThrow(()-> new ResourceNotFoundException("data for this Id not found "+Id));
		 return new ResponseEntity<>(usr,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable(name = "userId",required = true) @Valid long Id )
	{
		  boolean tr = this.userserv.UserExits(Id) ? true :false;
		  if(tr)
		  {
			  userserv.deleteUser(Id);		
	          return new ResponseEntity<>("deleted succesfully",HttpStatus.ACCEPTED);
		  }
		throw  new ResourceNotFoundException("data for this Id not found "+Id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserMaster> updateUser(@RequestBody @Valid UserMaster usermst)
	{
		 UserMaster user = userserv.getUser(usermst.getUserId()).orElseThrow(()-> new ResourceNotFoundException("data for this Id not found "+usermst.getUserId()));
	       user.setMobileNum(usermst.getMobileNum());
	       user.setUserName(usermst.getUserName());
	       userserv.saveUser(user);
	       return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
	}
	
}
