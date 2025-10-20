package com.dpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.dpa.entity.DoctorMaster;
import com.dpa.vo.DoctorAppointmentSummaryVO;

import jakarta.persistence.QueryHint;

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
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "USE"),
			@QueryHint(name = "org.hibernate.readOnly", value = "true") })
	Page<DoctorAppointmentSummaryVO> getDoctorAppointmentSummaryWithPatientCountAndAppointmentCount(Pageable pagable);

	@Query("""
			SELECT d FROM DoctorMaster d
			WHERE d.fee > (SELECT AVG(d2.fee) FROM DoctorMaster d2)
			""")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "USE"),
			@QueryHint(name = "org.hibernate.readOnly", value = "true") })
	Page<DoctorMaster> findDoctorsWithAboveAverageFee(Pageable pagable);

	@Query("""
			SELECT d FROM DoctorMaster d
			WHERE (SELECT COUNT(a.id) FROM Appointment a WHERE a.doctorId = d.id) >= :count
			""")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "USE"),
			@QueryHint(name = "org.hibernate.readOnly", value = "true") })
	Page<DoctorMaster> getDoctorsHavingAtLeastNAppointments(int count, Pageable pagable);

	@Query("""
			SELECT d FROM DoctorMaster d
			LEFT JOIN Appointment a ON d.id = a.doctorId
			WHERE FUNCTION('DATE', a.bookedOn) BETWEEN :fromDate AND :toDate
			""")
	List<DoctorMaster> getDoctorsHavingAppointmentsBetweenDates(LocalDate fromDate, LocalDate toDate);

}
