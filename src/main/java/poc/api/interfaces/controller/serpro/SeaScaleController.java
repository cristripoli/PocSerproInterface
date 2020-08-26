package poc.api.interfaces.controller.serpro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.api.interfaces.dto.serpro.PublicQueryResponseDto;
import poc.api.interfaces.entities.serpro.PublicQueryResponse;
import poc.api.interfaces.repository.IPublicQueryResponseRepository;

@RestController
@RequestMapping("v1/serpro/escalas")
public class SeaScaleController {

	@Autowired
	private IPublicQueryResponseRepository publicQueryResponseRepository;
	
	@RequestMapping("/data-ultima-atualizacao")
	public List<PublicQueryResponseDto> listAllLastUpdateSeaScalesDates(){
		
		List<PublicQueryResponse> publicQueryResponses = publicQueryResponseRepository.findAll();
		return PublicQueryResponseDto.mapToDto(publicQueryResponses);
	}

}
