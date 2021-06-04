package com.srk.moviecatalogue.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class UserMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@NotNull
	@NotBlank
	private String userName;
	
	@Max(value = 10,message = "can not be grtthan 10")
	private String mobileNum;
	
	public UserMaster()
	{
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public UserMaster(long userId, @NotNull @NotBlank String userName,
			@Max(value = 10, message = "can not be grtthan 10") String mobileNum) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.mobileNum = mobileNum;
	}
	
	
}
