package poc.serpro.poc_serpro_interface.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import poc.serpro.poc_serpro_interface.model.AuthResponse;
import poc.serpro.poc_serpro_interface.model.RequestBuilder;

@Service
public class SerproAuthService {

	@Autowired
	private RequestBuilder builder;
	
	@Value("${client.serpro.base-url.auth}")
	private String baseUrlAuth;


	public AuthResponse getAuthentication() {
		ResponseEntity<AuthResponse> response = builder.executeRequest(this.baseUrlAuth, HttpMethod.POST, AuthResponse.class);
	    return response.getBody();
	}
}