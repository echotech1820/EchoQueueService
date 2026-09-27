package com.echotech.queue.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.echotech.queue.dto.QueueTokenListItem;
import com.echotech.queue.dto.QueueTokenListRequest;
import com.echotech.queue.dto.ResponseDto;
import com.echotech.queue.repository.PatientRepository;
import com.echotech.queue.repository.QueueTokenRepository;
import com.echotech.queue.util.WebServiceUtility;

@ExtendWith(MockitoExtension.class)
class QueueTokenServiceImplGetTokensTest {

	@Mock
	private PatientRepository patientRepo;

	@Mock
	private QueueTokenRepository queueTokenRepo;

	@Mock
	private WebServiceUtility webServiceUtility;

	@InjectMocks
	private QueueTokenServiceImpl service;

	@Test
	void getTokens_rejectsMissingClinicId() {
		QueueTokenListRequest request = new QueueTokenListRequest();
		request.setTokenDate("16-07-2026");

		ResponseDto response = service.getTokens(request);

		assertEquals("FAILURE", response.getStatus());
		assertEquals("Clinic Id is required", response.getMessage());
	}

	@Test
	void getTokens_rejectsInvalidDate() {
		QueueTokenListRequest request = new QueueTokenListRequest();
		request.setClinicSysId(12);
		request.setTokenDate("2026-07-16");

		when(webServiceUtility.stringToDate("2026-07-16"))
				.thenThrow(new java.time.format.DateTimeParseException("invalid", "2026-07-16", 0));

		ResponseDto response = service.getTokens(request);

		assertEquals("FAILURE", response.getStatus());
		assertEquals("Token date must be in dd-MM-yyyy format", response.getMessage());
	}

	@Test
	void getTokens_returnsEmptySuccessWhenNoMatches() {
		QueueTokenListRequest request = new QueueTokenListRequest();
		request.setClinicSysId(12);
		request.setTokenDate("16-07-2026");
		request.setStatus("WAITING");
		request.setConsultingDoctorSysId(5);
		request.setSearch("Geetha");

		Date parsedDate = new Date();
		when(webServiceUtility.stringToDate("16-07-2026")).thenReturn(parsedDate);
		when(queueTokenRepo.findTokensByFilters(eq(12), eq(parsedDate), eq("WAITING"), eq(5), eq("Geetha")))
				.thenReturn(Collections.emptyList());

		ResponseDto response = service.getTokens(request);

		assertEquals("SUCCESS", response.getStatus());
		assertEquals("No patients to serve", response.getMessage());
		assertTrue(response.getData() instanceof List<?>);
		assertTrue(((List<?>) response.getData()).isEmpty());
	}

	@Test
	void getTokens_defaultsToTodayWhenDateMissing() {
		QueueTokenListRequest request = new QueueTokenListRequest();
		request.setClinicSysId(12);

		String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		Date parsedDate = new Date();
		when(webServiceUtility.stringToDate(today)).thenReturn(parsedDate);
		when(queueTokenRepo.findTokensByFilters(eq(12), eq(parsedDate), isNull(), isNull(), isNull()))
				.thenReturn(List.of(new QueueTokenListItem(1, "SU-01", 1, "WAITING", parsedDate, 5, 9,
						"Geetha Govindan", "9999999999", 32, "F", null, null)));

		ResponseDto response = service.getTokens(request);

		assertEquals("SUCCESS", response.getStatus());
		assertEquals("Tokens fetched successfully", response.getMessage());
		assertEquals(1, ((List<?>) response.getData()).size());
	}

}
