package www.sahara.com.app;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import www.sahara.com.domain.Role;
import www.sahara.com.domain.User;


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
		Collection<GrantedAuthority> rolesAsGrandAuthority = new HashSet<GrantedAuthority>();
		Set<Role> rolesAsSet = user.getRoles();
		rolesAsSet.forEach((e) -> {
			rolesAsGrandAuthority.add(new SimpleGrantedAuthority(e.getRoleType()));
		});
		return rolesAsGrandAuthority;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
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
