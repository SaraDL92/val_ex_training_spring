package com.example.val_ex_training_spring.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@Table(name="user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idUser;
	
	@OneToMany(mappedBy="idFirstUser")
	private List <RoleEntity> roleList=new ArrayList<>();
	@OneToMany(mappedBy="idUserRating")
	private List <RatingEntity> ratingList=new ArrayList<>();
	@OneToMany(mappedBy="idUser")
	private List<GreenSectionEntity> greenSectionList=new ArrayList<>();
	@OneToMany(mappedBy="idUser")
	private List <DataUserEntity> dataUserList=new ArrayList<>();
	@Column(nullable=false,unique=true)
	private String email;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private LocalDateTime creationDate;

	private LocalDateTime lastModifiedData;
	
	private LocalDateTime lastAccessData;
	@Column(nullable=false, columnDefinition = "BIT(1) DEFAULT b'0'")
	private Boolean cancellation;
}
