package com.example.val_ex_training_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.val_ex_training_spring.entity.RatingEntity;
import com.example.val_ex_training_spring.repository.RatingRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class RatingService {

	@Autowired
	RatingRepository repo;
	
	public List<RatingEntity> findAll (){
		return repo.findAll();
	}

	public RatingEntity findById(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityExistsException("Rating non trovato!");
		}
		return repo.findById(id).get();

	}

	public RatingEntity create(RatingEntity rating) {
		return repo.save(rating);
	}

	public RatingEntity update(Long id, RatingEntity rating) {

		RatingEntity r = repo.findById(id).get();
		r.setIdParagraphs(rating.getIdParagraphs());
		r.setIdRating(rating.getIdRating());
		r.setIdUserRating(rating.getIdUserRating());
		r.setRating(rating.getRating());
		r.setRatingType(rating.getRatingType());
		return repo.save(r);
	}

	public int delete(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityExistsException("Rating non trovato!");
		} else {
			repo.deleteById(id);
			return 1;
		}
	}
}
