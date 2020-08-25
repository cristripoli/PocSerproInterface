package poc.serpro.poc_serpro_interface.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.serpro.poc_serpro_interface.service.RequestParameter;
import poc.serpro.poc_serpro_interface.service.SERPROPrivateQueryRequestService;
import poc.serpro.poc_serpro_interface.service.SerproConsultaPublicaService;

@RestController
@RequestMapping("serpro/private")
public class SERPROPrivateQueryRequestController {
	
	@Autowired
	private SERPROPrivateQueryRequestService serproService;

	@RequestMapping("hello")
	public String hello() {
		return "Hello Serpro Private";
	}
	
	@RequestMapping("escalaMaritima")
	public void escalaMaritima() {
//		serproService.buildRequest();
		serproService.privateQuery("/escalas/18000009140");
//		serproService.obtainSecuredResource();
	}
}
