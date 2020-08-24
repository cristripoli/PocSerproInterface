package poc.serpro.poc_serpro_interface.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AuthResponse implements Serializable {
	
	private static final long serialVersionUID = 8456537635254421137L;

	private String token_type;

	private String access_token;

	private String jwt_token;
	
	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getJwt_token() {
		return jwt_token;
	}

	public void setJwt_token(String jwt_token) {
		this.jwt_token = jwt_token;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Access Token: " + this.access_token);
		sb.append("JWT" + this.jwt_token);
		return sb.toString();
	}
}