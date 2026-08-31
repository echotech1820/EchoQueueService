package com.echotech.queue.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WebServiceUtility {
	
	@Value("${spring.master.base.url}")
	public String masterBaseUrl;
	
	public String getClinicNameUrl(Integer clinicId) {
	    return masterBaseUrl + "api/v1/clinic/getClinName?clinicId=" + clinicId;
	}
	
	public Date stringToDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDate localDate = LocalDate.parse(date, formatter);

		Date convertedDate = Date.from(
		    localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()
		);
		
		return convertedDate;
	}
	
	public LocalDate stringToLocalDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDate localDate = LocalDate.parse(date, formatter);
		
		return localDate;
	}

}
