package com.jc.repository;

import com.jc.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    Optional<Employee> findByFullName(String fullName);

    Optional<Employee> findByFullNameOrBirthDate(String fullName, LocalDate birthDate);

    List<Employee> findAllbyBirthDateAfter(LocalDate birthDate);

    List<Employee> findAllbyBirthDateAfter(LocalDate min, LocalDate max);

    List<Employee> findAllbyMarriedTrue();

    List<Employee> findAllbyMarriedFalse();

}
