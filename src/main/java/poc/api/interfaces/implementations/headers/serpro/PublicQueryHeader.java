package poc.api.interfaces.implementations.headers.serpro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import poc.api.interfaces.implementations.headers.GeneralHeaderImpl;
import poc.api.interfaces.model.RequestParameter;


@Component("PublicQueryHeader")
public class PublicQueryHeader extends GeneralHeaderImpl {
	
	@Override
	public MultiValueMap<String, String> buildHeader(List<RequestParameter> headerParams) {
		
		if(headerParams == null){
			headerParams = new ArrayList<RequestParameter>();
		}
		
		return super.buildHeader(headerParams);
	}
}
