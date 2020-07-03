package com.scrum.bookexchange;

import com.scrum.bookexchange.book.entity.Book;
import com.scrum.bookexchange.book.entity.BookOption;
import com.scrum.bookexchange.book.entity.Image;
import com.scrum.bookexchange.book.repos.BookRepos;
import com.scrum.bookexchange.book.repos.ImageRepos;
import com.scrum.bookexchange.book.repos.OptionRepos;
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
	private final BookRepos bookRepos;
	private final ImageRepos imageRepos;
	private final OptionRepos optionRepos;

	private final PasswordEncoder encoder;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User defaultUser = User.builder()
				.email("user@gmail.com")
				.schoolName("HCMUT")
				.phoneNumber("01234567890")
				.studentId("1711096")
				.password(encoder.encode("user"))
				.fullName("Nguyen Van A")
				.active(true)
				.role("USER")
				.avatarPath("/test")
				.build();

		defaultUser = repos.save(defaultUser);
	}
	
}