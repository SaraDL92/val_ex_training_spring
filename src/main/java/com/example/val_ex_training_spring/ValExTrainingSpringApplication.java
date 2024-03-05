package com.example.val_ex_training_spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.example.val_ex_training_spring.entity.DataUserEntity;
import com.example.val_ex_training_spring.entity.UserEntity;
import com.example.val_ex_training_spring.repository.DataUserRepository;
import com.example.val_ex_training_spring.repository.RatingRepository;
import com.example.val_ex_training_spring.repository.UserRepository;
import com.example.val_ex_training_spring.service.DataUserService;
import com.example.val_ex_training_spring.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class ValExTrainingSpringApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ValExTrainingSpringApplication.class, args);
	}
	
	    
}
