package com.tricon.EmailSchedularService;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DBConfig {
	
	@Value("${spring.mysql.jdbcUrl}")
	String url;
	
	@Value("${spring.mysql.username}")
	String username;
	
	@Value("${spring.mysql.driverClassName}")
	String driverClassName;
	
	@Value("${DB_PASSWORD}")
	String password;
	
	@Bean(name = "mysqlDb")
	@Primary
	public DataSource mysqlDataSource() {
		    return DataSourceBuilder
		        .create()
		        .username(username)
		        .password(password)
		        .url(url)
		        .driverClassName(driverClassName)
		        .build();
	}

	@Bean(name = "mysqlJdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("mysqlDb") DataSource dsMySQL) {
		return new JdbcTemplate(dsMySQL);
	}
}