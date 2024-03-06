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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="green_section")
	public class GreenSectionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
		private Long idGreenSection;
		@Column(nullable=false)
		private String title;
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name = "id_User", referencedColumnName = "idUser")
		private UserEntity idUser;
		@JsonIgnore
		@OneToMany(mappedBy="idGreenSection")
		private List <ParagraphEntity>paragraphList=new ArrayList<>();
		
		public GreenSectionEntity(String title1,UserEntity user)
		{this.title=title1;
		idUser=user;
		}
}
