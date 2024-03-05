package com.example.val_ex_training_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.example.val_ex_training_spring.entity.ParagraphEntity;
import com.example.val_ex_training_spring.repository.ParagraphRepository;

@Service
public class ParagraphService {

	@Autowired
	ParagraphRepository paragraphRepository;
	
	@Autowired
	public ParagraphService(ParagraphRepository paragraphRepository) {
		this.paragraphRepository = paragraphRepository;
	}
	
	public List<ParagraphEntity> searchAllParagraph(){
		return paragraphRepository.findAll();
	}
	
	public boolean saveParagraph(ParagraphEntity paragraph) {
		if(paragraphRepository.save(paragraph)!=null)
			return true;
		return false;
	}
	
	public Optional<ParagraphEntity> searchParagraphById(Long idParagraph) {
		return paragraphRepository.findById(idParagraph);
	}
	
	public List<ParagraphEntity> searchAllParagraphsd() {
		return paragraphRepository.findAll();
	}
	
	public void deleteParagraph(ParagraphEntity paragraph) {
		try{
			paragraphRepository.delete(paragraph);
		}catch(IllegalArgumentException e) {
			System.out.println("Paragraph in input is null:"+e);
		}catch(OptimisticLockingFailureException e) {
			System.out.println("Error with input");
		}
	}
	
//	public boolean updateParagraph(ParagraphEntity paragraph) {
//		return paragraphRepository.updateParagraph(paragraph.getIdparagraphs(), paragraph.getTitle(), paragraph.getDescription(), paragraph.getIdGreenSection().getIdGreenSection());
//	}
}
