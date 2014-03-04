package de.waksh.aposoft;

import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Main class
 * 
 * @author Christoph Mende
 * 
 */
public class ApoSoft {

    private ApoSoft() {
    }

    /**
     * Main method that initializes the Spring ecosystem
     * 
     * @param args
     *            command-line args
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringConfiguration.class).headless(false).run(args);
    }

}
