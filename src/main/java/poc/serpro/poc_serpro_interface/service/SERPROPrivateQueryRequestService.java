package poc.serpro.poc_serpro_interface.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import poc.serpro.poc_serpro_interface.enums.KeyStoreTypeEnum;
import poc.serpro.poc_serpro_interface.model.AuthResponse;
import poc.serpro.poc_serpro_interface.model.RequestBuilder;

public abstract class SERPROPrivateQueryRequestService {

	@Autowired
	private SerproAuthService serproAuthService;
	
	@Autowired
	private RequestBuilder builder;
	
	@Value("${client.serpro.base-url.integra-comex}")
	private String baseUrl;

	public String privateQuery(String resource) {
		AuthResponse authResponse = serproAuthService.getAuthentication();
		
		builder.b
		String completeURL = this.baseUrl + resource;
		ResponseEntity<String>  response = builder.executeRequest(completeURL, HttpMethod.GET, String.class);
		return response.getBody();
	}
}