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
import poc.api.interfaces.entities.serpro.PrivateQueryBillOfLadingItemResponse;
import poc.api.interfaces.entities.serpro.PrivateQueryBillOfLadingResponse;
import poc.api.interfaces.entities.serpro.PrivateQueryGenericResponse;
import poc.api.interfaces.entities.serpro.PrivateQueryManifestResponse;
import poc.api.interfaces.entities.serpro.PrivateQuerySeaScaleResponse;
import poc.api.interfaces.model.RequestParameter;
import poc.api.interfaces.model.serpro.AuthResponse;
import poc.api.interfaces.repository.IPrivateQueryBillOfLadingItemResponseRepository;
import poc.api.interfaces.repository.IPrivateQueryBillOfLadingResponseRepository;
import poc.api.interfaces.repository.IPrivateQueryManifestResponseRepository;
import poc.api.interfaces.repository.IPrivateQueryResponseRepository;
import poc.api.interfaces.repository.IPrivateQuerySeaScaleResponseRepository;
import poc.api.interfaces.services.RequestService;

@Service
public class PrivateQueryService {

	@Autowired
	private AuthenticationService serproAuthService;
	
	@Autowired
	private IPrivateQueryResponseRepository privateQueryResponseRepository;
	
	@Autowired
	private IPrivateQueryManifestResponseRepository privateQueryManifestQueryResponseRepository;
	
	@Autowired
	private IPrivateQuerySeaScaleResponseRepository privateSeaScaleQueryResponseRepository;
	
	@Autowired
	private IPrivateQueryBillOfLadingResponseRepository privateyBillOfLadingQueryResponseRepository;
	
	@Autowired
	private IPrivateQueryBillOfLadingItemResponseRepository privateyBillOfLadingItemQueryResponseRepository;
	
	@Autowired
	@Qualifier("PrivateQueryHeader")
	private IGeneralHeader privateQueryHeader;

	@Autowired
	@Qualifier("PrivateQueryRequest")
	private IGeneralRequest privateQueryRequest;
	
	@Autowired
	private RequestService builder;

	public <T extends PrivateQueryGenericResponse> T privateQuery(String resource, Class<T> type) {
		ResponseEntity<AuthResponse> authResponse = serproAuthService.getAuthentication();

		String completeURL = privateQueryRequest.getBaseURL() + resource;
		ResponseEntity<T> response = builder.executeRequest(completeURL, HttpMethod.GET,
				type,
				privateQueryHeader.buildHeader(createHeader(authResponse.getBody())));
		
		T queryGenericResponse = response.getBody();
		
		privateQueryResponseRepository.save(queryGenericResponse);
		
		return queryGenericResponse;
	}
	
	public List<RequestParameter> createHeader(AuthResponse resp) {
		List<RequestParameter> params = new ArrayList<RequestParameter>();
		params.add(new RequestParameter(HttpHeaders.AUTHORIZATION, resp.getTokenType() + " " + resp.getAccessToken()));
		params.add(new RequestParameter("jwt_token", resp.getJwtToken()));
		return params;
	}
	
	public List<PrivateQueryManifestResponse> findAllManifest() {
		return privateQueryManifestQueryResponseRepository.findAll();
	}
	
	public List<PrivateQuerySeaScaleResponse> findAllSeaScale() {
		return privateSeaScaleQueryResponseRepository.findAll();
	}
	
	public List<PrivateQueryBillOfLadingResponse> findAllBillOfLanding() {
		return privateyBillOfLadingQueryResponseRepository.findAll();
	}
	
	public List<PrivateQueryBillOfLadingItemResponse> findAllBillOfLandingItem() {
		return privateyBillOfLadingItemQueryResponseRepository.findAll();
	}
}