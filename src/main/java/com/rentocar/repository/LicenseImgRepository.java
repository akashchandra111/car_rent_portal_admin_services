package com.rentocar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rentocar.model.LicenseImg;

public interface LicenseImgRepository extends MongoRepository<LicenseImg, String> {
}
