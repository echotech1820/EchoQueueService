package com.echotech.queue.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.echotech.queue.dto.QueueTokenListItem;
import com.echotech.queue.model.QueueToken;

@Repository
public interface QueueTokenRepository extends JpaRepository<QueueToken, Integer> {
	
	@Query("""
		    SELECT MAX(q.qutSeqNo)
		    FROM QueueToken q
		    WHERE q.qutClinSysId = :clinicSysId
		      AND q.qutTokenDate = :tokenDate
		""")
		Integer findMaxSequence(
		        @Param("clinicSysId") Integer clinicSysId,
		        @Param("tokenDate") Date tokenDate
		);

	@Query("""
		    SELECT new com.echotech.queue.dto.QueueTokenListItem(
		        t.qutSysId,
		        t.qutTokenNo,
		        t.qutSeqNo,
		        t.qutStatus,
		        t.qutTokenDate,
		        t.qutDocSysId,
		        p.ptntSysId,
		        p.ptntFullName,
		        p.ptntMobileNumber,
		        p.ptntAge,
		        p.ptntGender,
		        t.qutCheckInTime,
		        t.qutCreatedAt
		    )
		    FROM QueueToken t, PatientMaster p
		    WHERE t.qutPtntSysId = p.ptntSysId
		      AND t.qutClinSysId = :clinicSysId
		      AND (:tokenDate IS NULL OR t.qutTokenDate = :tokenDate)
		      AND (:status IS NULL OR LOWER(t.qutStatus) = LOWER(:status))
		      AND (:doctorSysId IS NULL OR t.qutDocSysId = :doctorSysId)
		      AND (
		            :search IS NULL
		            OR LOWER(p.ptntFullName) LIKE LOWER(CONCAT('%', :search, '%'))
		            OR p.ptntMobileNumber LIKE CONCAT('%', :search, '%')
		          )
		    ORDER BY t.qutSeqNo ASC, t.qutCreatedAt ASC
		""")
	List<QueueTokenListItem> findTokensByFilters(
			@Param("clinicSysId") Integer clinicSysId,
			@Param("tokenDate") Date tokenDate,
			@Param("status") String status,
			@Param("doctorSysId") Integer doctorSysId,
			@Param("search") String search
	);

}
