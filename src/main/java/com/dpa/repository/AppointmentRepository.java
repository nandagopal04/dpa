package com.dpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dpa.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String> {

	@Query("SELECT a FROM Appointment a WHERE FUNCTION('DATE', a.bookedOn) >= :startDate AND FUNCTION('DATE', a.bookedOn) <= :endDate")
	List<Appointment> getAppointmentsBetweenDates(@Param("startDate") LocalDate startDate,
												  @Param("endDate") LocalDate endDate);

}
