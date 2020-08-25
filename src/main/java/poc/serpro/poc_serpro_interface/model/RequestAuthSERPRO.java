package poc.serpro.poc_serpro_interface.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("RequestAuthSERPRO")
public class RequestAuthSERPRO extends GeneralRequestImpl{

	@Value("${client.serpro.base-url.auth}")
	private String baseURL;
	
	@Override
	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

}
