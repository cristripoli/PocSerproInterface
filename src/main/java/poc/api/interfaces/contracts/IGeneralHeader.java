package poc.api.interfaces.contracts;

import java.util.List;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import poc.api.interfaces.model.RequestParameter;

public interface IGeneralHeader {
	
	public MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
	
	public MultiValueMap<String, String> buildHeader(List<RequestParameter> headerParams);
}
