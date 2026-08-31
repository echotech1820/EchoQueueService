package com.echotech.queue.dto;

public class PatientFieldConfigItem {

	private Integer fieldId;

	private String fieldName;

	private Object isShow;

	private Object isMandatory;

	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getIsShow() {
		return isShow;
	}

	public void setIsShow(Object isShow) {
		this.isShow = isShow;
	}

	public Object getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(Object isMandatory) {
		this.isMandatory = isMandatory;
	}

}
