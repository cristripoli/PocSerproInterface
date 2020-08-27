package poc.api.interfaces.controller.serpro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.api.interfaces.entities.serpro.PrivateQueryBillOfLadingItemResponse;
import poc.api.interfaces.entities.serpro.PrivateQueryBillOfLadingResponse;
import poc.api.interfaces.entities.serpro.PrivateQueryManifestResponse;
import poc.api.interfaces.entities.serpro.PrivateQuerySeaScaleResponse;
import poc.api.interfaces.services.serpro.PrivateQueryService;

@RestController
@RequestMapping("v1/serpro/consulta-restrita")
public class PrivateQueryController {
	
	@Autowired
	private PrivateQueryService serproService;


	@GetMapping("/escalas/{scaleNumber}")
	public PrivateQuerySeaScaleResponse getSeaScale(@PathVariable Long scaleNumber) {
		return serproService.privateQuery("/escalas/" + scaleNumber, PrivateQuerySeaScaleResponse.class);
	}
	
	@GetMapping("/manifestos/{manifestNumber}")
	public PrivateQueryManifestResponse getManifest(@PathVariable Long manifestNumber) {
		return serproService.privateQuery("/manifestos/" + manifestNumber, PrivateQueryManifestResponse.class);
	}
	
	@GetMapping("/conhecimentos-embarque/{billOfLadingNumber}")
	public PrivateQueryBillOfLadingResponse getBillOfLading(@PathVariable Long billOfLadingNumber) {
		return serproService.privateQuery("/conhecimentos-embarque/" + billOfLadingNumber, PrivateQueryBillOfLadingResponse.class);
		
	}
	
	@GetMapping("/conhecimentos-embarque/{billOfLadingNumber}/itens/{itemNumber}")
	public PrivateQueryBillOfLadingItemResponse getBillOfLadingItems(@PathVariable Long billOfLadingNumber, @PathVariable String itemNumber) {
		return serproService.privateQuery("/conhecimentos-embarque/" + billOfLadingNumber + "/itens/" + itemNumber, PrivateQueryBillOfLadingItemResponse.class);
	}
}
