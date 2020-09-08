package poc.api.interfaces.dto.serpro;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import poc.api.interfaces.entities.serpro.PublicQueryResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicQueryResponseDto {

	private Long numeroEscala;
	private Date dataAtualizacao;
	
	PublicQueryResponseDto(PublicQueryResponse publicQueryResponse){
		this.numeroEscala = publicQueryResponse.getNumero();
		this.dataAtualizacao = publicQueryResponse.getDataAtualizacao();
	}
	
	public static List<PublicQueryResponseDto> mapToDto(List<PublicQueryResponse > publicQueryResponses){
		return publicQueryResponses.stream().map(PublicQueryResponseDto::new).collect(Collectors.toList());
	}
}
