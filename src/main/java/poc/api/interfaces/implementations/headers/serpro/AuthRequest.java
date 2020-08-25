package poc.api.interfaces.implementations.headers.serpro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import poc.api.interfaces.contracts.IGeneralRequest;

@Service("AuthRequest")
public class AuthRequest implements IGeneralRequest{

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
