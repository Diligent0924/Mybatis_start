package com.example;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;

@Configuration
public class DataSourceConfig{
	@ConfigurationProperties(prefix = "spring.datasource")
	
	@Bean
	DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}