package com.echotech.queue.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clinic_patient_fields_config")
public class ClinicPatientFieldsConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpfc_sys_id", nullable = false)
    private Integer cpfcSysId;

    @Column(name = "cpfc_clin_sys_id")
    private Integer cpfcClinSysId;

    @Column(name = "cpfc_pfm_sys_id")
    private Integer cpfcPfmSysId;

    @Column(name = "cpfc_show_in_form")
    private String cpfcShowInForm;

    @Column(name = "cpfc_is_mandatory")
    private String cpfcIsMandatory;
    
    @Column(name = "cpfc_created_at")
    private LocalDateTime cpfcCreatedAt;
    
    @Column(name = "cpfc_created_by")
    private String cpfcCreatedBy;
    
    @Column(name = "cpfc_updated_at")
    private LocalDateTime cpfcUpdatedAt;
    
    @Column(name = "cpfc_updated_by")
    private String cpfcUpdatedBy;

	public Integer getCpfcSysId() {
		return cpfcSysId;
	}

	public void setCpfcSysId(Integer cpfcSysId) {
		this.cpfcSysId = cpfcSysId;
	}

	public Integer getCpfcClinSysId() {
		return cpfcClinSysId;
	}

	public void setCpfcClinSysId(Integer cpfcClinSysId) {
		this.cpfcClinSysId = cpfcClinSysId;
	}

	public Integer getCpfcPfmSysId() {
		return cpfcPfmSysId;
	}

	public void setCpfcPfmSysId(Integer cpfcPfmSysId) {
		this.cpfcPfmSysId = cpfcPfmSysId;
	}

	public String getCpfcShowInForm() {
		return cpfcShowInForm;
	}

	public void setCpfcShowInForm(String cpfcShowInForm) {
		this.cpfcShowInForm = cpfcShowInForm;
	}

	public String getCpfcIsMandatory() {
		return cpfcIsMandatory;
	}

	public void setCpfcIsMandatory(String cpfcIsMandatory) {
		this.cpfcIsMandatory = cpfcIsMandatory;
	}

	public LocalDateTime getCpfcCreatedAt() {
		return cpfcCreatedAt;
	}

	public void setCpfcCreatedAt(LocalDateTime cpfcCreatedAt) {
		this.cpfcCreatedAt = cpfcCreatedAt;
	}

	public String getCpfcCreatedBy() {
		return cpfcCreatedBy;
	}

	public void setCpfcCreatedBy(String cpfcCreatedBy) {
		this.cpfcCreatedBy = cpfcCreatedBy;
	}

	public LocalDateTime getCpfcUpdatedAt() {
		return cpfcUpdatedAt;
	}

	public void setCpfcUpdatedAt(LocalDateTime cpfcUpdatedAt) {
		this.cpfcUpdatedAt = cpfcUpdatedAt;
	}

	public String getCpfcUpdatedBy() {
		return cpfcUpdatedBy;
	}

	public void setCpfcUpdatedBy(String cpfcUpdatedBy) {
		this.cpfcUpdatedBy = cpfcUpdatedBy;
	}
    
}
