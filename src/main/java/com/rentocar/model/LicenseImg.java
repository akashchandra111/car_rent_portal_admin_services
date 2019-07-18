package com.rentocar.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LicenseImg {
	
	@Id
	String licenseId;
	
	@ManyToOne
	User userId;
	String imgPath;
	
	public LicenseImg()	{
	}
	
	public LicenseImg(String licenseId, User userId, String imgPath) {
		this.licenseId = licenseId;
		this.userId = userId;
		this.imgPath = imgPath;
	}

	public String getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public User getUser() {
		return userId;
	}

	public void setUser(User user) {
		this.userId = user;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
}
