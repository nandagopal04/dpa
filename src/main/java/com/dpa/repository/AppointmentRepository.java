package com.dpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dpa.dto.AppointmentViewDTO;
import com.dpa.entity.Appointment;
import com.dpa.vo.AppointmentSummaryVO;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String> {

	@Query("SELECT a FROM Appointment a WHERE FUNCTION('DATE', a.bookedOn) >= :startDate AND FUNCTION('DATE', a.bookedOn) <= :endDate")
	Page<Appointment> getAppointmentsBetweenDates(@Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate, Pageable pagable);

	@Query("""
			SELECT new com.dpa.vo.AppointmentSummaryVO(a.id,
													   a.doctorId,
													   a.patientId,
													   a.bookedOn,
													   d.name)
			FROM Appointment a INNER JOIN DoctorMaster d ON a.doctorId = d.id
			""")
	Page<AppointmentSummaryVO> getAllWithDoctorNames(Pageable pagable);

	@Query("""
			SELECT new com.dpa.dto.AppointmentViewDTO(a.id,
													  a.bookedOn,
													  d.id,
													  d.name,
													  p.id,
													  p.name)
			FROM Appointment a JOIN DoctorMaster d ON a.doctorId = d.id
			JOIN Patient p ON a.patientId = p.id
			""")
	List<AppointmentViewDTO> getAllAppointmentViews();

}
