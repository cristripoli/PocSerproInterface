package poc.api.interfaces.services.serpro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import poc.api.interfaces.contracts.IGeneralHeader;
import poc.api.interfaces.contracts.IGeneralRequest;
import poc.api.interfaces.entities.serpro.PublicQueryResponse;
import poc.api.interfaces.repository.IPublicQueryResponseRepository;
import poc.api.interfaces.services.RequestBuilder;

@Service
public class PublicQueryService {

	@Autowired
	@Qualifier("PublicQueryHeader")
	private IGeneralHeader publicQueryHeader;

	@Autowired
	@Qualifier("PublicQueryRequest")
	private IGeneralRequest publicQueryRequest;

	@Autowired
	private RequestBuilder builder;

	@Autowired
	private IPublicQueryResponseRepository publicQueryResponseRepository;

	public List<PublicQueryResponse> publicQuery(String resource) {
		String completeURL = this.publicQueryRequest.getBaseURL() + resource;
		ResponseEntity<List<PublicQueryResponse>> response = builder.executeRequest(completeURL, HttpMethod.GET,
				new ParameterizedTypeReference<List<PublicQueryResponse>>() {
				}, publicQueryHeader.buildHeader(null));
		List<PublicQueryResponse> publicQueryResponses = response.getBody();

		publicQueryResponseRepository.saveAll(publicQueryResponses);
		return publicQueryResponses;
	}
}