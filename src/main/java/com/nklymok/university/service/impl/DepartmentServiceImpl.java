package com.nklymok.university.service.impl;

import com.nklymok.university.model.Department;
import com.nklymok.university.model.lector.Degree;
import com.nklymok.university.model.lector.Lector;
import com.nklymok.university.repository.DepartmentRepository;
import com.nklymok.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Value("${university.service.dept.dept-not-found}")
    private String DEPARTMENT_NOT_FOUND;
    @Value("${university.service.dept.dept-head-not-found}")
    private String DEPARTMENT_HEAD_NOT_FOUND;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Department> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public String getDeparmentHeadName(String departmentName) {
        Department department = repository.findByName(departmentName);
        if (department == null) throw new NoSuchElementException(DEPARTMENT_NOT_FOUND + departmentName);
        Long headId = department.getHeadId();
        List<Lector> lectors = department.getEmployees();

        for (Lector l : lectors) {
            if (l.getId().equals(headId)) return l.getFullName();
        }
        throw new NoSuchElementException(DEPARTMENT_HEAD_NOT_FOUND);
    }

    @Transactional
    @Override
    public Integer getEmployeeCount(String departmentName) {
        return repository.findByName(departmentName).getEmployees().size();
    }

    @Override
    public Department save(Department department) {
        return repository.save(department);
    }

    @Override
    public Integer countEmployeesByDegree(String departmentName, Degree degree) {
        return repository.countEmployeesByDegree(departmentName, degree);
    }

    @Override
    @Transactional
    public Double getAverageSalary(String departmentName) {
        double result = 0d;
        Department department = repository.findByName(departmentName);
        List<Lector> employees = department.getEmployees();

        for (Lector emp : employees) {
            result += emp.getSalaryFor(department.getId());
        }
        return result / employees.size();
    }
}
