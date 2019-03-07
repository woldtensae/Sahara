package www.kidscorner.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET )
	public String welcome(@RequestParam("name") String name, 
			Model model) {
		model.addAttribute("name", name);
		return "welcomePage";
	}
}
