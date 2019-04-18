package www.kidscorner.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import www.kidscorner.com.domain.Product;
import www.kidscorner.com.domain.User;
import www.kidscorner.com.service.UserService;

@Controller
public class WelcomeController {
	public static final Logger LOGGER = LoggerFactory.getLogger(WelcomeController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "welcomePage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {

		return "login";
	}
	
	@RequestMapping("/getProducts")
	public void getProducts() {
		RestTemplate restTamplate = new RestTemplate();
		Product product = restTamplate.getForObject("http://localhost:8081/saveProduct", Product.class);
		LOGGER.info("===========================");
		LOGGER.info(product.toString());
		LOGGER.info("===========================");
		
	}

	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public String getRegistration() {
		User user = new User();
		user.setUsername("aman");
		user.setPassword("amanest");
		
		
		User admin = new User();
		admin.setUsername("henok");
		admin.setPassword("henokest");
		
		
		userService.saveUser(user, "user");
		userService.saveUser(admin, "admin");
		return "reg";
		
	}

	@RequestMapping(value = "user/welcome", method = RequestMethod.GET)
	public String getUserWelcome() {
		return "userWelcome";
	}

	@RequestMapping(value = "admin/welcome", method = RequestMethod.GET)
	public String getAdminWelcome() {
		return "adminWelcome";
	}

	@RequestMapping(value = "/ex", method = RequestMethod.GET)
	public String exeception() throws Throwable{
		throw new Throwable("testing controller advice class");
	}
	 
}