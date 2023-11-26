package config;

import jdk.jfr.DataAmount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"services","repositories"})
public class ProjectConfig {

    @Bean
    public DataSource dataSource(){
        var dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/transactionalspring");
        dataSource.setUsername("springstudent");
        dataSource.setPassword("springstudent");
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource datasource)         //autowired happening here
    {
        return new JdbcTemplate(datasource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
       return new DataSourceTransactionManager(dataSource);
    }
}
