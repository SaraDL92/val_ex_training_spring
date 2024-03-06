package com.example.val_ex_training_spring.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.val_ex_training_spring.entity.GreenSectionEntity;
import com.example.val_ex_training_spring.entity.ParagraphEntity;
import com.example.val_ex_training_spring.entity.RatingEntity;
import com.example.val_ex_training_spring.entity.UserEntity;
import com.example.val_ex_training_spring.service.GreenSectionService;
import com.example.val_ex_training_spring.service.ParagraphService;
import com.example.val_ex_training_spring.service.RatingService;
import com.example.val_ex_training_spring.service.UserService;

@Component
public class Runner implements ApplicationRunner {

	@Autowired
	ParagraphService paragraphService;
	@Autowired
	UserService userService;
	@Autowired
	GreenSectionService greenSectionService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//GreenSectionEntity greenSection = greenSectionService.findGreenSectionById(4L);
		//ParagraphEntity paragraph = new ParagraphEntity("Paragraph Title Save 2","Paragraph description Save 2",greenSection);
		//paragraphService.saveParagraph(paragraph);
		//paragraphService.deleteParagraph(paragraphService.searchParagraphById(6L));

//		System.out.println(paragraphService.searchParagraphById(5L));
//		paragraph.setIdparagraphs(3L);
//		paragraph.setTitle("Titolo sostitutivo");
//		paragraph.setDescription("Descrizione sostitutiva");
//		paragraph.setIdGreenSection(greenSectionService.findGreenSectionById(4L));
		
		//GreenSectionEntity greenSection = greenSectionService.findGreenSectionById(4L);
//		
//		ParagraphEntity paragraph = new ParagraphEntity("Titolo modificato","Descrizione modificata 33", greenSection);
//		System.out.println(paragraphService.updateParagraph(3L, paragraph));

		//System.out.println(paragraphService.searchParagraphByIdGreenSection(greenSection));
	}
}
