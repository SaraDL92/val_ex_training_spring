package com.example.val_ex_training_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.val_ex_training_spring.entity.DataUserEntity;
import com.example.val_ex_training_spring.entity.UserEntity;
import com.example.val_ex_training_spring.repository.DataUserRepository;

@Service
public class DataUserService {
	@Autowired
	DataUserRepository dataRepo;
	
	public DataUserEntity saveDataUser(DataUserEntity uData) {
		DataUserEntity duE = dataRepo.save(uData);
		return duE;
	}

	public List<DataUserEntity> getDataUser() {
		return dataRepo.findAll();
	}

	public DataUserEntity findByIdDataUser(Long id) throws NotFoundException {
		return dataRepo.findById(id).orElseThrow(() -> new NotFoundException());
	}
	
	public DataUserEntity findByIdAndUpdate(Long id, DataUserEntity body) throws NotFoundException {
		DataUserEntity found = this.findByIdDataUser(id);
		if(found != null) {
			found.setDescription(body.getDescription());
			found.setValue(body.getValue());
			return dataRepo.save(found);
			} else {
				return null;
			}
	}

	public void deleteDataUser(Long id) throws NotFoundException {
		DataUserEntity found = this.findByIdDataUser(id);
		dataRepo.delete(found);
	}
	
	public List<DataUserEntity> findAllDataById(Long id){
		return dataRepo.findByIdDataUser(id);
	}
	
	  public List<DataUserEntity> findByName(String name) {
	        return dataRepo.findByDescriptionAndValueContaining(name);
	    }
	  
	  public List<Object[]> getEmailAndFullName() {
		    List<Object[]> resultList = dataRepo.getEmailAndFullName();
		    return resultList;
		}
	  
	  public List<DataUserEntity> findByUserId(Long id) {
	        return dataRepo.findByUserIdData(id);
	    }
}
