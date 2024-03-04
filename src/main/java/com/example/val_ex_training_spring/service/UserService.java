package com.example.val_ex_training_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.val_ex_training_spring.entity.UserEntity;
import com.example.val_ex_training_spring.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public UserEntity saveUser(UserEntity uEntity) {
		UserEntity newDataUser = new UserEntity(uEntity.getEmail(), uEntity.getPassword());
		return userRepo.save(newDataUser);
	}

	public List<UserEntity> getUsers() {
		return userRepo.findAll();
	}

	public UserEntity findByIdUser(Long id) throws NotFoundException {
		return userRepo.findById(id).orElseThrow(() -> new NotFoundException());
	}

	public UserEntity findByIdAndUpdate(Long id, UserEntity body) throws NotFoundException {
		UserEntity found = this.findByIdUser(id);
		found.setEmail(body.getEmail());
		found.setPassword(body.getPassword());
		return userRepo.save(found);
	}

	public void findByIdAndDelete(Long id) throws NotFoundException {
		UserEntity found = this.findByIdUser(id);
		userRepo.delete(found);
	}



}
