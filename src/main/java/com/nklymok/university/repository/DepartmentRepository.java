package com.nklymok.university.repository;

import com.nklymok.university.model.Department;
import com.nklymok.university.model.lector.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByName(String name);

    @Query("SELECT COUNT(emp) FROM Department dep JOIN dep.employees emp WHERE dep.name=?1 AND emp.degree=?2")
    Integer countEmployeesByDegree(String name, Degree degree);

}
