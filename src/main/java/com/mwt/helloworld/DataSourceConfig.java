package com.mwt.helloworld;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {

	@Bean
	@Qualifier("musicDataSource")
	@Primary
	@ConfigurationProperties(prefix="music.datasource")
	DataSource customerDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@Qualifier("music2DataSource")
	@ConfigurationProperties(prefix="music2.datasource")
	DataSource productDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@Qualifier("musicJdbcTemplate")
	JdbcTemplate musicJdbcTemplate(@Qualifier("musicDataSource")DataSource musicDataSource) {
		return new JdbcTemplate(musicDataSource);
	}
	
	@Bean
	@Qualifier("music2JdbcTemplate")
	JdbcTemplate music2JdbcTemplate(@Qualifier("music2DataSource")DataSource music2DataSource) {
		return new JdbcTemplate(music2DataSource);
	}
}