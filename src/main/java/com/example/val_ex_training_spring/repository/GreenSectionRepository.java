package com.example.val_ex_training_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.val_ex_training_spring.entity.GreenSectionEntity;

@Repository
public interface GreenSectionRepository extends JpaRepository<GreenSectionEntity,Long> {

}
