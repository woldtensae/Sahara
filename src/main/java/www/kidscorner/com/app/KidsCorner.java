package www.kidscorner.com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication /* (exclude = {SecurityAutoConfiguration.class }) */
@ComponentScan({"www.kidscorner.com.controller", "www.kidscorner.com.app.WebMvcConfig"})
public class KidsCorner {
	public static void main(String[] args) {
		SpringApplication.run(KidsCorner.class, args);
		
	}

}
