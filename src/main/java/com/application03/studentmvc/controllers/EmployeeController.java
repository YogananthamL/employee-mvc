package com.application03.studentmvc.controllers;

import com.application03.studentmvc.entity.Employee;
import com.application03.studentmvc.service.ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private ServiceImpl service;

    public EmployeeController(ServiceImpl service){
        this.service=service;
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Employee> employeeList=service.findAll();
        model.addAttribute("employees",employeeList);
        return "list-employees";
    }

    @GetMapping("/employeeForm")
    public String showForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "employeeForm";
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("employeeId") int employeeId,Model model){
        Employee employee=service.findById(employeeId);
        model.addAttribute("employee",employee);
        return "employeeForm";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        service.save(employee);
        return "redirect:/employees/list";
    }



    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int employeeId ){
        service.deleteById(employeeId);
        return "redirect:/employees/list";
    }

}
