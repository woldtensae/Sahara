package www.kidscorner.com.app;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import www.kidscorner.com.domain.User;


public class MyUserPrincipal  implements UserDetails {
	

	private static final long serialVersionUID = 1L;
	private User user;
	
	public MyUserPrincipal(User user) {
		this.user = user;
	}

	
	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public String getPassword() {
		return user.getPassword();
	}



	@Override
	public String getUsername() {
		return user.getUsername();
	}

}
