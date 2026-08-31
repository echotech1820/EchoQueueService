package com.echotech.queue.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient_fields_master")
public class PatientFieldsMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pfm_sys_id", nullable = false)
    private Integer pfmSysId;

    @Column(name = "pfm_field_name")
    private String pfmFieldName;

    @Column(name = "pfm_field_label")
    private String pfmFieldLabel;

    @Column(name = "pfm_is_active")
    private String pfmIsActive;

	public Integer getPfmSysId() {
		return pfmSysId;
	}

	public void setPfmSysId(Integer pfmSysId) {
		this.pfmSysId = pfmSysId;
	}

	public String getPfmFieldName() {
		return pfmFieldName;
	}

	public void setPfmFieldName(String pfmFieldName) {
		this.pfmFieldName = pfmFieldName;
	}

	public String getPfmFieldLabel() {
		return pfmFieldLabel;
	}

	public void setPfmFieldLabel(String pfmFieldLabel) {
		this.pfmFieldLabel = pfmFieldLabel;
	}

	public String getPfmIsActive() {
		return pfmIsActive;
	}

	public void setPfmIsActive(String pfmIsActive) {
		this.pfmIsActive = pfmIsActive;
	}

}
