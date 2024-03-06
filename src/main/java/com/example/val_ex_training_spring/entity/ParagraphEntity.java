package com.example.val_ex_training_spring.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paragraphs")
public class ParagraphEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idparagraphs;

	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String description;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_greenSection", referencedColumnName = "idGreenSection")
	private GreenSectionEntity idGreenSection;
	@JsonIgnore
	@OneToMany(mappedBy = "idParagraphs")
	private List<RatingEntity> ratingList = new ArrayList<>();

	public ParagraphEntity(String title, String description, GreenSectionEntity idGreenSection) {
		super();
		this.title = title;
		this.description = description;
		this.idGreenSection = idGreenSection;
	}

	@Override
	public String toString() {
		return "ParagraphEntity [idparagraphs=" + idparagraphs + ", title=" + title + ", description=" + description
				+ ", idGreenSection=" + idGreenSection.getIdGreenSection() + "]";
	}

}