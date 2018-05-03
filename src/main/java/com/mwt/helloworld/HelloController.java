package com.mwt.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	private static final Logger log = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	@Qualifier("musicJdbcTemplate")
	JdbcTemplate musicJdbcTemplate;

	@Autowired
	@Qualifier("music2JdbcTemplate")
	JdbcTemplate music2JdbcTemplate;
	
	@GetMapping("/")
	String home(ModelMap modal) {
		log.info("loading page");
		modal.put("customers", musicJdbcTemplate.query("SELECT * FROM customers", new MapMapper()));
		modal.put("customers2", music2JdbcTemplate.query("SELECT * FROM customers", new MapMapper()));
		return "index";
	}
}
