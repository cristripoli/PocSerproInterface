package poc.api.interfaces.services.serpro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import poc.api.interfaces.contracts.IGeneralHeader;
import poc.api.interfaces.contracts.IGeneralRequest;
import poc.api.interfaces.model.serpro.PublicQueryResponse;
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
		ResponseEntity<String>  response = builder.executeRequest(completeURL, HttpMethod.GET, String.class , publicQueryHeader.buildHeader(null));
		
		//TO DO - Refactoring
		ObjectMapper objectMapper = new ObjectMapper();
		TypeFactory typeFactory = objectMapper.getTypeFactory();
		List<PublicQueryResponse> publicQueryResponses = null;
		try {
			publicQueryResponses = objectMapper.readValue(response.getBody(), typeFactory.constructCollectionType(List.class, PublicQueryResponse.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		publicQueryResponseRepository.saveAll(publicQueryResponses);
		return publicQueryResponses;
	}
	
}