package com.echotech.queue.dto;

public class QueueTokenRequest {
	
	private String mobileNumber;
	
	private String fullName;
	
	private Integer age;
	
	private String gender;
	
	private String tokenDate;
	
	private Integer clinicSysId;
	
	private Integer consultingDoctorSysId;
	
	private String chiefComplaint;
	
	private String bloodGroup;
	
	private String dob;
	
	private String city;
	
	private String service;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTokenDate() {
		return tokenDate;
	}

	public void setTokenDate(String tokenDate) {
		this.tokenDate = tokenDate;
	}

	public Integer getClinicSysId() {
		return clinicSysId;
	}

	public void setClinicSysId(Integer clinicSysId) {
		this.clinicSysId = clinicSysId;
	}

	public Integer getConsultingDoctorSysId() {
		return consultingDoctorSysId;
	}

	public void setConsultingDoctorSysId(Integer consultingDoctorSysId) {
		this.consultingDoctorSysId = consultingDoctorSysId;
	}

	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

}
