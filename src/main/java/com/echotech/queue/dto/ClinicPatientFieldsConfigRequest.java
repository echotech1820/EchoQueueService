package com.echotech.queue.dto;

import java.util.List;

public class ClinicPatientFieldsConfigRequest {

	private Integer clinicSysId;

	private List<PatientFieldConfigItem> fields;

	public Integer getClinicSysId() {
		return clinicSysId;
	}

	public void setClinicSysId(Integer clinicSysId) {
		this.clinicSysId = clinicSysId;
	}

	public List<PatientFieldConfigItem> getFields() {
		return fields;
	}

	public void setFields(List<PatientFieldConfigItem> fields) {
		this.fields = fields;
	}

}
