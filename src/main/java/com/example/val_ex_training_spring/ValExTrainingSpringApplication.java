
package com.example.val_ex_training_spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.example.val_ex_training_spring.entity.DataUserEntity;
import com.example.val_ex_training_spring.entity.UserEntity;
import com.example.val_ex_training_spring.repository.DataUserRepository;
import com.example.val_ex_training_spring.repository.UserRepository;
import com.example.val_ex_training_spring.service.DataUserService;
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
	    UserService uService;

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
	    	
//	    	UserEntity uE = new UserEntity("zorr013434@h1.it", "12345");
//	    	
//	    	UserEntity u = uService.saveUser(uE);
//	    	DataUserEntity uE1 = new DataUserEntity("Nome", "Marcolino");
//	    	    dService.findByIdAndUpdate(14L, uE1);
//	        
	       
//	    	List<DataUserEntity> d = dService.getDataUser();
//	    	  for(DataUserEntity l: d) {
//	  	        System.out.println("Lista" + l.toString());
//	  	      }
	    	  
//	    	System.out.println(dService.findAllDataById(14L));
//	    	
//	    	System.out.println(dService.findByIdUser(34L));
//	    	  System.out.println("Ciao");
	    	
//	    	System.out.println(dService.findByName("M"));
	    	
//	    	List<Object[]> d = dService.getEmailAndFullName();
//	    	  for(Object[] l: d) {
//	  	        System.out.println("Lista" + l.toString());
//	  	      }
	    	
	    	List<DataUserEntity> d = dService.findByUserId(32L);
	    	  for(DataUserEntity l: d) {
	  	        System.out.println("Lista" + l.toString());
	  	      }
	    }
	    
	   
	    
}
