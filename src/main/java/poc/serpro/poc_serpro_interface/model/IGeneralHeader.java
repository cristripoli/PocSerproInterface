package poc.serpro.poc_serpro_interface.model;

import java.util.List;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import poc.serpro.poc_serpro_interface.service.RequestParameter;

public interface IGeneralHeader {
	
	public MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
	
	public MultiValueMap<String, String> buildHeader(List<RequestParameter> headerParams);
}
