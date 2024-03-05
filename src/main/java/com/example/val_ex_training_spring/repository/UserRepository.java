package com.example.val_ex_training_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.val_ex_training_spring.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findByEmail(String email);
}
