package com.nklymok.university.command.impl;

import com.nklymok.university.command.UniversityCommand;
import com.nklymok.university.model.lector.Degree;

public class ShowDepartmentStatisticsCommand extends UniversityCommand {

    private final String departmentName;

    private final String RESPONSE_TEMPLATE = "assistants - {assistants_count}\n" +
                                             "associate professors - {associate_professors_count}\n" +
                                             "professors - {professors_count}";

    private final String ASSISTANTS_COUNT_PLACEHOLDER= "{assistants_count}";
    private final String A_P_COUNT_PLACEHOLDER= "{associate_professors_count}";
    private final String PROFESSORS_COUNT_PLACEHOLDER= "{professors_count}";

    public ShowDepartmentStatisticsCommand(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public void execute() {
        int assistantsCount = this.getDepartmentService().countEmployeesByDegree(departmentName, Degree.ASSISTANT);
        int ACsCount = this.getDepartmentService().countEmployeesByDegree(departmentName, Degree.ASSOCIATE_PROFESSOR);
        int ProfessorsCount = this.getDepartmentService().countEmployeesByDegree(departmentName, Degree.PROFESSOR);
        String result = RESPONSE_TEMPLATE
                .replace(ASSISTANTS_COUNT_PLACEHOLDER, String.valueOf(assistantsCount))
                .replace(A_P_COUNT_PLACEHOLDER, String.valueOf(ACsCount))
                .replace(PROFESSORS_COUNT_PLACEHOLDER, String.valueOf(ProfessorsCount));
        this.getOutputUtils().printString(result);
    }

}
