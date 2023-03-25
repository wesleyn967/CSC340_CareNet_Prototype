package com.csc340sp23.CareNet.patient;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sentini
 */
public interface PatientRepository extends JpaRepository<PatientInfo, Long> {

}
