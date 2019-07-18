package com.rentocar.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LicenseImgRepository extends JpaRepository<LicenseImg, String> {

	@Query(value="select * from license_img where user_id_user_id=?1", nativeQuery=true)
	public Optional<LicenseImg> findByUserId(String userId);
}
