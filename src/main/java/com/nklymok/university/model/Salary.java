package com.nklymok.university.model;

import com.nklymok.university.model.lector.Lector;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "salary")
@Getter
@Setter
@NoArgsConstructor
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Lector employee;

    @NotNull
    @Column(name = "department_id")
    private Long departmentId;

    @NotNull
    @Column(name = "amount")
    private Double amountOfMoney;

}
