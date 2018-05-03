package com.mwt.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringbootHelloWorldApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SpringbootHelloWorldApplication.class);

    public static void main(String[] args) {
		SpringApplication.run(SpringbootHelloWorldApplication.class, args);
	}

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void run(String... strings) throws Exception {

        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(id_customer VARCHAR(64), customer_label VARCHAR(255))");
        jdbcTemplate.execute("INSERT INTO customers(id_customer, customer_label) VALUES ('radu', 'Radu')");
        jdbcTemplate.execute("INSERT INTO customers(id_customer, customer_label) VALUES ('simo', 'Simo')");
        
    }
}
