package poc.serpro.poc_serpro_interface.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.serpro.poc_serpro_interface.service.RequestParameter;
import poc.serpro.poc_serpro_interface.service.SerproConsultaPublicaService;

@RestController
@RequestMapping("serpro")
public class SerproConsultaPublicaController {
	
	@Autowired
	private SerproConsultaPublicaService serproService;

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
