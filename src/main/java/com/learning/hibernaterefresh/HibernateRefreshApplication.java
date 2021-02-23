package com.learning.hibernaterefresh;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.learning.hibernaterefresh.entity.User;
import com.learning.hibernaterefresh.repository.UserRepository;

@SpringBootApplication
public class HibernateRefreshApplication implements CommandLineRunner {

	static ConfigurableApplicationContext context;

	@Autowired
	EntityRepo entityRepo;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		context = SpringApplication.run(HibernateRefreshApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		System.out.println(userRepository.getUserNameById(4l));
//		userRepository.save(new User(0, "New User", Timestamp.valueOf(LocalDateTime.now())));
//		userRepository.findByNameAsc("New User").forEach(System.out::println);
//		userRepository.findByName("New User", Sort.by("id").descending()).forEach(System.out::println);
//		userRepository.findByName("New User", PageRequest.of(0, 3)).forEach(System.out::println);
//		userRepository.findByNameGeneric("New User").forEach(System.out::println);
//		userRepository.findByNameIgnorecase("new user").forEach(System.out::println);
//		userRepository.findByNameByParam("New User").forEach(System.out::println);
		userRepository.addPrefixToName("JPA user", "Updated ");
//		System.out.println(entityRepo.getPostAndUpdateBySession(4l));
//		System.out.println(entityRepo.saveUser());
	}

}
