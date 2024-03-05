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
@NoArgsConstructor
@Getter
@Setter
@Table(name="data_user")
@AllArgsConstructor
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
	
	
	public DataUserEntity(String description, String value, UserEntity idUser) {
		this.description = description;
		this.value = value;
		this.idUser = idUser;
	}
	
	
}
