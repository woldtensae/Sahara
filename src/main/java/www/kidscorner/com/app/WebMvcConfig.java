package www.kidscorner.com.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebMvcConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private DataSource dataSource;
	@Value("${spring.sql.users-query}")
	private String userQuery;
	@Value("${spring.sql.roles-query}")
	private String roleQuery;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.usersByUsernameQuery(userQuery)
			.authoritiesByUsernameQuery(roleQuery)
			.dataSource(dataSource)
			.passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("user/**").hasRole("USER")
			.antMatchers("admin/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and().csrf().disable()
			.formLogin()
			.failureUrl("/failuer")
			.defaultSuccessUrl("/home")
			.usernameParameter("username")
			.passwordParameter("password");
	}
	
	
}
