package poc.serpro.poc_serpro_interface.model;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

import poc.serpro.poc_serpro_interface.service.RequestParameter;

public abstract class GeneralHeaderAuth extends GeneralHeaderImpl {
	
	@Override
	public MultiValueMap<String, String> buildHeader(List<RequestParameter> headerParams) {
	
		if(headerParams == null){
			headerParams = new ArrayList<RequestParameter>();
		}
		
		String authParam = generateAuthorizationParam();
		
		headerParams.add(new RequestParameter(HttpHeaders.AUTHORIZATION, authParam));
	
		return super.buildHeader(headerParams);
	}

	private String generateAuthorizationParam() {
		String auth = getUsername() + ":" + getPassword();
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(encodedAuth);
	}
	
	public abstract String getUsername();
	public abstract String getPassword();
}
