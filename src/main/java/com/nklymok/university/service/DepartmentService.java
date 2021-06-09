package com.nklymok.university.service;

import com.nklymok.university.model.Department;
import com.nklymok.university.model.lector.Degree;

import java.util.List;

public interface DepartmentService {

    List<Department> findAll();

    Department findByName(String name);

    Department save(Department department);

    String getDeparmentHeadName(String departmentName);

    Integer getEmployeeCount(String departmentName);

    Integer countEmployeesByDegree(String departmentName, Degree degree);

    Double getAverageSalary(String departmentName);

}
