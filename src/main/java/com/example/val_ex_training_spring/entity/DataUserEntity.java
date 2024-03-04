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
@Table(name="data_user")
public class DataUserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDataUser;
	@Column(nullable=false)
	private String description;
	@Column(nullable=false)
	private String value;
	@ManyToOne
	@JoinColumn(name = "id_User", referencedColumnName = "idUser")
	private UserEntity idUser;
	
	
	
	
	
}
