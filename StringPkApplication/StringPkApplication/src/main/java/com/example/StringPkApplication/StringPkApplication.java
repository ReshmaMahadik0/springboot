package com.example.StringPkApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StringPkApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringPkApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository) {
		return args -> {

			User user1 = new User();
			user1.setEmail("user1@gmail.com");
			user1.setName("user1");
			user1.setEnabled(true);

			User user2 = new User();
			user2.setEmail("user2@gmail.com");
			user2.setName("user2");
			user2.setEnabled(false);

			userRepository.save(user1);
			userRepository.save(user2);

			System.out.println("Users saved successfully!");
		};
	}

}
