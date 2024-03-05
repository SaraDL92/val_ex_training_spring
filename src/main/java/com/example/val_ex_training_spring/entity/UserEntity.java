package com.example.val_ex_training_spring.entity;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
	@Column(nullable=false,unique=true)
	private String email;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private LocalDateTime creationDate;
	private LocalDateTime lastModifiedData;
	private LocalDateTime lastAccessData;
	private Boolean cancellation;
	
	@OneToMany(mappedBy="idUserRating")
	private List <RatingEntity> ratingList;
	
	@OneToMany(mappedBy="idUser")
	private List<GreenSectionEntity> greenSectionList;
	
	@OneToMany(mappedBy="idUser")
	private List <DataUserEntity> dataUserList;
	
	@OneToMany(mappedBy="idFirstUser", fetch = FetchType.EAGER)
	private List <RoleEntity> roleList;
	
	public UserEntity(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		this.creationDate = LocalDateTime.now();
		this.cancellation = false;
	}

	@Override
	public String toString() {
		return "UserEntity [idUser=" + idUser + ", dataUserList=" + dataUserList + ", email=" + email
				+ ", password=" + password + ", creationDate=" + creationDate + ", lastModifiedData=" + lastModifiedData
				+ ", lastAccessData=" + lastAccessData + ", cancellation=" + cancellation + "]";
	}
	
	
	
}
