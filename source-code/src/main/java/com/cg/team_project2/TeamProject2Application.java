package com.cg.team_project2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TeamProject2Application {

    public static void main(String[] args) {
        SpringApplication.run(TeamProject2Application.class, args);
    }

}
