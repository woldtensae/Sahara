package www.sahara.com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.sahara.com.domain.Role;
import www.sahara.com.repository.RoleRepository;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role getRole(String roleType) {
		return roleRepository.findByRoleType(roleType);
	}
}


