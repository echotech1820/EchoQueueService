package com.echotech.queue.dto;

public class QueueTokenListRequest {

	private Integer clinicSysId;

	private String tokenDate;

	private String status;

	private Integer consultingDoctorSysId;

	private String search;

	public Integer getClinicSysId() {
		return clinicSysId;
	}

	public void setClinicSysId(Integer clinicSysId) {
		this.clinicSysId = clinicSysId;
	}

	public String getTokenDate() {
		return tokenDate;
	}

	public void setTokenDate(String tokenDate) {
		this.tokenDate = tokenDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getConsultingDoctorSysId() {
		return consultingDoctorSysId;
	}

	public void setConsultingDoctorSysId(Integer consultingDoctorSysId) {
		this.consultingDoctorSysId = consultingDoctorSysId;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
