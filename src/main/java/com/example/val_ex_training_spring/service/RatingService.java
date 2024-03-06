package com.example.val_ex_training_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.val_ex_training_spring.entity.RatingEntity;
import com.example.val_ex_training_spring.repository.ParagraphRepository;
import com.example.val_ex_training_spring.repository.RatingRepository;
import com.example.val_ex_training_spring.repository.UserRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class RatingService {

	@Autowired
	RatingRepository repo;
	@Autowired
	UserRepository repoUser;
	@Autowired
	ParagraphRepository repoParagraph;

	public List<RatingEntity> findAll() {
		return repo.findAll();
	}

	public RatingEntity findById(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityExistsException("Rating not found!");
		}
		return repo.findById(id).get();

	}

	public RatingEntity create(RatingEntity rating) {
		return repo.save(rating);
	}

	public RatingEntity update(Long id, RatingEntity rating) {
		
		if(!repo.existsById(id)) {			
			RatingEntity r = repo.findById(id).get();
			r.setIdParagraphs(rating.getIdParagraphs());
			r.setIdRating(rating.getIdRating());
			r.setIdUserRating(rating.getIdUserRating());
			r.setRating(rating.getRating());
			r.setRatingType(rating.getRatingType());
			return repo.save(r);
		} else {
			throw new EntityExistsException("User not found!");
		}
	}

	public int delete(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityExistsException("Rating not found!");
		} else {
			repo.deleteById(id);
			return 1;
		}
	}

	public List<RatingEntity> findByIdParagraphUserId(Long idUser, Long idParagraph) {
		if (!repoUser.existsById(idUser)) {
			throw new EntityExistsException("User not found!");
		}
		if (!repoParagraph.existsById(idParagraph)) {
			throw new EntityExistsException("Paragraph not found!");
		}
		return repo.findByIdParagraphIdUser(idUser, idParagraph);
	}

	public List<RatingEntity> findByRatingName(Long idUser, String name) {
		if (!repoUser.existsById(idUser)) {
			throw new EntityExistsException("User not found!");
		}
		if (name != null) {
			return repo.findByNameRating(idUser, name);
		} else {
			throw new NullPointerException("Name is null");
		}
	}

	public RatingEntity simpleUpdate(String ratingType, String rating, Long idRating) {
		if (!repoUser.existsById(idRating)) {
			throw new EntityExistsException("Rating not found!");
		}
		RatingEntity r = repo.findById(idRating).get();
		if (ratingType != null) {
			if(rating != null) {				
			r.setRating(rating);
			r.setRatingType(ratingType);
			return repo.save(r);
			} else {
				throw new NullPointerException("Value is null");
			}
		} else {
			throw new NullPointerException("Rating is null");
		}
	}
}
