package com.nklymok.university.command;

import com.nklymok.university.command.impl.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * CommandParser handles all the parsing for commands.
 * The only responsibility is to recognize (or define absense) and
 * return the needed implementation of Command.
 */
@Component
public class CommandParser {

    @Value("${university.command.placeholder.dept-name}")
    private String DEPT_NAME_PLACEHOLDER;
    @Value("${university.command.get-dept-head}")
    private String TMPLT_GET_DEPT_HEAD;
    @Value("${university.command.show-statistics}")
    private String TMPLT_SHOW_STATS;
    @Value("${university.command.show-avg-salary}")
    private String TMPLT_SHOW_AVG_SALARY;
    @Value("${university.command.show-employee-count}")
    private String TMPLT_SHOW_EMPLOYEE_COUNT;
    @Value("${university.command.global-search}")
    private String TMPLT_GLOBAL_SEARCH;

    public UniversityCommand parseCommand(String input) {
        if (input == null || input.isBlank()) return null;
        int inputLen = input.length();
        if (inputLen >= TMPLT_GET_DEPT_HEAD.length()) {
            if (input.startsWith(TMPLT_GET_DEPT_HEAD)) {
                return new ShowDepartmentHeadCommand(input.substring(TMPLT_GET_DEPT_HEAD.length()));
            }
        }
        if (inputLen >= TMPLT_GLOBAL_SEARCH.length()) {
            if (input.startsWith(TMPLT_GLOBAL_SEARCH)) {
                return new GlobalSearchCommand(input.substring(TMPLT_GLOBAL_SEARCH.length()));
            }
        }
        if (inputLen >= TMPLT_SHOW_EMPLOYEE_COUNT.length()) {
            if (input.startsWith(TMPLT_SHOW_EMPLOYEE_COUNT)) {
                return new ShowEmployeeCountCommand(input.substring(TMPLT_SHOW_EMPLOYEE_COUNT.length()));
            }
        }
        if (inputLen >= TMPLT_SHOW_AVG_SALARY.length()) {
            if (input.startsWith(TMPLT_SHOW_AVG_SALARY)) {
                return new ShowAverageDepartmentSalaryCommand(input.substring(TMPLT_SHOW_AVG_SALARY.length()));
            }
        }
        String[] args = TMPLT_SHOW_STATS.split(" ");
        if (input.startsWith(args[0]) && input.endsWith(args[2])) {
            input = input.replace(args[0], "").replace(args[2], "").trim();
            return new ShowDepartmentStatisticsCommand(input);
        }

        return null;
    }
}
