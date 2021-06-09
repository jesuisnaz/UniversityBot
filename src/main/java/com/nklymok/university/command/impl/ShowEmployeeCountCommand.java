package com.nklymok.university.command.impl;

import com.nklymok.university.command.UniversityCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowEmployeeCountCommand extends UniversityCommand {

    private final String departmentName;

    private final String DEPT_NOT_FOUND = "Department not found: ";

    public ShowEmployeeCountCommand(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public void execute() {
        if (this.getDepartmentService().findByName(departmentName) == null) {
            this.getOutputUtils().printString(DEPT_NOT_FOUND + departmentName);
            return;
        }

        int employeeCount = this.getDepartmentService().getEmployeeCount(departmentName);
        this.getOutputUtils().printString(String.valueOf(employeeCount));
    }
}
