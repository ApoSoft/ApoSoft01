package de.waksh.aposoft;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Spring configuration
 * 
 * @author Christoph Mende
 * 
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringConfiguration {

    /**
     * DataSource configuration, returns a new HSQL in-memory database
     * 
     * @return
     */
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
    }

}
