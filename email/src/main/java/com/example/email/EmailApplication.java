package com.example.email;

import com.example.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class EmailApplication implements CommandLineRunner {
    private final EmailService emailService;
	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        emailService.prepareAndSendEmail();
    }
}
