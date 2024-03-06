package com.example.val_ex_training_spring.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
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
	@JsonIgnore
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
	private Boolean cancellation;
	
	public UserEntity(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		this.creationDate = LocalDateTime.now();
		this.cancellation = false;
	}
	
	@Override
	public String toString() {
		return "UserEntity [idUser=" + idUser + ", email=" + email + ", password=" + password + ", creationDate="
				+ creationDate + ", cancellation=" + cancellation + "]";
	}
	
}
