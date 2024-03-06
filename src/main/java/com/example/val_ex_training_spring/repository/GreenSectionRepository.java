package com.example.val_ex_training_spring.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.val_ex_training_spring.entity.GreenSectionEntity;




@Repository
public interface GreenSectionRepository extends JpaRepository<GreenSectionEntity,Long> {
	@Query("SELECT d FROM GreenSectionEntity d WHERE d.idUser=:id AND d.title LIKE %:name%")
	public Set<GreenSectionEntity> findByName(Long id, String name) ;
	
	@Query("SELECT d FROM GreenSectionEntity d WHERE d.idUser=:id")
	public List<GreenSectionEntity> findByIdUser(Long id) ;
    

	   

	    

	   
	   
	

}
