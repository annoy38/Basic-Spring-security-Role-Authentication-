package com.securityproject.securityproject.configure;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.securityproject.securityproject.model.Userclass;

@SuppressWarnings("serial")
public class Myuserdetails implements UserDetails{

	@SuppressWarnings("unused")
	private String userName;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;
	
	public Myuserdetails(Userclass user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.authorities = Arrays.stream(user.getRole().split(","))
				           .map(SimpleGrantedAuthority::new)
				           .collect(Collectors.toList());
	}
	
	public Myuserdetails() {
		
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return active;
	}

}
