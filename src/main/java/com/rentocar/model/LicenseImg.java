package com.rentocar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="license_img")
public class LicenseImg {
	
	@Id
	String licenseId;
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
