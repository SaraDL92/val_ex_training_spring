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
@Table(name="roles")
public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false, columnDefinition = "VARCHAR(255) DEFAULT 'Valutato'")
	private String description;
	@ManyToOne
	//Per rinominare la colonna della FK mettere questa notation 
	//in cui name sta per nome effettivo che vuoi dare alla colonna
	//e referencedColumnName la colonna dell'id della tabella di riferimento
	@JoinColumn(name = "id_firstuser", referencedColumnName = "idUser")
	private UserEntity idFirstUser;
}
