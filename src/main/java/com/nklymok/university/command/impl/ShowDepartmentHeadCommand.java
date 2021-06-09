package com.nklymok.university.command.impl;

import com.nklymok.university.command.UniversityCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowDepartmentHeadCommand extends UniversityCommand {

    private final String departmentName;

    private final String RESPONSE_TEMPLATE = "Head of {department_name} department is ";
    private final String HEAD_DEPT_PLACEHOLDER = "{department_name}";

    private final String DEPT_NOT_FOUND = "Department not found: ";

    public ShowDepartmentHeadCommand(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public void execute() {
        if (this.getDepartmentService().findByName(departmentName) == null) {
            this.getOutputUtils().printString(DEPT_NOT_FOUND + departmentName);
            return;
        }

        String result = RESPONSE_TEMPLATE.replace(HEAD_DEPT_PLACEHOLDER, departmentName) +
                this.getDepartmentService().getDeparmentHeadName(departmentName);
        this.getOutputUtils().printString(result);
    }
}
