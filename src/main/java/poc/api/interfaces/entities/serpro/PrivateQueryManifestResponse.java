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
public class PrivateQueryManifestResponse extends PrivateQueryGenericResponse {

	private static final long serialVersionUID = 9139689930463507598L;
	private String tipoTrafego;
	private String cnpjEmpresaNavegacao;
}
