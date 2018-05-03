package com.mwt.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    JdbcTemplate jdbcTemplate;
	
	@GetMapping("/")
	String home(ModelMap modal) {
		log.info("Initializing database");

		jdbcTemplate.execute("DROP TABLE customers");
        jdbcTemplate.execute("CREATE TABLE customers(id_customer VARCHAR(64), customer_label VARCHAR(255))");
        jdbcTemplate.execute("INSERT INTO customers(id_customer, customer_label) VALUES ('radu', 'Radu')");
        jdbcTemplate.execute("INSERT INTO customers(id_customer, customer_label) VALUES ('simo', 'Simo')");

		modal.put("customers", jdbcTemplate.query("SELECT * FROM customers", new MapMapper()));
		return "index";
	}
}
