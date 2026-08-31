package com.echotech.queue.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.echotech.queue.model.ClinicPatientFieldsConfig;

@Repository
public interface ClinicPatientFieldsConfigRepository extends JpaRepository<ClinicPatientFieldsConfig, Integer> {

	List<ClinicPatientFieldsConfig> findByCpfcClinSysId(Integer clinicSysId);

	Optional<ClinicPatientFieldsConfig> findByCpfcClinSysIdAndCpfcPfmSysId(Integer clinicSysId, Integer fieldId);

}
