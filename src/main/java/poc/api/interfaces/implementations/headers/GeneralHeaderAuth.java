package poc.api.interfaces.implementations.headers;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

import poc.api.interfaces.model.RequestParameter;

public abstract class GeneralHeaderAuth extends GeneralHeaderImpl {
	
	@Override
	public MultiValueMap<String, String> buildHeader(List<RequestParameter> headerParams) {
	
		if(headerParams == null){
			headerParams = new ArrayList<>();
		}
		
		String authParam = generateAuthorizationParam();
		
		headerParams.add(new RequestParameter(HttpHeaders.AUTHORIZATION, authParam));
	
		return super.buildHeader(headerParams);
	}

	private String generateAuthorizationParam() {
		String auth = getUsername() + ":" + getPassword();
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
		return "Basic " + new String(encodedAuth);
	}
	
	public abstract String getUsername();
	public abstract String getPassword();
}
