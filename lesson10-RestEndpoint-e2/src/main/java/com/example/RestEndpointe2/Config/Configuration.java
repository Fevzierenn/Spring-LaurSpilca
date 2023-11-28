package com.example.RestEndpointe2.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@org.springframework.context.annotation.Configuration
public class Configuration {

    //JDBCTemplate'e inject edilebilir bu da bi yöntemdir.
//    @Autowired
//    private DataSource data;

    /*
    Spring boot'da JDBC API varken ilgili konfigürasyon bilgilerini başta istediği için properties dosyasında tanımını yapmış olduk.
    İstersek alttaki yöntemle kendimiz db'ye bağlantımızı sağlarız ya da spring boot'un bize sağladığı kolaylıkla properties
    dosyasında tanımlayıp alt kısmı yazmamıza gerek kalmaz ve spring boot bunu arka planda bizim için yapar.
     */
//    @Bean
//    public DataSource dataSource(){
//        var dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/lesson10");
//        dataSource.setUsername("springstudent");
//        dataSource.setPassword("springstudent");
//        return dataSource;
//    }


    @Bean       //context'e atıldı injection ile kullanılabilir(baska sınıflarda -> servis katmanında)
    public JdbcTemplate jdbcTemplate(DataSource source){        //autowired işlemi ile context'teki bean alındı ve inject edildi.
        return new JdbcTemplate(source);
    }
}
