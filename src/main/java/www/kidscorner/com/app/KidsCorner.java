package www.kidscorner.com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class }) 
/*
 * @EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
 */
@ComponentScan(basePackages ={"www.kidscorner.com.repository", "www.kidscorner.com.controller", "www.kidscorner.com.app.WebSecurityConfig"
	,"www.kidscorner.com.exception.BadUrlExceptionHandler", "www.kidscorner.com.service", "www.kidscorner.com.domain"})
@EnableJpaRepositories(basePackages="www.kidscorner.com.repository")
@EntityScan(basePackages="www.kidscorner.com.domain")
public class KidsCorner {
	public static void main(String[] args) {
		SpringApplication.run(KidsCorner.class, args);
		
	}
}
