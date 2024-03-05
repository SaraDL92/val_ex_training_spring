package com.example.val_ex_training_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.val_ex_training_spring.entity.RatingEntity;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Long>{
	
//	@Query("SELECT r FROM RatingEntity r WHERE idUserRating= :value1 AND idParagraphs= :value2")
//	List<RatingEntity> findByIdParagraphIdUser(@Param("value1") Long idUser, @Param("value2") Long idParagraph);
//
//	@Query("SELECT r FROM rating r WHERE idUserRating= :value1 AND ratingType LIKE '% :value2 %'")
//	List<RatingEntity> findByNameRating (@Param("value1") Long idUser, @Param("value2") String nameRating);
//
//	@Query("UPDATE rating SET ratingType=:value1, rating= :value2 WHERE id_rating= :value3")
//	int updateSimpleRating (@Param("value1") String ratingType, @Param("value2") String rating, @Param("value3") Long idRating);
}
