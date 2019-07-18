// User [Author: Akash Chandra]
package com.rentocar.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable	{
	
	@Id
	private String userId;	
	private String firstName, lastName, mobileNum, govtIdType, govtIdNum, drivingLicenseNum, userName, password, email;
	private Integer wallet;
	
	public User()	{
	}

	public User(String userId, String firstName, String lastName, String mobileNum, String govtIdType, String govtIdNum,
			String drivingLicenseNum, String userName, String password, String email, Integer wallet) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNum = mobileNum;
		this.govtIdType = govtIdType;
		this.govtIdNum = govtIdNum;
		this.drivingLicenseNum = drivingLicenseNum;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.wallet = wallet;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getGovtIdType() {
		return govtIdType;
	}

	public void setGovtIdType(String govtIdType) {
		this.govtIdType = govtIdType;
	}

	public String getGovtIdNum() {
		return govtIdNum;
	}

	public void setGovtIdNum(String govtIdNum) {
		this.govtIdNum = govtIdNum;
	}
	
	public String getDrivingLicenseNum()	{
		return drivingLicenseNum;
	}
	
	public void setDrivingLicenseNum(String drivingLicenseNum)	{
		this.drivingLicenseNum = drivingLicenseNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getWallet() {
		return wallet;
	}

	public void setWallet(Integer wallet) {
		this.wallet = wallet;
	}
}
