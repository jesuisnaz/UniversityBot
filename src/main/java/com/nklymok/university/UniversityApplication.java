package com.nklymok.university;

import com.nklymok.university.service.DepartmentService;
import com.nklymok.university.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

    private Menu mainMenu;

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }


    @Override
    public void run(String... args) {
        mainMenu.start();
    }

    @Autowired
    public void setMainMenu(Menu mainMenu) {
        this.mainMenu = mainMenu;
    }
}
