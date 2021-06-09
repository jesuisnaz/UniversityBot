package com.nklymok.university.command.impl;

import com.nklymok.university.command.UniversityCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowEmployeeCountCommand extends UniversityCommand {

    private final String departmentName;

    public ShowEmployeeCountCommand(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public void execute() {
        int employeeCount = this.getDepartmentService().getEmployeeCount(departmentName);
        this.getOutputUtils().printString(String.valueOf(employeeCount));
    }
}
