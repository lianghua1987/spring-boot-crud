package com.hua.springboot.controller;

import com.hua.springboot.dao.DepartmentDao;
import com.hua.springboot.dao.EmployeeDao;
import com.hua.springboot.entities.Department;
import com.hua.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String getEmployees(Model model){
        Collection<Employee> emps = employeeDao.getAll();

        model.addAttribute("emps", emps);

        //thymeleaf search classpath:templates - emp/list
        return "emp/list";
    }


    @PostMapping("/emp")
    public String add(Employee emp){
        employeeDao.save(emp);
        System.out.println(emp.toString());

        return "redirect:/emps";
    }


    @PutMapping("/emp")
    public String edit(Employee employee){
        System.out.println(employee.toString());
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp")
    public String add(Model model){
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts", depts);
        return "emp/add";
    }


    @GetMapping("/emp/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts", depts);
        return "emp/add";
    }


    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
