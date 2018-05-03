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
		log.info("loading page");
		modal.put("customers", jdbcTemplate.query("SELECT * FROM customers", new MapMapper()));
		return "index";
	}
}
