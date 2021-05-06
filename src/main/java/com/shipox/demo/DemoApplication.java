package com.shipox.demo;

import com.shipox.demo.config.SwaggerConfig;
import com.shipox.demo.model.User;
import com.shipox.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@Import(SwaggerConfig.class)
@EnableAsync
public class DemoApplication {

	public static void main(String[] args) {

		final ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		final UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		final PasswordEncoder passwordEncoder = applicationContext.getBean(PasswordEncoder.class);
		User user = new User();
		user.setEnabled(true);
		user.setUsername("admin");
		user.setPassword(passwordEncoder.encode("admin"));
		user.setEmail("admin@admin.com");
		userRepository.save(user);
	}

}
