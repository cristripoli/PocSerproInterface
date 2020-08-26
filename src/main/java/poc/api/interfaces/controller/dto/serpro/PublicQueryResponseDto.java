package poc.api.interfaces.controller.dto.serpro;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import poc.api.interfaces.model.serpro.PublicQueryResponse;

public class PublicQueryResponseDto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long numeroEscala;
	private Date dataAtualizacao;
	
	public PublicQueryResponseDto() {

	}
	
	PublicQueryResponseDto(PublicQueryResponse publicQueryResponse){
		this.id = publicQueryResponse.getId();
		this.numeroEscala = publicQueryResponse.getNumero();
		this.dataAtualizacao = publicQueryResponse.getDataAtualizacao();
	}

	public Long getNumeroEscala() {
		return numeroEscala;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	
	public static List<PublicQueryResponseDto> mapToDto(List<PublicQueryResponse > publicQueryResponses){
		return publicQueryResponses.stream().map(PublicQueryResponseDto::new).collect(Collectors.toList());
	}

}
