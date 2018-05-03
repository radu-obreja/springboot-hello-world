package com.mwt.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;
	
	@GetMapping("/")
	String home(ModelMap modal) {
		modal.put("customers", jdbcTemplate.query("SELECT * FROM customers", new MapMapper()));
		return "index";
	}
}
