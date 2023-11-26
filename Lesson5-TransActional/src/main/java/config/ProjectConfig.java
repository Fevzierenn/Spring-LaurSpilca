package config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"repositories","services"} )
public class ProjectConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource db = new DriverManagerDataSource();
		db.setUrl("jdbc:mysql://localhost:3306/transactionalspring");
		db.setUsername("springstudent");
		db.setPassword("springstudent");
		return db;
	}
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());		//we called the bean handly.
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {		//spring automatically wired the dataSource bean
		return new DataSourceTransactionManager(dataSource);
	}
}
