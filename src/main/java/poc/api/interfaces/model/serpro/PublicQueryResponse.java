package poc.api.interfaces.model.serpro;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PublicQueryResponse {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long numero;
	private Date dataAtualizacao;
	
	public PublicQueryResponse() {

	}
	
	PublicQueryResponse(Long numero, Date dataAtualizacao){
		this.numero = numero;
		this.dataAtualizacao = dataAtualizacao;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Long getId() {
		return id;
	}

}
