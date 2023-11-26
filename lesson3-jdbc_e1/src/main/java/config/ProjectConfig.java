package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "repositories")
public class ProjectConfig {

    @Bean
    public DataSource mysqlDataSource() {
        var dataSource = new DriverManagerDataSource();
        //dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/laurspilcaspring");
        dataSource.setUsername("springstudent");
        dataSource.setPassword("springstudent");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(mysqlDataSource());     //Jdbc temp. kullanılması için oncelikle DB'ye bağlanması gerekir onu da DataSource bean'i ile hallettik. Parametre olarak da halledilebilirdi

    }






}
