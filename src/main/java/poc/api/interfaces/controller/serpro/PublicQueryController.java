package poc.api.interfaces.controller.serpro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.api.interfaces.model.RequestParameter;
import poc.api.interfaces.services.serpro.PublicQueryService;

@RestController
@RequestMapping("serpro")
public class PublicQueryController {
	
	@Autowired
	private PublicQueryService serproService;

	@RequestMapping("hello")
	public String hello() {
		return "Hello Serpro";
	}
	
	@RequestMapping("escalaMaritima")
	public void escalaMaritima() {
//		serproService.buildRequest();
		serproService.buildOAuthRequest();
//		serproService.obtainSecuredResource();
	}
}
