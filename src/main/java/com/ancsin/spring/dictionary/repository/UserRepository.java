package com.ancsin.spring.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ancsin.spring.dictionary.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
