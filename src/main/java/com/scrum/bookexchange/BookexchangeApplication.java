package com.scrum.bookexchange;

import com.scrum.bookexchange.security.entity.User;
import com.scrum.bookexchange.security.repos.UserRepos;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@SpringBootApplication
public class BookexchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookexchangeApplication.class, args);
	}

}

@Component
@AllArgsConstructor
class BookExchangeRunner implements ApplicationRunner {

	private final UserRepos repos;

	private final PasswordEncoder encoder;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User defaultUser = User.builder()
				.username("user")
				.password(encoder.encode("user"))
				.fullName("Nguyen Van A")
				.active(true)
				.role("USER")
				.build();
		repos.save(defaultUser);
	}
	
}