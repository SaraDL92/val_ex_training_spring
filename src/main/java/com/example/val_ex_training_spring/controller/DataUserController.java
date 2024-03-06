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

import com.example.val_ex_training_spring.entity.DataUserEntity;
import com.example.val_ex_training_spring.entity.UserEntity;
import com.example.val_ex_training_spring.service.DataUserService;
import com.example.val_ex_training_spring.service.UserService;

@RestController
@RequestMapping("/Datausers")
public class DataUserController {
	@Autowired
	DataUserService uService;
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public DataUserEntity saveUser(@RequestBody DataUserEntity body) {
		DataUserEntity createdUser = uService.saveDataUser(body);
		return createdUser;
	}
	
	@GetMapping("")
	public List<DataUserEntity> getUsers(){
		return uService.getDataUser();
	}
	
	@GetMapping("/{userId}")
	public DataUserEntity findById(@PathVariable Long userId) throws NotFoundException {
		return uService.findByIdDataUser(userId);
	}
	
	@PutMapping("/{userId}")
	public DataUserEntity updateUser(@PathVariable Long userId, @RequestBody DataUserEntity body) throws NotFoundException {
		return uService.findByIdAndUpdate(userId, body);
	}

	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Long userId) throws NotFoundException {
		uService.deleteDataUser(userId);
	}
}
