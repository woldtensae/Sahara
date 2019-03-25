package www.kidscorner.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.kidscorner.com.domain.Role;
import www.kidscorner.com.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role getRole(String roleType) {
		return roleRepository.findByRoleType(roleType);
	}
}


