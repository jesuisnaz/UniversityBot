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
//            if (input.equals("getDs")) System.out.println(departmentService
//                    .findAll()
//                    .toString());
//            if (input.equals("getLs")) System.out.println(lectorService.findAll().toString());
//            if (input.startsWith("getEC ")) {
//                System.out.println("Employee count: " + departmentService.getEmployeeCount(input.substring(6)));
//            }
//            if (input.startsWith("getECD ")) {
//                String depName = input.substring(7);
//                System.out.println("Assistants: " + departmentService.countEmployeesByDegree(depName, Degree.ASSISTANT));
//                System.out.println("AP: " + departmentService.countEmployeesByDegree(depName, Degree.ASSOCIATE_PROFESSOR));
//                System.out.println("Professors: " + departmentService.countEmployeesByDegree(depName, Degree.PROFESSOR));
//            }
        }
    }
}
