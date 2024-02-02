package com.application03.studentmvc.service;

import com.application03.studentmvc.entity.Employee;

import java.util.List;

public interface Service {

    public List<Employee> findAll();

    public Employee findById(int id);
    public void save(Employee employee);


    public void deleteById(int id);

}
