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
public class PrivateQueryBillOfLadingResponse extends PrivateQueryGenericResponse {

	private static final long serialVersionUID = 6714405237648948399L;
	
	private String navioPrimTransporte;
	private String numeroBlConhecimento;
}
