package poc.api.interfaces.model.serpro;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AuthResponse implements Serializable {
	
	private static final long serialVersionUID = 6241127618803270842L;

	@JsonProperty("token_type")
	private String tokenType;

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("jwt_token")
	private String jwtToken;
}