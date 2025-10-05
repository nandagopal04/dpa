package com.dpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dpa.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

}
