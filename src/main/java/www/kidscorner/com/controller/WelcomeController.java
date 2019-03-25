package www.kidscorner.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	
	

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "welcomePage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {

		return "login";
	}

	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public String getRegistration() {

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
	 
	/*
	 * @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="This is a wrong url")
	 * 
	 * @ExceptionHandler(Throwable.class) private void handleException(Throwable th,
	 * HttpServletRequest request) {
	 * 
	 * }
	 */
	 
}