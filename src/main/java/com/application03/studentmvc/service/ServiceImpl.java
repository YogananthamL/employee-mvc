package com.application03.studentmvc.service;

import com.application03.studentmvc.dao.EmployeeRepo;
import com.application03.studentmvc.entity.Employee;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    private EmployeeRepo repo;

    public ServiceImpl(EmployeeRepo repo){
        this.repo=repo;
    }
    @Override
    public List<Employee> findAll() {
        return repo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> optional=repo.findById(id);
        Employee employee=optional.get();
        return employee;
    }

    @Override
    public void save(Employee employee) {
        repo.save(employee);
    }


    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
