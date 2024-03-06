package com.example.val_ex_training_spring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.val_ex_training_spring.entity.GreenSectionEntity;
import com.example.val_ex_training_spring.entity.ParagraphEntity;
import com.example.val_ex_training_spring.repository.ParagraphRepository;

@Service
public class ParagraphService {

	@Autowired
	ParagraphRepository paragraphRepository;
	@Autowired
	GreenSectionService greenSectionService;
	
	public List<ParagraphEntity> searchAllParagraph(){
		return paragraphRepository.findAll();
	}
	
	public ParagraphEntity searchParagraphById(Long idParagraph) {
		return paragraphRepository.findById(idParagraph).get();
	}
	
	public List<ParagraphEntity> searchParagraphByName(String title) {
		return paragraphRepository.findByTitle(title);
	}
	
	public List<ParagraphEntity> searchParagraphByIdGreenSection(GreenSectionEntity idGreenSection) {
		return paragraphRepository.findByIdGreenSection(idGreenSection);
	}
	
	public ParagraphEntity saveParagraph(ParagraphEntity paragraph) {
		ParagraphEntity newParagraph = new ParagraphEntity(paragraph.getTitle(), paragraph.getDescription(), paragraph.getIdGreenSection());
		return paragraphRepository.save(newParagraph);
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
	
	public ParagraphEntity updateParagraph(Long idParagraph, ParagraphEntity paragraph) {
		ParagraphEntity paragraphUpdated = this.searchParagraphById(idParagraph);
		if(paragraphUpdated!=null ) {
			paragraphUpdated.setTitle(paragraph.getTitle());
			paragraphUpdated.setDescription(paragraph.getDescription());
			paragraphUpdated.setIdGreenSection(paragraph.getIdGreenSection());
		}
		return paragraphRepository.save(paragraphUpdated);
	}
}
