package poc.api.interfaces.implementations.headers.serpro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import poc.api.interfaces.implementations.headers.GeneralHeaderAuth;
import poc.api.interfaces.model.RequestParameter;

@Component("AuthHeader")
public class AuthHeader extends GeneralHeaderAuth {
	
	@Value("${client.registration.client-id}")
	private String username;
	
	@Value("${client.registration.client-secret}")
	private String password;
	
	@Override
	public MultiValueMap<String, String> buildHeader(List<RequestParameter> headerParams) {
		
		if(headerParams == null){
			headerParams = new ArrayList<RequestParameter>();
		}
		
		headerParams.add(new RequestParameter("Role-Type", "IMPEXP"));
		
		return super.buildHeader(headerParams);
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
