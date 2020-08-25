package poc.api.interfaces.services.serpro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import poc.api.interfaces.contracts.IGeneralHeader;
import poc.api.interfaces.contracts.IGeneralRequest;
import poc.api.interfaces.model.serpro.AuthResponse;
import poc.api.interfaces.services.RequestBuilder;

@Service
public class AuthenticationService {

	@Autowired
	private RequestBuilder builder;
	
	@Autowired
	@Qualifier("AuthHeader")
	private IGeneralHeader authHeader;
	
	@Autowired
	@Qualifier("AuthRequest")
	private IGeneralRequest authRequest;
	
	private ResponseEntity<AuthResponse> authResponse;


	public ResponseEntity<AuthResponse> getAuthentication() {
		authResponse = builder.executeRequest(authRequest.getBaseURL(), HttpMethod.POST, AuthResponse.class, authHeader.buildHeader(null));
	    return authResponse;
	}
	
	public ResponseEntity<AuthResponse> getAuthResponse() {
		return authResponse;
	}


	public void setAuthResponse(ResponseEntity<AuthResponse> authResponse) {
		this.authResponse = authResponse;
	}
}