package www.kidscorner.com.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import www.kidscorner.com.domain.Role;
import www.kidscorner.com.domain.User;
import www.kidscorner.com.repository.RoleRepository;
import www.kidscorner.com.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(UserRepository userRepository, 
			BCryptPasswordEncoder passwordencoder, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordencoder;
		this.roleRepository = roleRepository;
	}
	
	public void saveUser(User user, String roleType) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role = roleRepository.findByRoleType(roleType);
		Set<Role> roles = user.getRoles();
		roles.add(role);
		user.setRoles(roles);
		userRepository.save(user);
	}
}
