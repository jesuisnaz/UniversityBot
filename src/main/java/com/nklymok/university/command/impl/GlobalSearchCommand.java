package com.nklymok.university.command.impl;

import com.nklymok.university.command.UniversityCommand;
import com.nklymok.university.model.lector.Lector;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class GlobalSearchCommand extends UniversityCommand {

    private final String pattern;

    private final String NO_MATCH = "Not a single employee matched the pattern: ";

    public GlobalSearchCommand(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void execute() {
        List<Lector> employees = this.getLectorService().findByNamePattern(pattern);
        if (employees.isEmpty()) {
            this.getOutputUtils().printString(NO_MATCH + pattern);
        }
        else {
            this.getOutputUtils().printJoined(
                    employees.stream()
                            .map(Lector::getFullName)
                            .collect(Collectors.toList()), ", ");
        }
    }
}
