package www.kidscorner.com.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private DataSource dataSource;
	@Value("${spring.sql.users-query}")
	private String userQuery;
	@Value("${spring.sql.roles-query}")
	private String roleQuery;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(userQuery)
			.authoritiesByUsernameQuery(roleQuery)			
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
			.loginPage("/login")
			.failureUrl("/failuer")
			.defaultSuccessUrl("/home")
			.usernameParameter("username")
			.passwordParameter("password");
	}
	
	@Autowired
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/resources/**");
	}
}
