package poc.serpro.poc_serpro_interface.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SerproConsultaPublicaService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	

}
