package www.kidscorner.com.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="user_name")
	private String username;
	@Column(name="user_password")
	private String password;

	 @ManyToMany(fetch=FetchType.EAGER)
	 @JoinTable(name="user_role", joinColumns =
	 @JoinColumn(name="user_id"), inverseJoinColumns =
	 @JoinColumn(name="role_id"))
	 Set<Role> roles;
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Role> getRoles() { return roles; }
	public void setRoles(Set<Role>
	roles) { this.roles = roles; }
	 
	
	
}

