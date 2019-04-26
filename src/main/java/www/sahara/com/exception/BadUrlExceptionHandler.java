package www.sahara.com.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages = "www.kidscorner.com.controller.WelcomeController")
public class BadUrlExceptionHandler {
	public static final Logger LOGGER = LoggerFactory.getLogger(BadUrlExceptionHandler.class);

	//@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason="bad request URL........")
	@ExceptionHandler(Throwable.class)
	 public ModelAndView handleError(HttpServletRequest request, 
			Throwable  ex) {
		LOGGER.info("========================================");
		LOGGER.error("Request: " + request.getRequestURL() + "rasied: " + ex);
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("request", request.getRequestURL());
		mav.setViewName("error");
	    return mav;
	 }
}
