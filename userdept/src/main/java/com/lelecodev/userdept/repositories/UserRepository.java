package com.lelecodev.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lelecodev.userdept.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}
