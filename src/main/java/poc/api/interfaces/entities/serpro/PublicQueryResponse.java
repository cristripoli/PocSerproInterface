package poc.api.interfaces.entities.serpro;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PublicQueryResponse {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long numero;
	private Date dataAtualizacao;
}
