package de.waksh.aposoft;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import de.waksh.aposoft.controller.MainController;

public class ApoSoft {
    private ApoSoft() {
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(SpringConfiguration.class).headless(false)
                .run(args);

        MainController controller = ctx.getBean(MainController.class);
        // MainController controller = new MainController();
        controller.init();
    }

}
