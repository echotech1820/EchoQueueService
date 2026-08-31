package com.echotech.queue.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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

}
