package poc.api.interfaces.controller.serpro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.api.interfaces.services.serpro.PrivateQueryService;

@RestController
@RequestMapping("serpro/private")
public class PrivateQueryController {
	
	@Autowired
	private PrivateQueryService serproService;

	@RequestMapping("hello")
	public String hello() {
		return "Hello Serpro Private";
	}
	
	@RequestMapping("escalaMaritima")
	public void escalaMaritima() {
//		serproService.buildRequest();
		System.out.println(serproService.privateQuery("/escalas/18000009140"));
//		serproService.obtainSecuredResource();
	}
}
