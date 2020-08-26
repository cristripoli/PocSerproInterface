package poc.api.interfaces.services.serpro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import poc.api.interfaces.contracts.IGeneralHeader;
import poc.api.interfaces.contracts.IGeneralRequest;
import poc.api.interfaces.entities.serpro.PrivateQueryGenericResponse;
import poc.api.interfaces.model.RequestParameter;
import poc.api.interfaces.model.serpro.AuthResponse;
import poc.api.interfaces.repository.IPrivateQueryResponseRepository;
import poc.api.interfaces.services.RequestBuilder;

@Service
public class PrivateQueryService {

	@Autowired
	private AuthenticationService serproAuthService;
	
	@Autowired
	private IPrivateQueryResponseRepository privateQueryResponseRepository;

	@Autowired
	@Qualifier("PrivateQueryHeader")
	private IGeneralHeader privateQueryHeader;

	@Autowired
	@Qualifier("PrivateQueryRequest")
	private IGeneralRequest privateQueryRequest;
	
	@Autowired
	private RequestBuilder builder;

	public PrivateQueryGenericResponse privateQuery(String resource) {
		ResponseEntity<AuthResponse> authResponse = serproAuthService.getAuthentication();

		String completeURL = privateQueryRequest.getBaseURL() + resource;
		ResponseEntity<PrivateQueryGenericResponse> response = builder.executeRequest(completeURL, HttpMethod.GET,
				PrivateQueryGenericResponse.class,
				privateQueryHeader.buildHeader(createHeader(authResponse.getBody())));
		
		PrivateQueryGenericResponse queryGenericResponse = response.getBody();
		
		privateQueryResponseRepository.save(queryGenericResponse);
		
		return queryGenericResponse;
	}

	public List<RequestParameter> createHeader(AuthResponse resp) {
		List<RequestParameter> params = new ArrayList<RequestParameter>();
		params.add(new RequestParameter(HttpHeaders.AUTHORIZATION, resp.getTokenType() + " " + resp.getAccessToken()));
		params.add(new RequestParameter("jwt_token", resp.getJwtToken()));
		return params;
	}
}