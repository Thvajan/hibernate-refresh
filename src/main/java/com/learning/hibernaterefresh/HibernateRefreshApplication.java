package com.learning.hibernaterefresh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HibernateRefreshApplication implements CommandLineRunner {

	static ConfigurableApplicationContext context;

	@Autowired
	EntityRepo entityRepo;

	public static void main(String[] args) {
		context = SpringApplication.run(HibernateRefreshApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(entityRepo.getPostAndUpdateBySession(4l));
//		System.out.println(entityRepo.saveUser());
	}

}
