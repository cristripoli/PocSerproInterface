package poc.api.interfaces.controller.serpro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poc.api.interfaces.entities.serpro.PublicQueryResponse;
import poc.api.interfaces.services.serpro.PrivateQueryService;
import poc.api.interfaces.services.serpro.PublicQueryService;

@RestController
@RequestMapping("v1/generic")
public class GenericRequestController {
	
	@Autowired
	private PrivateQueryService serproPrivateService;
	
	@Autowired
	private PublicQueryService serproPublicService;


	@GetMapping("/makePublicRequest")
	public String makePublicRequest(@PathVariable String resource) {
		return serproPrivateService.privateQuery(resource).toString();
	}
	
	@GetMapping("/makePrivateRequest")
	public List<PublicQueryResponse> makePrivateRequest(@RequestParam List<String> nr) {
		String queryParameters = String.join("&nr=", nr);
		return serproPublicService.publicQuery(queryParameters);
	}
}
