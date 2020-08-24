package poc.serpro.poc_serpro_interface.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.MultiValueMap;

import poc.serpro.poc_serpro_interface.service.RequestParameter;

public class HeaderGeneralSERPRO extends GeneralHeaderAuth {
	
	@Value("{client.registration.client-id}")
	private String username;
	
	@Value("{client.registration.client-secret}")
	private String password;
	
	@Override
	public MultiValueMap<String, String> buildHeader(List<RequestParameter> headerParams) {
		List<RequestParameter> params = new ArrayList<RequestParameter>();
		
		if(headerParams == null){
			headerParams = new ArrayList<RequestParameter>();
		}
		
		headerParams.add(new RequestParameter("Role-Type", "IMPEXP"));
		
		return super.buildHeader(params);
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}
}
