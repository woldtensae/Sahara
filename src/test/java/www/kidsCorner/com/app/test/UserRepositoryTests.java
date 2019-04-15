package www.kidsCorner.com.app.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import www.kidscorner.com.domain.Role;
import www.kidscorner.com.domain.User;
import www.kidscorner.com.repository.RoleRepository;
import www.kidscorner.com.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
	public static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTests.class);
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	User user = new User();
	
	@Before
	public void inti() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		user.setUsername("kebede");
		user.setPassword(passwordEncoder.encode("kebede123"));
		
		Role role = new Role();
		role.setRoleType("ROLE_USER");
		entityManager.persistAndFlush(role);
		
		Role foundRole = roleRepository.findByRoleType("ROLE_USER");		
		user.setRoles(new HashSet<Role>(Arrays.asList(foundRole)));

		entityManager.persistAndFlush(user);

	}
	
	@Test
	public void saveUserTest() {
		
		User found = userRepository.findByUsername("kebede");
		assertEquals(user.getUsername(),found.getUsername());
	}
	
	@Test
	public void seeIds() {
		Long[] userIds = {new Long(2)};
		List<Optional<User>> listOfUsers = Stream.of(userIds)
				.map(userRepository::findById)
				.collect(Collectors.toList());
		assertEquals(listOfUsers.size(), 1);
	}
}
