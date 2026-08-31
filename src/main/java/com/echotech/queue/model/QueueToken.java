package com.echotech.queue.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "queue_token")
public class QueueToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qut_sys_id", nullable = false)
    private Integer qutSysId;

    @Column(name = "qut_token_no", length = 45)
    private String qutTokenNo;

    @Column(name = "qut_ptnt_sys_id", nullable = false)
    private Integer qutPtntSysId;

    @Column(name = "qut_doc_sys_id")
    private Integer qutDocSysId;

    @Column(name = "qut_check_in_time")
    private Integer qutCheckInTime;

    @Column(name = "qut_status", length = 45)
    private String qutStatus;

    @Column(name = "qut_actions", length = 45)
    private String qutActions;

    @Column(name = "qut_created_at")
    private LocalDateTime qutCreatedAt;

    @Column(name = "qut_created_by", length = 45)
    private String qutCreatedBy;

    @Column(name = "qut_updated_at")
    private LocalDateTime qutUpdatedAt;

    @Column(name = "qut_updated_by", length = 45)
    private String qutUpdatedBy;

    @Column(name = "qut_token_date")
    private Date qutTokenDate;

    @Column(name = "qut_clin_sys_id")
    private Integer qutClinSysId;

    @Column(name = "qut_bill_sys_id")
    private Integer qutBillSysId;

    @Column(name = "qut_vitals_sys_id")
    private Integer qutVitalsSysId;

    @Column(name = "qut_lab_sys_id")
    private Integer qutLabSysId;
    
    @Column(name = "qut_seq_no")
    private Integer qutSeqNo;

	public Integer getQutSysId() {
		return qutSysId;
	}

	public void setQutSysId(Integer qutSysId) {
		this.qutSysId = qutSysId;
	}

	public String getQutTokenNo() {
		return qutTokenNo;
	}

	public void setQutTokenNo(String qutTokenNo) {
		this.qutTokenNo = qutTokenNo;
	}

	public Integer getQutPtntSysId() {
		return qutPtntSysId;
	}

	public void setQutPtntSysId(Integer qutPtntSysId) {
		this.qutPtntSysId = qutPtntSysId;
	}

	public Integer getQutDocSysId() {
		return qutDocSysId;
	}

	public void setQutDocSysId(Integer qutDocSysId) {
		this.qutDocSysId = qutDocSysId;
	}

	public Integer getQutCheckInTime() {
		return qutCheckInTime;
	}

	public void setQutCheckInTime(Integer qutCheckInTime) {
		this.qutCheckInTime = qutCheckInTime;
	}

	public String getQutStatus() {
		return qutStatus;
	}

	public void setQutStatus(String qutStatus) {
		this.qutStatus = qutStatus;
	}

	public String getQutActions() {
		return qutActions;
	}

	public void setQutActions(String qutActions) {
		this.qutActions = qutActions;
	}

	public LocalDateTime getQutCreatedAt() {
		return qutCreatedAt;
	}

	public void setQutCreatedAt(LocalDateTime qutCreatedAt) {
		this.qutCreatedAt = qutCreatedAt;
	}

	public String getQutCreatedBy() {
		return qutCreatedBy;
	}

	public void setQutCreatedBy(String qutCreatedBy) {
		this.qutCreatedBy = qutCreatedBy;
	}

	public LocalDateTime getQutUpdatedAt() {
		return qutUpdatedAt;
	}

	public void setQutUpdatedAt(LocalDateTime qutUpdatedAt) {
		this.qutUpdatedAt = qutUpdatedAt;
	}

	public String getQutUpdatedBy() {
		return qutUpdatedBy;
	}

	public void setQutUpdatedBy(String qutUpdatedBy) {
		this.qutUpdatedBy = qutUpdatedBy;
	}

	public Date getQutTokenDate() {
		return qutTokenDate;
	}

	public void setQutTokenDate(Date qutTokenDate) {
		this.qutTokenDate = qutTokenDate;
	}

	public Integer getQutClinSysId() {
		return qutClinSysId;
	}

	public void setQutClinSysId(Integer qutClinSysId) {
		this.qutClinSysId = qutClinSysId;
	}

	public Integer getQutBillSysId() {
		return qutBillSysId;
	}

	public void setQutBillSysId(Integer qutBillSysId) {
		this.qutBillSysId = qutBillSysId;
	}

	public Integer getQutVitalsSysId() {
		return qutVitalsSysId;
	}

	public void setQutVitalsSysId(Integer qutVitalsSysId) {
		this.qutVitalsSysId = qutVitalsSysId;
	}

	public Integer getQutLabSysId() {
		return qutLabSysId;
	}

	public void setQutLabSysId(Integer qutLabSysId) {
		this.qutLabSysId = qutLabSysId;
	}

	public Integer getQutSeqNo() {
		return qutSeqNo;
	}

	public void setQutSeqNo(Integer qutSeqNo) {
		this.qutSeqNo = qutSeqNo;
	}
    
}
