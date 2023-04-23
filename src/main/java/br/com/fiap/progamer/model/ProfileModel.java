package br.com.fiap.progamer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Foi adicionada uma dependensy no pom.xml para melhorar a segurança da senha
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="DBE_CP_TB_PROFILE")
public class ProfileModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String profile;
	private String email;
	private String passwordHash;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "ProfileModel [name=" + name + ", profile=" + profile + ", email=" + email + "]";
	}

	public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.passwordHash = passwordEncoder.encode(password);
    }

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}

