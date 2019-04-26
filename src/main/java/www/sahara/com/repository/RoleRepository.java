package www.sahara.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import www.sahara.com.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
	Role findByRoleType(String roleType);
}
 