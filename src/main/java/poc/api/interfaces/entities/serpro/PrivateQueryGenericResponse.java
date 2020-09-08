package poc.api.interfaces.entities.serpro;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PrivateQueryGenericResponse implements Serializable{

	private static final long serialVersionUID = 559290256006804537L;

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

}
