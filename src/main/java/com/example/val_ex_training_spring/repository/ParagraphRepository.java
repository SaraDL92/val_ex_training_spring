package com.example.val_ex_training_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.val_ex_training_spring.entity.GreenSectionEntity;
import com.example.val_ex_training_spring.entity.ParagraphEntity;

import jakarta.transaction.Transactional;

public interface ParagraphRepository extends JpaRepository<ParagraphEntity, Long>{
	
	@Transactional
	@Modifying
	@Query("UPDATE ParagraphEntity p SET title = :title, description = :description, idGreenSection = :idGreenSection WHERE idparagraphs = :idparagraphs")
    int updateParagraph(@Param("title") String title, @Param("description") String description, @Param("idGreenSection") GreenSectionEntity idGreenSection, @Param("idparagraphs") Long idParagraph);

}
