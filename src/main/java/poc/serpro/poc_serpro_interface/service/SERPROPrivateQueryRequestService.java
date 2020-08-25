package poc.serpro.poc_serpro_interface.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import poc.serpro.poc_serpro_interface.model.AuthResponse;
import poc.serpro.poc_serpro_interface.model.IGeneralHeader;
import poc.serpro.poc_serpro_interface.model.IGeneralRequest;
import poc.serpro.poc_serpro_interface.model.RequestBuilder;

@Service
public class SERPROPrivateQueryRequestService {

	@Autowired
	private SerproAuthService serproAuthService;
	
	@Autowired
	@Qualifier("SERPROPrivateQueryHeader")
	private IGeneralHeader privateQueryHeader;
	
	@Autowired
	@Qualifier("SERPROPrivateQueryRequest")
	private IGeneralRequest privateQueryRequest;
	
	@Autowired
	private RequestBuilder builder;
	
	@Value("${client.serpro.base-url.integra-comex}")
	private String baseUrl;

	public String privateQuery(String resource) {
		ResponseEntity<AuthResponse> authResponse = serproAuthService.getAuthentication();
		
		String completeURL = this.baseUrl + resource;
		ResponseEntity<String>  response = builder.executeRequest(completeURL, HttpMethod.GET, String.class, privateQueryHeader.buildHeader(createHeader(authResponse.getBody())));
		return response.getBody();
	}
	
	public List<RequestParameter> createHeader(AuthResponse resp) {
		List<RequestParameter> params = new ArrayList<RequestParameter>();
		params.add(new RequestParameter(HttpHeaders.AUTHORIZATION, resp.getToken_type() + " " + resp.getAccess_token()));
		params.add(new RequestParameter("jwt_token", resp.getJwt_token()));
		return params;
	}
}