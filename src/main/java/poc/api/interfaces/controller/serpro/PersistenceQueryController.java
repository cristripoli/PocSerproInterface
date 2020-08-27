package poc.api.interfaces.controller.serpro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.api.interfaces.dto.serpro.PublicQueryResponseDto;
import poc.api.interfaces.entities.serpro.PrivateQueryBillOfLadingItemResponse;
import poc.api.interfaces.entities.serpro.PrivateQueryBillOfLadingResponse;
import poc.api.interfaces.entities.serpro.PrivateQueryManifestResponse;
import poc.api.interfaces.entities.serpro.PrivateQuerySeaScaleResponse;
import poc.api.interfaces.entities.serpro.PublicQueryResponse;
import poc.api.interfaces.repository.IPublicQueryResponseRepository;
import poc.api.interfaces.services.serpro.PrivateQueryService;

@RestController
@RequestMapping("v1/serpro")
public class PersistenceQueryController {

	@Autowired
	private IPublicQueryResponseRepository publicQueryResponseRepository;
	
	@Autowired
	private PrivateQueryService privateQueryService;
	
	@GetMapping("/consulta-publica")
	public List<PublicQueryResponseDto> listAllLastUpdateDates(){
		
		List<PublicQueryResponse> publicQueryResponses = publicQueryResponseRepository.findAll();
		return PublicQueryResponseDto.mapToDto(publicQueryResponses);
	}
	
	@GetMapping("/escalas")
	public List<PrivateQuerySeaScaleResponse> listAllSeaScales(){
		return privateQueryService.findAllSeaScale();
	}
	
	@GetMapping("/manifestos")
	public List<PrivateQueryManifestResponse> listAllManifests(){
		return privateQueryService.findAllManifest();
	}

	
	@GetMapping("/conhecimentos-embarque")
	public List<PrivateQueryBillOfLadingResponse> listAllBillOfLanding(){
		return privateQueryService.findAllBillOfLanding();
	}

	
	@GetMapping("/conhecimentos-embarque/itens")
	public List<PrivateQueryBillOfLadingItemResponse> listAllBillOfLandingItems(){
		return privateQueryService.findAllBillOfLandingItem();
	}

}
