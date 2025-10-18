package com.dpa.repository;

import java.util.List;

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
	List<DoctorAppointmentSummaryVO> getDoctorAppointmentSummaryWithPatientCountAndAppointmentCount();

	@Query("""
			SELECT d FROM DoctorMaster d
			WHERE d.fee > (SELECT AVG(d2.fee) FROM DoctorMaster d2)
			""")
	List<DoctorMaster> findDoctorsWithAboveAverageFee();
	
	@Query("""
			SELECT d FROM DoctorMaster d
			WHERE (SELECT COUNT(a.id) FROM Appointment a WHERE a.doctorId = d.id) >= :count
			""")
	List<DoctorMaster> getDoctorsHavingAtLeastNAppointments(int count);

}
