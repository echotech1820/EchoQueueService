package com.echotech.queue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.echotech.queue.model.PatientFieldsMaster;

@Repository
public interface PatientFieldsMasterRepository extends JpaRepository<PatientFieldsMaster, Integer> {

	List<PatientFieldsMaster> findByPfmSysIdIn(List<Integer> fieldIds);

}
