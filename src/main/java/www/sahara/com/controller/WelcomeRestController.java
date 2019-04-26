package www.sahara.com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	@RequestMapping(value = "/welcomeRest", method = RequestMethod.GET)
	public String getWelcomeRest() {
		return "welcomePageRest";
	}
}
