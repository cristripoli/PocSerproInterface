package poc.serpro.poc_serpro_interface.model;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import poc.serpro.poc_serpro_interface.service.RequestParameter;

public abstract class GeneralHeaderImpl implements IGeneralHeader {

	@Override
	public MultiValueMap<String, String> buildHeader(List<RequestParameter> headerParams) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

		for(RequestParameter param : headerParams) {
			headers.set(param.getName(), param.getValue());
		}
		
		return headers;
	}
}
