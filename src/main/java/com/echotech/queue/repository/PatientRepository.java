package com.echotech.queue.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.echotech.queue.model.PatientMaster;

@Repository
public interface PatientRepository extends JpaRepository<PatientMaster, Integer> {

	@Query("SELECT e FROM PatientMaster e WHERE e.ptntMobileNumber = :mobileNo AND e.ptntFullName = :fullName")
	Optional<PatientMaster> findByPhoneNumberAndName(@Param("mobileNo")String mobileNumber, @Param("fullName")String fullName);

}
