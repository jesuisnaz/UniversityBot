package com.nklymok.university.command;

import com.nklymok.university.service.DepartmentService;
import com.nklymok.university.service.LectorService;
import com.nklymok.university.view.OutputUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UniversityCommand implements Command {

    private DepartmentService departmentService;
    private LectorService lectorService;
    private OutputUtils outputUtils;

}
