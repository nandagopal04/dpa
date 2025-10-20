package com.dpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dpa.entity.DoctorMaster;
import com.dpa.vo.DoctorAppointmentSummaryVO;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorMaster, String> {

	@Query("""
			SELECT new com.dpa.vo.DoctorAppointmentSummaryVO(
				d.id,
				d.name,
				d.gender,
				d.speciality,
				d.fee,
				COUNT(a.id),
				COUNT(DISTINCT a.patientId)
			) FROM DoctorMaster d RIGHT JOIN Appointment a ON d.id = a.doctorId
			LEFT JOIN Patient p ON a.patientId = p.id
			GROUP BY d.id, d.name, d.gender, d.speciality, d.fee
			""")
	Page<DoctorAppointmentSummaryVO> getDoctorAppointmentSummaryWithPatientCountAndAppointmentCount(Pageable pagable);

	@Query("""
			SELECT d FROM DoctorMaster d
			WHERE d.fee > (SELECT AVG(d2.fee) FROM DoctorMaster d2)
			""")
	Page<DoctorMaster> findDoctorsWithAboveAverageFee(Pageable pagable);
	
	@Query("""
			SELECT d FROM DoctorMaster d
			WHERE (SELECT COUNT(a.id) FROM Appointment a WHERE a.doctorId = d.id) >= :count
			""")
	Page<DoctorMaster> getDoctorsHavingAtLeastNAppointments(int count, Pageable pagable);

}
