package com.echotech.queue.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class QueueTokenListItem {

	private Integer tokenSysId;

	private String tokenNo;

	private Integer seqNo;

	private String status;

	private Date tokenDate;

	private Integer consultingDoctorSysId;

	private Integer patientSysId;

	private String patientName;

	private String mobileNumber;

	private Integer age;

	private String gender;

	private Integer checkInTime;

	private LocalDateTime createdAt;

	public QueueTokenListItem(Integer tokenSysId, String tokenNo, Integer seqNo, String status, Date tokenDate,
			Integer consultingDoctorSysId, Integer patientSysId, String patientName, String mobileNumber, Integer age,
			String gender, Integer checkInTime, LocalDateTime createdAt) {
		this.tokenSysId = tokenSysId;
		this.tokenNo = tokenNo;
		this.seqNo = seqNo;
		this.status = status;
		this.tokenDate = tokenDate;
		this.consultingDoctorSysId = consultingDoctorSysId;
		this.patientSysId = patientSysId;
		this.patientName = patientName;
		this.mobileNumber = mobileNumber;
		this.age = age;
		this.gender = gender;
		this.checkInTime = checkInTime;
		this.createdAt = createdAt;
	}

	public Integer getTokenSysId() {
		return tokenSysId;
	}

	public void setTokenSysId(Integer tokenSysId) {
		this.tokenSysId = tokenSysId;
	}

	public String getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTokenDate() {
		return tokenDate;
	}

	public void setTokenDate(Date tokenDate) {
		this.tokenDate = tokenDate;
	}

	public Integer getConsultingDoctorSysId() {
		return consultingDoctorSysId;
	}

	public void setConsultingDoctorSysId(Integer consultingDoctorSysId) {
		this.consultingDoctorSysId = consultingDoctorSysId;
	}

	public Integer getPatientSysId() {
		return patientSysId;
	}

	public void setPatientSysId(Integer patientSysId) {
		this.patientSysId = patientSysId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public Integer getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(Integer checkInTime) {
		this.checkInTime = checkInTime;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
