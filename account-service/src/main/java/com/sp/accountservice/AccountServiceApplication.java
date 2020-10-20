package com.sp.accountservice;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories
@EnableFeignClients
@EnableEurekaClient
public class AccountServiceApplication {
	public static void main(String[] args)
	{


		//Query
		String query = "CREATE KEYSPACE springcloud WITH replication "
				+ "= {'class':'SimpleStrategy', 'replication_factor':1};";

		//creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

		//Creating Session object
		Session session = cluster.connect();

		//Executing the query
//		session.execute(query);

		//using the KeySpace
		session.execute("USE springcloud").toString();
		String den =  session.execute("SELECT * FROM hesap").one().toString();
		session.close();
		System.out.println(den);


		SpringApplication.run(AccountServiceApplication.class, args);
	}
}
