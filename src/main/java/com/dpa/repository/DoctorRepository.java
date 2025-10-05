package com.dpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dpa.entity.DoctorMaster;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorMaster, String> {

}
