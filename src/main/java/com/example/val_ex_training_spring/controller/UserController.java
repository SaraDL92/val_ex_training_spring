package com.example.val_ex_training_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.val_ex_training_spring.entity.UserEntity;
import com.example.val_ex_training_spring.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService uService;
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public UserEntity saveUser(@RequestBody UserEntity body) {
		UserEntity createdUser = uService.saveUser(body);
		return createdUser;
	}
	
	@GetMapping("")
	public List<UserEntity> getUsers(){
		return uService.getUsers();
	}
	
	@GetMapping("/{userId}")
	public UserEntity findById(@PathVariable Long userId) throws NotFoundException {
		return uService.findByIdUser(userId);
	}
	
	@PutMapping("/{userId}")
	public UserEntity updateUser(@PathVariable Long userId, @RequestBody UserEntity body) throws NotFoundException {
		return uService.findByIdAndUpdate(userId, body);
	}

	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Long userId) throws NotFoundException {
		uService.findByIdAndDelete(userId);
	}
}
