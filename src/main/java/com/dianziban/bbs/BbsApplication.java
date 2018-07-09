package com.dianziban.bbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.jdbc.Sql;

@SpringBootApplication
@Sql("/init-schema.sql")
public class BbsApplication {
    public static void main(String[] args) {
        SpringApplication.run(BbsApplication.class, args);
    }
}
