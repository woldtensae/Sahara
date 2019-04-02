package www.kidscorner.com.app;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class KidsCornerSucessHandler implements AuthenticationSuccessHandler{
	public static final Logger LOGGER = LoggerFactory.getLogger(KidsCornerSucessHandler.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		boolean hasUserRole = false;
		boolean hasAdminRole = false;
		 for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
				hasUserRole = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				hasAdminRole = true;
				break;
			}
		}
		if(hasUserRole) {
			response.sendRedirect("user/welcome");
		}else if(hasAdminRole) {
			response.sendRedirect("admin/welcome");
		}else {
			response.sendRedirect("/login");
		}
		
	}

}
