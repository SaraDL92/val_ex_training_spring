package com.example.val_ex_training_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.val_ex_training_spring.entity.DataUserEntity;
import com.example.val_ex_training_spring.entity.UserEntity;
import com.example.val_ex_training_spring.repository.DataUserRepository;
import com.example.val_ex_training_spring.repository.UserRepository;
import com.example.val_ex_training_spring.service.DataUserService;
import com.example.val_ex_training_spring.service.UserService;

@SpringBootApplication
public class ValExTrainingSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValExTrainingSpringApplication.class, args);
	}

	@Autowired
	DataUserRepository dRepo;
	
	@Autowired
	DataUserService dService;
	
	@Autowired
	UserRepository uRepo;
	
	@Autowired
	UserService uService;
	
	UserEntity uE = new UserEntity("ciao@ciao.it", "12345");
	UserEntity i = uService.saveUser(uE);
	
}
