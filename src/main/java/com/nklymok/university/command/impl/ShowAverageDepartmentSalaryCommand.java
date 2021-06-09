package com.nklymok.university.command.impl;

import com.nklymok.university.command.UniversityCommand;

public class ShowAverageDepartmentSalaryCommand extends UniversityCommand {

    private final String departmentName;

    private final String RESPONSE_TEMPLATE = "The average salary of {department_name} is {average_salary}";
    private final String DEPT_NAME_PLACEHOLDER = "{department_name}";
    private final String AVG_SALARY_PLACEHOLDER = "{average_salary}";


    public ShowAverageDepartmentSalaryCommand(String name) {
        this.departmentName = name;
    }

    @Override
    public void execute() {
        double avgSalary = this.getDepartmentService().getAverageSalary(departmentName);
        String result = RESPONSE_TEMPLATE
                .replace(DEPT_NAME_PLACEHOLDER, departmentName)
                .replace(AVG_SALARY_PLACEHOLDER, String.valueOf(avgSalary));
        this.getOutputUtils().printString(result);
    }

}
