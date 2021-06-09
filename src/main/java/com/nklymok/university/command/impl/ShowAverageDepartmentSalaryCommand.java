package com.nklymok.university.command.impl;

import com.nklymok.university.command.UniversityCommand;
import com.nklymok.university.model.Department;

public class ShowAverageDepartmentSalaryCommand extends UniversityCommand {

    private final String departmentName;

    private final String RESPONSE_TEMPLATE = "The average salary of {department_name} is {average_salary}";
    private final String DEPT_NAME_PLACEHOLDER = "{department_name}";
    private final String AVG_SALARY_PLACEHOLDER = "{average_salary}";

    private final String DEPT_NOT_FOUND = "Department not found: ";


    public ShowAverageDepartmentSalaryCommand(String name) {
        this.departmentName = name;
    }

    @Override
    public void execute() {
        if (this.getDepartmentService().findByName(departmentName) == null) {
            this.getOutputUtils().printString(DEPT_NOT_FOUND + departmentName);
            return;
        }

        double avgSalary = this.getDepartmentService().getAverageSalary(departmentName);
        String result = RESPONSE_TEMPLATE
                .replace(DEPT_NAME_PLACEHOLDER, departmentName)
                .replace(AVG_SALARY_PLACEHOLDER, String.valueOf(avgSalary));
        this.getOutputUtils().printString(result);
    }

}
