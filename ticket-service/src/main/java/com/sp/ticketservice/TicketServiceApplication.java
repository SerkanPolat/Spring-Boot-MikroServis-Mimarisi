package com.sp.ticketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLException;

/*
    Elasticsearch docker image fazla ram tuketiminden dolayi
    sistem uzerinden baslatildi..
 */


@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories
@EnableElasticsearchRepositories
public class TicketServiceApplication {


    public TicketServiceApplication()  {
    }

    public static void main (String[] args) throws SQLException {
      /*
        Statement stmt = null;
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "serkanpolat");
        stmt = conn.createStatement();
        String sql = "CREATE DATABASE mikroserviceapp";
        stmt.executeUpdate(sql);
        System.out.println("Database created successfully...");
        */

        SpringApplication.run(TicketServiceApplication.class,args);

    }
}
