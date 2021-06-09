package com.nklymok.university.model;

import com.nklymok.university.model.lector.Lector;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "department")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "head_id")
    private Long headId;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "department_employee",
                joinColumns = @JoinColumn(name = "department_id"),
                inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Lector> employees;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headId=" + headId +
                '}';
    }
}
