package com.rentocar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rentocar.model.LicenseImg;
import com.rentocar.model.Message;
import com.rentocar.service.FileUploadService;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadService fileService;

	@PostMapping("/license_upload/{userId}")
	public Message fileUpload(@PathVariable("userId") String userId, @RequestParam("file") MultipartFile file)	{
		try	{
			fileService.store(userId, file);
			return new Message("file has been uploaded", "success");
		}
		catch(Exception e)	{
			return new Message("file is not uploaded", "failure");
		}
	}
	
	@GetMapping("/get_license/{userId}")
	public LicenseImg getLicenseInfo(@PathVariable("userId") String userId)	{
		return fileService.getLicenseInfo(userId);
	}
}
