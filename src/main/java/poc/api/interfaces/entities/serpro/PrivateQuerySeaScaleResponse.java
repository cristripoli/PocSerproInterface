package poc.api.interfaces.entities.serpro;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PrivateQuerySeaScaleResponse extends PrivateQueryGenericResponse {

	private static final long serialVersionUID = -978468202679359159L;
	
	private String embarcacao;
	private String responsavelEmbarcacao;
}
