package de.waksh.aposoft;

import org.springframework.boot.SpringApplication;

import de.waksh.aposoft.controller.MainController;

public class ApoSoft {
    private ApoSoft() {
    }

    public static void main(String[] args) {
        MainController controller = new MainController();
        controller.init();

        SpringApplication.run(SpringConfiguration.class, args);
    }

}
