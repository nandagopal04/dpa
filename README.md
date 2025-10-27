****🧩 Project Name: Doctor–Patient Appointment System (JPQL & MapStruct Practice)****

**🧠 Objective**

This project was designed to understand and implement advanced JPQL queries and MapStruct mappings within a real-world relational model of doctors, patients, and appointments.
It demonstrates mastery of JPQL joins, subqueries, projections, DTO mapping, and caching — commonly used in enterprise-grade Spring Boot applications.

**⚙️ Tech Stack**

Backend: Spring Boot, Spring Data JPA

Database: MySQL

ORM / Query Language: JPQL (Java Persistence Query Language)

Mapper: MapStruct

Build Tool: Maven

Language: Java 17

**🧱 Database Design**

The system consists of three main tables:

DoctorMaster — stores doctor details such as name, speciality, fee, and gender.

Patient — maintains patient information like name, DOB, gender, height, and weight.

Appointment — links doctors and patients, tracking booked appointments and timestamps.

Each appointment references both a doctor and a patient through foreign keys.

**🔍 Key Learning Modules**
1. JPQL Queries

INNER JOIN: Fetch all appointments with their respective doctor names.

LEFT JOIN: Retrieve all patients with or without appointments.

RIGHT JOIN: Get all doctors, including those with no patients.

Multiple Joins: Fetch doctor name, patient name, and appointment date in one query.

Subqueries:

Doctors with fees above the average doctor fee.

Doctors having at least one appointment (EXISTS).

Patients booked with more than two different doctors.

Expressions & Functions: Patients older than 40 using (CURRENT_DATE - dob).

Pagination: Fetch patients in batches of 20 for performance optimization.

Query Optimization: Retrieve only required fields (IDs, names, etc.) instead of full entities.

Query Hints: Cache doctor data for repeated access.

Filtering: Fetch doctors with appointments within the next 7 days or patients with appointments in a given month.

2. Projections & DTO Mapping

Constructor Expressions:

DoctorSummaryDTO(id, name, speciality)

AppointmentDetailsDTO(doctorName, patientName, bookedOn)

Nested DTO:

AppointmentViewDTO(appointmentId, bookedOn, doctor(doctorId, doctorName), patient(patientId, patientName))

Spring Data Projection Interfaces:

For lightweight data views like patient name and DOB.

3. MapStruct Integration

Mapped DoctorMaster → DoctorSummaryDTO using MapStruct.

Created nested mappers to map Appointment → AppointmentViewDTO with embedded doctor and patient data.

Combined multiple entities into a custom reporting DTO to simulate real-world data reporting use cases.

**🚀 Outcome / Learning**

This project solidified practical understanding of:

Writing and optimizing JPQL queries for complex business use cases.

Using MapStruct for clean, maintainable DTO mapping without manual boilerplate.

Designing entity relationships and DTO structures used in enterprise-grade backend systems.

Implementing pagination, caching, and projection-based optimizations for high performance.
