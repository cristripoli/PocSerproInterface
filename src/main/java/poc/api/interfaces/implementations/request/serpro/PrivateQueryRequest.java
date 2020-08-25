package poc.api.interfaces.implementations.request.serpro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import poc.api.interfaces.contracts.IGeneralRequest;

@Service("PrivateQueryRequest")
public class PrivateQueryRequest implements IGeneralRequest{

	@Value("${client.serpro.base-url.integra-comex}")
	private String baseURL;
	
	@Override
	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

}
