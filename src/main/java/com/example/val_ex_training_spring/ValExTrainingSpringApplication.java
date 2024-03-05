package com.example.val_ex_training_spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.example.val_ex_training_spring.entity.DataUserEntity;
import com.example.val_ex_training_spring.entity.GreenSectionEntity;
import com.example.val_ex_training_spring.entity.UserEntity;
import com.example.val_ex_training_spring.repository.DataUserRepository;
import com.example.val_ex_training_spring.repository.GreenSectionRepository;
import com.example.val_ex_training_spring.repository.UserRepository;
import com.example.val_ex_training_spring.service.DataUserService;
import com.example.val_ex_training_spring.service.GreenSectionService;
import com.example.val_ex_training_spring.service.UserService;

import jakarta.annotation.PostConstruct;

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
	GreenSectionRepository gsRepo;
	
	@Autowired
	GreenSectionService gsService;
	
	
	  @Autowired
	    UserService uService;
	  
//	  public void saveGS(GreenSectionEntity gs) {
//		  gsRepo.save(gs);
//	  }
//	  public void saveUs(UserEntity user) {
//		  uRepo.save(user)
//		  }
//	  UserEntity user=new UserEntity("lala","lala");
//
//GreenSectionEntity gs=new GreenSectionEntity("titolo",user);

	    @PostConstruct
	    public void init() throws NotFoundException {
	        // Move the logic here
//	        UserEntity uE = new UserEntity("h1@h1.it", "12345");
//	        uService.saveUser(uE);
//	        List<UserEntity> list = uService.getUsers();
//	        for(UserEntity l: list) {
//	        System.out.println("Lista" + l.toString());
//	      }
//	    	UserEntity e = uService.findByIdUser(1L);
//	    	System.out.println(e.toString());
	    	
	//    	uService.findByIdAndDelete(4L);
	    	
//	    	UserEntity uE = new UserEntity("hup@hup.it", "12345");
//	    	uService.findByIdAndUpdate(2L, uE);
	    	//saveUs(user);
//	    	UserEntity uE = new UserEntity("laiaruurReptt","lala1111");
//	    UserEntity uE1 = uRepo.save(uE);
//	    	GreenSectionEntity gs=new GreenSectionEntity("titolo",uE1);
//	    	GreenSectionEntity gs1 = gsService.saveEntity(gs);
//	    	//boolean delete=gsService.deleteGreenSection(13L);
//	    	boolean update=gsService.updateGreenSection(3L, "Bene");
//	    	//System.out.println(delete);
//	    	List<GreenSectionEntity>list=gsService.findAllGreenSection();
//	    	for(GreenSectionEntity gsa:list) {System.out.println(gsa.getTitle());}
	    	GreenSectionEntity gss=gsService.findGreenSectionById(3L);
	    	System.out.println("questa è la green che cercavi"+gss.getTitle());
	    	
	    	
	    }
	  
	   
	    
}
