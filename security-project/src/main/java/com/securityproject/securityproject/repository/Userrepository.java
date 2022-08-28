package com.securityproject.securityproject.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityproject.securityproject.model.Userclass;

public interface Userrepository extends JpaRepository<Userclass, Integer>{

	Optional<Userclass> findByUserName(String userName);
}
