package com.echotech.queue.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient_master")
public class PatientMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ptnt_sys_id", nullable = false)
    private Integer ptntSysId;

    @Column(name = "ptnt_user_sys_id")
    private Integer ptntUserSysId;

    @Column(name = "ptnt_first_name")
    private String ptntFirstName;

    @Column(name = "ptnt_middle_name")
    private String ptntMiddleName;

    @Column(name = "ptnt_sur_name")
    private String ptntSurName;

    @Column(name = "ptnt_full_name")
    private String ptntFullName;

    @Column(name = "ptnt_age")
    private Integer ptntAge;

    @Column(name = "ptnt_gender")
    private String ptntGender;

    @Column(name = "ptnt_blood_group")
    private String ptntBloodGroup;

    @Column(name = "ptnt_marital_status")
    private String ptntMaritalStatus;

    @Column(name = "ptnt_mobile_number")
    private String ptntMobileNumber;
    
    @Column(name = "ptnt_email_id")
    private String ptntEmailId;

    @Column(name = "ptnt_emrgy_cont_name")
    private String ptntEmrgyContName;

    @Column(name = "ptnt_emrgy_cont_no")
    private String ptntEmrgyContNo;

    @Column(name = "ptnt_address_line1")
    private String ptntAddressLine1;

    @Column(name = "ptnt_address_line2")
    private String ptntAddressLine2;

    @Column(name = "ptnt_address_line3")
    private String ptntAddressLine3;

    @Column(name = "ptnt_state")
    private String ptntState;

    @Column(name = "ptnt_city")
    private String ptntCity;

    @Column(name = "ptnt_country")
    private String ptntCountry;

    @Column(name = "ptnt_pincode")
    private String ptntPincode;

    @Column(name = "ptnt_insurance_code")
    private String ptntInsuranceCode;

    @Column(name = "ptnt_ins_prov_code")
    private String ptntInsProvCode;

    @Column(name = "ptnt_allergies")
    private String ptntAllergies;

    @Column(name = "ptnt_exist_condtns")
    private String ptntExistCondtns;

    @Column(name = "ptnt_created_at")
    private LocalDateTime ptntCreatedAt;

    @Column(name = "ptnt_created_by")
    private String ptntCreatedBy;

    @Column(name = "ptnt_updated_at")
    private LocalDateTime ptntUpdatedAt;

    @Column(name = "ptnt_updated_by")
    private String ptntUpdatedBy;

	public Integer getPtntSysId() {
		return ptntSysId;
	}

	public void setPtntSysId(Integer ptntSysId) {
		this.ptntSysId = ptntSysId;
	}

	public Integer getPtntUserSysId() {
		return ptntUserSysId;
	}

	public void setPtntUserSysId(Integer ptntUserSysId) {
		this.ptntUserSysId = ptntUserSysId;
	}

	public String getPtntFirstName() {
		return ptntFirstName;
	}

	public void setPtntFirstName(String ptntFirstName) {
		this.ptntFirstName = ptntFirstName;
	}

	public String getPtntMiddleName() {
		return ptntMiddleName;
	}

	public void setPtntMiddleName(String ptntMiddleName) {
		this.ptntMiddleName = ptntMiddleName;
	}

	public String getPtntSurName() {
		return ptntSurName;
	}

	public void setPtntSurName(String ptntSurName) {
		this.ptntSurName = ptntSurName;
	}

	public String getPtntFullName() {
		return ptntFullName;
	}

	public void setPtntFullName(String ptntFullName) {
		this.ptntFullName = ptntFullName;
	}

	public Integer getPtntAge() {
		return ptntAge;
	}

	public void setPtntAge(Integer ptntAge) {
		this.ptntAge = ptntAge;
	}

	public String getPtntGender() {
		return ptntGender;
	}

	public void setPtntGender(String ptntGender) {
		this.ptntGender = ptntGender;
	}

	public String getPtntBloodGroup() {
		return ptntBloodGroup;
	}

	public void setPtntBloodGroup(String ptntBloodGroup) {
		this.ptntBloodGroup = ptntBloodGroup;
	}

	public String getPtntMaritalStatus() {
		return ptntMaritalStatus;
	}

	public void setPtntMaritalStatus(String ptntMaritalStatus) {
		this.ptntMaritalStatus = ptntMaritalStatus;
	}

	public String getPtntMobileNumber() {
		return ptntMobileNumber;
	}

	public void setPtntMobileNumber(String ptntMobileNumber) {
		this.ptntMobileNumber = ptntMobileNumber;
	}

	public String getPtntEmailId() {
		return ptntEmailId;
	}

	public void setPtntEmailId(String ptntEmailId) {
		this.ptntEmailId = ptntEmailId;
	}

	public String getPtntEmrgyContName() {
		return ptntEmrgyContName;
	}

	public void setPtntEmrgyContName(String ptntEmrgyContName) {
		this.ptntEmrgyContName = ptntEmrgyContName;
	}

	public String getPtntEmrgyContNo() {
		return ptntEmrgyContNo;
	}

	public void setPtntEmrgyContNo(String ptntEmrgyContNo) {
		this.ptntEmrgyContNo = ptntEmrgyContNo;
	}

	public String getPtntAddressLine1() {
		return ptntAddressLine1;
	}

	public void setPtntAddressLine1(String ptntAddressLine1) {
		this.ptntAddressLine1 = ptntAddressLine1;
	}

	public String getPtntAddressLine2() {
		return ptntAddressLine2;
	}

	public void setPtntAddressLine2(String ptntAddressLine2) {
		this.ptntAddressLine2 = ptntAddressLine2;
	}

	public String getPtntAddressLine3() {
		return ptntAddressLine3;
	}

	public void setPtntAddressLine3(String ptntAddressLine3) {
		this.ptntAddressLine3 = ptntAddressLine3;
	}

	public String getPtntState() {
		return ptntState;
	}

	public void setPtntState(String ptntState) {
		this.ptntState = ptntState;
	}

	public String getPtntCity() {
		return ptntCity;
	}

	public void setPtntCity(String ptntCity) {
		this.ptntCity = ptntCity;
	}

	public String getPtntCountry() {
		return ptntCountry;
	}

	public void setPtntCountry(String ptntCountry) {
		this.ptntCountry = ptntCountry;
	}

	public String getPtntPincode() {
		return ptntPincode;
	}

	public void setPtntPincode(String ptntPincode) {
		this.ptntPincode = ptntPincode;
	}

	public String getPtntInsuranceCode() {
		return ptntInsuranceCode;
	}

	public void setPtntInsuranceCode(String ptntInsuranceCode) {
		this.ptntInsuranceCode = ptntInsuranceCode;
	}

	public String getPtntInsProvCode() {
		return ptntInsProvCode;
	}

	public void setPtntInsProvCode(String ptntInsProvCode) {
		this.ptntInsProvCode = ptntInsProvCode;
	}

	public String getPtntAllergies() {
		return ptntAllergies;
	}

	public void setPtntAllergies(String ptntAllergies) {
		this.ptntAllergies = ptntAllergies;
	}

	public String getPtntExistCondtns() {
		return ptntExistCondtns;
	}

	public void setPtntExistCondtns(String ptntExistCondtns) {
		this.ptntExistCondtns = ptntExistCondtns;
	}

	public LocalDateTime getPtntCreatedAt() {
		return ptntCreatedAt;
	}

	public void setPtntCreatedAt(LocalDateTime ptntCreatedAt) {
		this.ptntCreatedAt = ptntCreatedAt;
	}

	public String getPtntCreatedBy() {
		return ptntCreatedBy;
	}

	public void setPtntCreatedBy(String ptntCreatedBy) {
		this.ptntCreatedBy = ptntCreatedBy;
	}

	public LocalDateTime getPtntUpdatedAt() {
		return ptntUpdatedAt;
	}

	public void setPtntUpdatedAt(LocalDateTime ptntUpdatedAt) {
		this.ptntUpdatedAt = ptntUpdatedAt;
	}

	public String getPtntUpdatedBy() {
		return ptntUpdatedBy;
	}

	public void setPtntUpdatedBy(String ptntUpdatedBy) {
		this.ptntUpdatedBy = ptntUpdatedBy;
	}
    
}