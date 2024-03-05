package com.example.val_ex_training_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.val_ex_training_spring.entity.ParagraphEntity;

public interface ParagraphRepository extends JpaRepository<ParagraphEntity, Long>{
	
	@Query("UPDATE paragraphs SET title = :title, description = :description, idGreenSection = :idGreenSection WHERE idparagraphs = :idparagraphs")
    boolean updateParagraph(@Param("idparagraphs") Long idParagraph, @Param("title") String title, @Param("description") String description, @Param("idGreenSection") Long idGreenSection);
}
