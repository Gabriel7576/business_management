package com.business_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business_management.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
