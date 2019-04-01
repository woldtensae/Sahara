package www.kidscorner.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import www.kidscorner.com.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
	Role findByRoleType(String roleType);
}
 