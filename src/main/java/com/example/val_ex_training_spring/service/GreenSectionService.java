package com.example.val_ex_training_spring.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.val_ex_training_spring.entity.GreenSectionEntity;
import com.example.val_ex_training_spring.entity.ParagraphEntity;
import com.example.val_ex_training_spring.entity.UserEntity;
import com.example.val_ex_training_spring.repository.GreenSectionRepository;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import model.bean.GreenSectionBean;
import model.dao.GreenSectionDao;
import model.dto.GreenSectionDTO;
import utils.converter.GreenSectionConverter;

@Service
public class GreenSectionService {
private final GreenSectionRepository greenSectionRepo;

@Autowired
public GreenSectionService(GreenSectionRepository greensectionrepo) 
{
	this.greenSectionRepo=greensectionrepo;
	
}


public GreenSectionEntity saveEntity(GreenSectionEntity gse) 
{
	GreenSectionEntity savedGS=	greenSectionRepo.save(gse);
	return savedGS;
		}
public GreenSectionEntity findGreenSectionById(Long id) throws NotFoundException
{GreenSectionEntity gs=greenSectionRepo.findById(id).orElseThrow(() -> new NotFoundException());

return gs;

	}
public List <GreenSectionEntity> findAllGreenSection()
{
	List<GreenSectionEntity>greensectlist=greenSectionRepo.findAll();
	return greensectlist;
}

public boolean deleteGreenSection(Long id) throws NotFoundException {
	GreenSectionEntity gse= greenSectionRepo.findById(id).orElseThrow();
			greenSectionRepo.delete(gse);  
	boolean isdeleted=greenSectionRepo.findAll().contains(gse);
	if(!isdeleted) {
	return true;}
	else{return false;}
	
}

public boolean updateGreenSection(Long idGreenSection,String title)  
{
GreenSectionEntity gs=greenSectionRepo.findById(idGreenSection).orElseThrow();
gs.setTitle(title);
greenSectionRepo.save(gs);
Optional<GreenSectionEntity> issaved=greenSectionRepo.findById(gs.getIdGreenSection());
if(issaved!= null) {
return true;}
else{return false;}

}

public Set<GreenSectionEntity> searchGreenSection(Long id, String name) {

	Set<GreenSectionEntity> listGs = new HashSet<>();
	
	
	

	listGs = greenSectionRepo.findByName(id, name);
	
	return listGs;
}



}
