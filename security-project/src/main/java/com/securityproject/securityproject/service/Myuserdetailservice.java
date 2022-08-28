package com.securityproject.securityproject.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.securityproject.securityproject.configure.Myuserdetails;
import com.securityproject.securityproject.model.Userclass;
import com.securityproject.securityproject.repository.Userrepository;



@Service
public class Myuserdetailservice implements UserDetailsService{

	@Autowired
	Userrepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Userclass> user = userRepo.findByUserName(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: "+username));
		
		return user.map(Myuserdetails::new).get();
	}

}
