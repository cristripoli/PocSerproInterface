package poc.api.interfaces.controller.serpro;

import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import poc.api.interfaces.services.serpro.PublicQueryService;

@RestController
@RequestMapping("v1/serpro/consulta-publica")
public class PublicQueryController {
	
	@Autowired
	private PublicQueryService serproService;


	@GetMapping("/escalas")
	public String listLastUpdateSeaScalesDate(@RequestParam List<String> nr) {
		String queryParameters = String.join("&nr=", nr);
		return serproService.publicQuery("/escala/data-ultima-atualizacao?nr=" + queryParameters);
	}
	
	@GetMapping("/manifestos")
	public String listLastUpdateManifestsDate(@RequestParam List<String> nr) {
		String queryParameters = String.join("&nr=", nr);
		return serproService.publicQuery("/manifesto/data-ultima-atualizacao?nr=" + queryParameters);
	}
	
	@GetMapping("/conhecimentos-embarque")
	public String listLastUpdateBillsOfLadingDate(@RequestParam List<String> nr) {
		String queryParameters = String.join("&nr=", nr);
		return serproService.publicQuery("/ce/data-ultima-atualizacao?nr=" + queryParameters);
	}
}
