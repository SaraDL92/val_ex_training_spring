package com.example.val_ex_training_spring.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="rating")
public class RatingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRating;
	@Column(nullable=false)
	private String ratingType;
	@Column(nullable=false)
	private String rating;
	@ManyToOne
	@JoinColumn(name = "id_userRating", referencedColumnName = "idUser")
	private UserEntity idUserRating;
	@ManyToOne
	 @JoinColumn(name = "id_paragraph", referencedColumnName = "idparagraphs")
	private ParagraphEntity idParagraphs;
}
