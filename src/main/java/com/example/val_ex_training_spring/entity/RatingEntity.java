package com.example.val_ex_training_spring.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	
	
	@Override
	public String toString() {
		return "RatingEntity [idRating=" + idRating + ", ratingType=" + ratingType + ", rating=" + rating
				+ ", idUserRating=" + idUserRating.getIdUser() + "]";
	}

	public RatingEntity(String ratingType, String rating, UserEntity idUserRating, ParagraphEntity idParagraphs) {
		super();
		this.ratingType = ratingType;
		this.rating = rating;
		this.idUserRating = idUserRating;
		this.idParagraphs = idParagraphs;
	}
	
	
}
