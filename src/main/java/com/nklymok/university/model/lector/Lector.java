package com.nklymok.university.model.lector;

import com.nklymok.university.model.Department;
import com.nklymok.university.model.Salary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lector")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "department_employee",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private List<Department> departments;

    @OneToMany(mappedBy = "employee")
    private List<Salary> salaries;

    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", degree=" + degree.name() +
                '}';
    }

    public double getSalaryFor(Long departmentId) {
        double result = 0d;

        for (Salary s : salaries) {
            if (s.getDepartmentId().equals(departmentId)) {
                result += s.getAmountOfMoney();
            }
        }
        return result;
    }
}
