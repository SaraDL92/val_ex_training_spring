package com.example.val_ex_training_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.val_ex_training_spring.entity.ParagraphEntity;
import com.example.val_ex_training_spring.service.ParagraphService;

@RestController
@RequestMapping("/Paragraph")
public class ParagraphController {

	@Autowired
	private ParagraphService paragraphService;

	@GetMapping("/{id}")
	public ParagraphEntity getById(@PathVariable Long id) {
		return paragraphService.searchParagraphById(id);
	}

	@PostMapping
	public ParagraphEntity create(@RequestBody ParagraphEntity entity) {
		return paragraphService.saveParagraph(entity);
	}
	
	@PutMapping("/{id}")
	public ParagraphEntity update(@PathVariable Long id, @RequestBody ParagraphEntity entity) {
		return paragraphService.updateParagraph(id, entity);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		paragraphService.deleteParagraph(id);
	}

}
