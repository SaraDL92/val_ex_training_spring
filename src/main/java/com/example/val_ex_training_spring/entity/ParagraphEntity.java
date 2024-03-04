package com.example.val_ex_training_spring.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="paragraphs")
public class ParagraphEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idparagraphs;
	
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private String description;
	 @ManyToOne
	 @JoinColumn(name = "id_greenSection", referencedColumnName = "idGreenSection")
	private GreenSectionEntity idGreenSection;
	@OneToMany(mappedBy="idParagraphs")
	private List <RatingEntity>ratingList=new ArrayList<>();
	
}