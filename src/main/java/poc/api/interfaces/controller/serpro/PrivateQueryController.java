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


	@GetMapping("/escalas/{numeroEscala}")
	public String escalaMaritima(@PathVariable Long numeroEscala) {
		return serproService.privateQuery("/escalas/" + numeroEscala);
	}
}
