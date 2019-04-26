package www.sahara.com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication 
@ComponentScan(basePackages ={"www.sahara.com.repository", "www.sahara.com.controller", "www.sahara.com.app.WebSecurityConfig"
	,"www.sahara.com.exception.BadUrlExceptionHandler", "www.sahara.com.service", "www.sahara.com.domain",
	"www.sahara.com.app"})

@EntityScan("www.sahara.com.domain")
@EnableJpaRepositories(basePackages="www.sahara.com.repository")
public class Sahara {
	public static void main(String[] args) {
		SpringApplication.run(Sahara.class, args);	
	}
}
