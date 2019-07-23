package com.rentocar.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rentocar.model.LicenseImg;
import com.rentocar.model.User;
import com.rentocar.repository.LicenseImgRepository;

@Service
public class FileUploadService {
	
	@Autowired
	LicenseImgRepository licenseImgRepository;
	
	private final Path licenseImgPath = Paths.get("licenses");
	
	public void store(String userId, MultipartFile file)	{
		try	{
			Files.copy(file.getInputStream(), this.licenseImgPath.resolve(file.getOriginalFilename()));
			licenseImgRepository.save(
				new LicenseImg(
					new Double(Math.floor((Math.random()*100000))).toString(),
					new User(userId, "", "", "", "", "", "", "", "", "", 0),
					file.getOriginalFilename()
				)
			);
		}
		catch(Exception e)	{
			System.out.println("upload failed exception occured!");
		}
	}

	public LicenseImg getLicenseInfo(String userId) {
//		return licenseImgRepository.findByUserId(userId).orElse(new LicenseImg());
		return licenseImgRepository
			.findAll()
			.stream()
			.filter(licenseImg -> licenseImg.getUser().getUserId().equals(userId))
			.findFirst().orElse(new LicenseImg());
	}
}
