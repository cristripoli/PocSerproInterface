package poc.serpro.poc_serpro_interface.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestBuilder {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private IGeneralHeader headerGenerator;
	
	private IGeneralRequest requestGenerator;
	
	public <T> ResponseEntity<T> executeRequest(String url, HttpMethod method, Class<T> returnType ){
	    HttpEntity<T> request = new HttpEntity<T>(headerGenerator.buildHeader(null));
	    ResponseEntity<T> response = restTemplate.exchange(requestGenerator.getBaseURL(), method, request, returnType);
		return response;
	}
}
