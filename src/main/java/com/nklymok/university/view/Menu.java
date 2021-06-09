package com.nklymok.university.view;

import com.nklymok.university.command.CommandParser;
import com.nklymok.university.command.UniversityCommand;
import com.nklymok.university.service.DepartmentService;
import com.nklymok.university.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {

    private final DepartmentService departmentService;
    private final LectorService lectorService;
    private final CommandParser parser;
    private final OutputUtils output;
    private final Scanner sc;

    @Value("${university.command.not-implemented}")
    private String CMD_NOT_IMPLEMENTED;

    @Autowired
    public Menu(DepartmentService departmentService, LectorService lectorService,
                OutputUtils output, CommandParser parser) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
        this.output = output;
        this.parser = parser;
        sc = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            String input = sc.nextLine();
            UniversityCommand command = parser.parseCommand(input);
            if (command == null) {
                output.printString(CMD_NOT_IMPLEMENTED);
                continue;
            }
            command.setDepartmentService(departmentService);
            command.setLectorService(lectorService);
            command.setOutputUtils(output);
            command.execute();
        }
    }
}
