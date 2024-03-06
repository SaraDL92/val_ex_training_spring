package com.example.val_ex_training_spring.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.val_ex_training_spring.entity.GreenSectionEntity;
import com.example.val_ex_training_spring.entity.UserEntity;
import com.example.val_ex_training_spring.service.GreenSectionService;

@RestController
@RequestMapping("/GreenSections")
public class GreenSectionController {
	@Autowired
	public GreenSectionService gsService;
	
	@GetMapping("")
	public List<GreenSectionEntity> FindGreenSection() {
		return  gsService.findAllGreenSection();
		}

	@GetMapping("/{id}")
	public GreenSectionEntity FindGreenSectionById(@PathVariable Long id) throws NotFoundException {
		return  gsService.findGreenSectionById(id);
		}
	@DeleteMapping("/{id}")
	public String DeleteGreenSectionById(@PathVariable Long id) throws NotFoundException {
	gsService.deleteGreenSection(id)	;	
	return  "Green Section deleted";	
	}
	@PostMapping("/save")
	public GreenSectionEntity saveGreenSection(@RequestBody GreenSectionEntity gs){
		return gsService.saveEntity(gs);
		
	}
	
	@PutMapping("edit/{id}")
	public boolean UpdateGreenSection(@PathVariable Long id,@RequestBody String title) 
	{
		return gsService.updateGreenSection( id, title);
	}
//	@GetMapping("search/{userid}")
//	public Set<GreenSectionEntity> searchGreenSection(@PathVariable Long userid, @RequestParam String name)
//	{
//		List <GreenSectionEntity> usergs=gsService.findGreenSectionByUserId(userid);
//		
//	Set<GreenSectionEntity>gsofuser=new HashSet<>()
//;	for(GreenSectionEntity gs:usergs) {
//		UserEntity user=gs.getIdUser();
//		usergs.add(gs);
//		
//	}
//return gsService.searchGreenSection(userid, name);}
		
	
//	@GetMapping("/ueserid/{id}")
//	public List<GreenSectionEntity> findGreenSectionByUserIdUser(@PathVariable Long id){
//		gsService.
//		return gsService.findGreenSectionByUserId(id);
//		}
}
