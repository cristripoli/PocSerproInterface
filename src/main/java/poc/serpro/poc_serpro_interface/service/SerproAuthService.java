package poc.serpro.poc_serpro_interface.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import poc.serpro.poc_serpro_interface.model.AuthResponse;
import poc.serpro.poc_serpro_interface.model.IGeneralHeader;
import poc.serpro.poc_serpro_interface.model.IGeneralRequest;
import poc.serpro.poc_serpro_interface.model.RequestBuilder;

@Service
public class SerproAuthService {

	@Autowired
	private RequestBuilder builder;
	
	@Autowired
	@Qualifier("HeaderAuthSERPRO")
	private IGeneralHeader authHeader;
	
	@Autowired
	@Qualifier("RequestAuthSERPRO")
	private IGeneralRequest authRequest;
	
	private ResponseEntity<AuthResponse> authResponse;


	public ResponseEntity<AuthResponse> getAuthentication() {
		authResponse = builder.executeRequest(authRequest.getBaseURL(), HttpMethod.POST, AuthResponse.class, authHeader.buildHeader(null));
	    return authResponse;
	}
	
	public ResponseEntity<AuthResponse> getAuthenticationWithUpdateHeaders(){
		ResponseEntity<AuthResponse> authResponse = getAuthentication();
		HttpHeaders headers = authResponse.getHeaders();
		
		AuthResponse response = authResponse.getBody();
		
		
		headers.set(HttpHeaders.AUTHORIZATION, response.getToken_type() + " " + response.getAccess_token());
		headers.set("jwt_token", response.getJwt_token());
		
		return authResponse;
	}

	public ResponseEntity<AuthResponse> getAuthResponse() {
		return authResponse;
	}


	public void setAuthResponse(ResponseEntity<AuthResponse> authResponse) {
		this.authResponse = authResponse;
	}
}