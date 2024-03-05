package com.example.val_ex_training_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.val_ex_training_spring.entity.DataUserEntity;

@Repository
public interface DataUserRepository extends JpaRepository<DataUserEntity, Long> {
	
 List<DataUserEntity> findByIdDataUser(Long id);
 
 @Query("SELECT d FROM DataUserEntity d WHERE (d.description = 'nome' OR d.description = 'cognome') AND d.value LIKE %:name%")
 List<DataUserEntity> findByDescriptionAndValueContaining(String name);
 
 @Query("SELECT u.email, CONCAT(nome.value, ' ', cognome.value) " +
         "FROM UserEntity u " +
         "JOIN u.roleList r " +
         "JOIN DataUserEntity nome ON u.idUser = nome.idDataUser AND nome.description = 'nome' " +
         "JOIN DataUserEntity cognome ON u.idUser = cognome.idDataUser AND cognome.description = 'cognome' " +
         "WHERE r.description = 'Valutato'")
  List<Object[]> getEmailAndFullName();

  @Query("SELECT d FROM DataUserEntity d WHERE d.idUser.id = :userId")
  List<DataUserEntity> findByUserIdData(@Param("userId") Long userId);
}
