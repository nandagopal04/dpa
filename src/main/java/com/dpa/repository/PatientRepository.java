package com.dpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dpa.entity.Patient;
import com.dpa.vo.PatientAppointmentSummaryVO;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

	@Query("""
			SELECT new com.dpa.vo.PatientAppointmentSummaryVO(
				p.id,
				p.name,
				p.dob,
				p.gender,
				p.weight,
				p.height,
				COUNT(a.id))
			FROM Patient p LEFT JOIN Appointment a ON p.id = a.patientId
			GROUP BY p.id, p.name, p.dob, p.gender, p.weight, p.height
			""")
	Page<PatientAppointmentSummaryVO> getAllPatientsWithAppointmentCount(Pageable pagable);

	@Query("""
			SELECT p FROM Patient p
			Where timestampdiff(YEAR, p.dob, CURRENT_DATE) > :age
			""")
	Page<Patient> getPatientsGreaterThanAge(Integer age, Pageable pagable);
	
	@Query("""
			SELECT p FROM Patient p
			WHERE p.id IN(SELECT a.patientId FROM Appointment a
			GROUP BY a.patientId HAVING COUNT(DISTINCT a.doctorId) = 2)
			""")
	Page<Patient> getPatientsBookedTwoDoctors(Pageable pagable);

}
