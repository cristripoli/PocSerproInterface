package poc.api.interfaces.services.serpro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import poc.api.interfaces.contracts.IGeneralHeader;
import poc.api.interfaces.contracts.IGeneralRequest;
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
	

	public String publicQuery(String resource) {
		String completeURL = this.publicQueryRequest.getBaseURL() + resource;
		ResponseEntity<String>  response = builder.executeRequest(completeURL, HttpMethod.GET, String.class, publicQueryHeader.buildHeader(null));
		return response.getBody();
	}
}