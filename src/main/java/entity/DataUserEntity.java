package entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="data_user")
public class DataUserEntity {
	@Id
	@GeneratedValue
	Long idDataUser;
	@Column
	String description;
	@Column
	String value;
	@Column
	Long idUser;
	
	
	
	
	
}
