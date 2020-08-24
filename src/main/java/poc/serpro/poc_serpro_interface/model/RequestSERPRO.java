package poc.serpro.poc_serpro_interface.model;

import org.springframework.beans.factory.annotation.Value;

public class RequestSERPRO extends GeneralRequestImpl{

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
