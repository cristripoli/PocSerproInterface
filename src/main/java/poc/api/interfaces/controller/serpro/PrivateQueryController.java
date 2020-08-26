package poc.api.interfaces.controller.serpro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.api.interfaces.services.serpro.PrivateQueryService;

@RestController
@RequestMapping("v1/serpro/consulta-restrita")
public class PrivateQueryController {
	
	@Autowired
	private PrivateQueryService serproService;


	@GetMapping("/escalas/{scaleNumber}")
	public String getSeaScale(@PathVariable Long scaleNumber) {
		return serproService.privateQuery("/escalas/" + scaleNumber).toString();
	}
	
	@GetMapping("/manifestos/{manifestNumber}")
	public String getManifest(@PathVariable Long manifestNumber) {
		return serproService.privateQuery("/manifestos/" + manifestNumber).toString();
	}
	
	@GetMapping("/conhecimentos-embarque/{billOfLadingNumber}")
	public String getBillOfLading(@PathVariable Long billOfLadingNumber) {
		return serproService.privateQuery("/conhecimentos-embarque/" + billOfLadingNumber).toString();
	}
	
	@GetMapping("/conhecimentos-embarque/{billOfLadingNumber}/itens/{itemNumber}")
	public String getBillOfLadingItems(@PathVariable Long billOfLadingNumber, @PathVariable String itemNumber) {
		System.out.println("itemNumber: " + itemNumber);
		return serproService.privateQuery("/conhecimentos-embarque/" + billOfLadingNumber + "/itens/" + itemNumber).toString();
	}
}
