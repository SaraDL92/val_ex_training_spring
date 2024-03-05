package com.example.val_ex_training_spring.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.val_ex_training_spring.entity.ParagraphEntity;
import com.example.val_ex_training_spring.entity.RatingEntity;
import com.example.val_ex_training_spring.entity.UserEntity;
import com.example.val_ex_training_spring.service.ParagraphService;
import com.example.val_ex_training_spring.service.RatingService;
import com.example.val_ex_training_spring.service.UserService;

@Component
public class Runner implements ApplicationRunner {

	@Autowired
	RatingService rservice;
	@Autowired
	ParagraphService pservice;
	@Autowired
	UserService uservice;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub

		// System.out.println(rservice.findById(1L));
//		ParagraphEntity p = pservice.searchParagraphById(1L).get();
//		UserEntity u = uservice.findByIdUser(1L).get();
//		RatingEntity e = new RatingEntity("CIAOOO", "BENE", 1L, p);

	}
}
