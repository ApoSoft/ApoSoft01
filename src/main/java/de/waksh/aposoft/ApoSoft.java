package de.waksh.aposoft;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class ApoSoft {
    private ApoSoft() {
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringConfiguration.class).headless(false).run(args);
    }

}
