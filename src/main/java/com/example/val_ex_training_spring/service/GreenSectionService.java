package com.example.val_ex_training_spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

@Service
public class GreenSectionService {
	private final GreenSectionRepository greenSectionRepo;

	@Autowired
	public GreenSectionService(GreenSectionRepository greensectionrepo) {
		this.greenSectionRepo = greensectionrepo;

	}

	public boolean saveEntity(GreenSectionEntity gse) {
		GreenSectionEntity savedGS = greenSectionRepo.save(gse);
		Long id = savedGS.getIdGreenSection();
		Optional<GreenSectionEntity> greensectionfounded = greenSectionRepo.findById(id);
		List<GreenSectionEntity> greensectionlist = greenSectionRepo.findAll();
		if (greensectionlist.contains(greensectionfounded)) {

			return true;
		}
		return false;

	}

	public GreenSectionEntity findGreenSectionById(Long id) throws NotFoundException {
		GreenSectionEntity gs = greenSectionRepo.findById(id).orElseThrow(() -> new NotFoundException());

		return gs;

	}

	public List<GreenSectionEntity> findAllGreenSection() {
		List<GreenSectionEntity> greensectlist = greenSectionRepo.findAll();
		return greensectlist;
	}

	public boolean deleteGreenSection(GreenSectionEntity gs) {
		greenSectionRepo.delete(gs);
		Long id = gs.getIdGreenSection();
		List<GreenSectionEntity> lista = greenSectionRepo.findAll();
		if (lista.contains(id)) {
			return false;
		}
		return true;
	}

	public boolean updateGreenSection(Long idGreenSection, String title, UserEntity idUser) throws NotFoundException {
		GreenSectionEntity gs = this.findGreenSectionById(idGreenSection);
		if (greenSectionRepo.findAll().contains(gs)) {
			gs.setIdUser(idUser);
			gs.setTitle(title);
		}

		GreenSectionEntity gssaved = greenSectionRepo.save(gs);
		if (gssaved != null) {
			return true;
		}
		return false;

	}

}
