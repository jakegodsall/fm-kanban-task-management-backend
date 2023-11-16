package com.jakegodsall.kanbantaskmanagerbackend.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class FlywayInitialiser implements CommandLineRunner {

    @Autowired
    private Flyway flyway;

    @Override
    public void run(String... args) throws Exception {
        flyway.clean();
        flyway.migrate();
    }
}
