package poc.api.interfaces.controller.serpro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poc.api.interfaces.model.serpro.PublicQueryResponse;
import poc.api.interfaces.repository.IPublicQueryResponseRepository;
import poc.api.interfaces.services.serpro.PublicQueryService;

@RestController
@RequestMapping("v1/serpro/consulta-publica")
public class PublicQueryController {
	
	@Autowired
	private PublicQueryService serproService;

	@Autowired
	private IPublicQueryResponseRepository publicQueryResponseRepository;
	
	@GetMapping("/escalas")
	public List<PublicQueryResponse> listLastUpdateSeaScalesDate(@RequestParam List<String> nr) {
		String queryParameters = String.join("&nr=", nr);
		List<PublicQueryResponse> publicQueryResponses =  serproService.publicQuery("/escala/data-ultima-atualizacao?nr=" + queryParameters);
		return publicQueryResponses;
	}
	
	@GetMapping("/manifestos")
	public List<PublicQueryResponse> listLastUpdateManifestsDate(@RequestParam List<String> nr) {
		String queryParameters = String.join("&nr=", nr);
		return serproService.publicQuery("/manifesto/data-ultima-atualizacao?nr=" + queryParameters);
	}
	
	@GetMapping("/conhecimentos-embarque")
	public List<PublicQueryResponse> listLastUpdateBillsOfLadingDate(@RequestParam List<String> nr) {
		String queryParameters = String.join("&nr=", nr);
		return serproService.publicQuery("/ce/data-ultima-atualizacao?nr=" + queryParameters);
	}
}
