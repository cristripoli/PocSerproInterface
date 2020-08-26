package poc.api.interfaces.controller.serpro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.api.interfaces.entities.serpro.PrivateQueryGenericResponse;
import poc.api.interfaces.entities.serpro.PrivateQuerySeaScaleResponse;
import poc.api.interfaces.services.serpro.PrivateQueryService;

@RestController
@RequestMapping("v1/serpro/consulta-restrita")
public class PrivateQueryController {
	
	@Autowired
	private PrivateQueryService serproService;


	@GetMapping("/escalas/{scaleNumber}")
	public PrivateQuerySeaScaleResponse getSeaScale(@PathVariable Long scaleNumber) {
		return serproService.privateQuery("/escalas/" + scaleNumber);
	}
	
	@GetMapping("/manifestos/{manifestNumber}")
	public PrivateQueryGenericResponse getManifest(@PathVariable Long manifestNumber) {
		return serproService.privateQuery("/manifestos/" + manifestNumber);
	}
	
	@GetMapping("/conhecimentos-embarque/{billOfLadingNumber}")
	public PrivateQueryGenericResponse getBillOfLading(@PathVariable Long billOfLadingNumber) {
		return serproService.privateQuery("/conhecimentos-embarque/" + billOfLadingNumber);
	}
	
	@GetMapping("/conhecimentos-embarque/{billOfLadingNumber}/itens/{itemNumber}")
	public PrivateQueryGenericResponse getBillOfLadingItems(@PathVariable Long billOfLadingNumber, @PathVariable String itemNumber) {
		System.out.println("itemNumber: " + itemNumber);
		return serproService.privateQuery("/conhecimentos-embarque/" + billOfLadingNumber + "/itens/" + itemNumber);
	}
}
