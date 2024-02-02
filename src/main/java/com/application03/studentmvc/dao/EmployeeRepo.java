package com.application03.studentmvc.dao;

import com.application03.studentmvc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
