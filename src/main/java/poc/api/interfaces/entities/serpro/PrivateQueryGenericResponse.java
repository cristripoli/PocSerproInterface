package poc.api.interfaces.entities.serpro;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PrivateQueryGenericResponse implements Serializable{

	private static final long serialVersionUID = 559290256006804537L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long numero;
}
