package poc.serpro.poc_serpro_interface.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("serpro")
public class SerproConsultaPublicaController {

	@RequestMapping("hello")
	public String hello() {
		return "Hello Serpro";
	}
}
