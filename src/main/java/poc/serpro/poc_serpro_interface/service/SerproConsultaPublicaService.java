package poc.serpro.poc_serpro_interface.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;

import poc.serpro.poc_serpro_interface.model.AuthResponse;
import reactor.core.publisher.Mono;

@Service
public class SerproConsultaPublicaService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	WebClient client;

	public Mono<String> obtainSecuredResource() {
		String encodedClientData = 
				Base64Utils.encodeToString("djaR21PGoYp1iyK2n2ACOH9REdUb:ObRsAJWOL4fv2Tp27D1vd8fB3Ote".getBytes());
		Mono<String> resource = client.post()
				.uri("https://hom-siscomex-sapi.estaleiro.serpro.gov.br/authenticate")
				.header("Authorization", "Basic " + encodedClientData)
				.body(BodyInserters.fromFormData("grant_type", "client_credentials"))
				.retrieve()
				.bodyToMono(JsonNode.class)
				.flatMap(tokenResponse -> {
					String accessTokenValue = tokenResponse.get("access_token")
							.textValue();
					return client.get()
							.uri("https://apigateway.serpro.gov.br/integra-comex-carga-hom/v1")
							.headers(h -> h.setBearerAuth(accessTokenValue))
							.retrieve()
							.bodyToMono(String.class);
				});
		return resource.map(res ->
		"Retrieved the resource using a manual approach: " + res);
	}


	public void buildRequest () {
		TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

		SSLContext sslContext;
		try {
			sslContext = org.apache.http.ssl.SSLContexts.custom()
					.loadTrustMaterial(null, acceptingTrustStrategy)
					.build();
			SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

			CloseableHttpClient httpClient = HttpClients.custom()
					.setSSLSocketFactory(csf)
					.build();

			HttpComponentsClientHttpRequestFactory requestFactory =
					new HttpComponentsClientHttpRequestFactory();

			requestFactory.setHttpClient(httpClient);

			restTemplate.setRequestFactory(requestFactory);

			String baseUrl = "https://siscomex-carga.estaleiro.serpro.gov.br/siscarga-api/escala";
			ResponseEntity<String> escalaMaritimaResponse = restTemplate.getForEntity(baseUrl + "/data-ultima-atualizacao?nr=20000076460", String.class);
			HttpStatus status = escalaMaritimaResponse.getStatusCode();

			System.out.println(status.name());
			System.out.println(status.ordinal());
		} catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
			e.printStackTrace();
		}
	}

	public void buildOAuthRequest () {
		
//	    try {
//	    	KeyStore clientStore = KeyStore.getInstance("PKCS12");
//	    	clientStore.load(new FileInputStream("C:\\Fiorde\\SERPRO\\CERTIFICADOS_HOM_INTEGRA_COMEX\\02_05202299168_HOMOLOGACAO.p12"), "123456".toCharArray());
//	    	
//	    	SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
//	    	sslContextBuilder.useProtocol("TLS");
//			sslContextBuilder.loadKeyMaterial(clientStore, "123456".toCharArray());
//			sslContextBuilder.loadTrustMaterial(new TrustSelfSignedStrategy());
//			
//			SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContextBuilder.build());
//		    CloseableHttpClient httpClient = HttpClients.custom()
//		            .setSSLSocketFactory(sslConnectionSocketFactory)
//		            .build();
//		    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//		    requestFactory.setConnectTimeout(10000); // 10 seconds
//		    requestFactory.setReadTimeout(10000); // 10 seconds
//		    
//		    restTemplate.setRequestFactory(requestFactory);
		    
		    String authUrl = "https://hom-siscomex-sapi.estaleiro.serpro.gov.br/authenticate";
		    HttpEntity<String> request = new HttpEntity<String>(createAuthHeaders());
		    ResponseEntity<AuthResponse> response = restTemplate.exchange(authUrl, HttpMethod.POST, request, AuthResponse.class);
		    System.out.println(response.getBody());
		    System.out.println(response.getStatusCodeValue());
		    
		    AuthResponse authResponse = response.getBody();
		    String baseUrl = "https://apigateway.serpro.gov.br/integra-comex-carga-hom/v1/escalas/18000009140";
		    request = new HttpEntity<String>(createHeaders(authResponse.getToken_type() + " " + authResponse.getAccess_token(), authResponse.getJwt_token()));
		    ResponseEntity<String> responseEscala = restTemplate.exchange(baseUrl, HttpMethod.GET, request, String.class);
		    System.out.println(responseEscala.getBody());
		    System.out.println(responseEscala.getStatusCodeValue());
		    
//		} catch (UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException | CertificateException | IOException | KeyManagementException e) {
//			e.printStackTrace();
//		}
	}

	public MultiValueMap<String, String> createAuthHeaders(){
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		String authHeader = "Basic NlhvWUlEUjIybWhrMWJlcV9kcVczMVR4NlhzYTpQSWk5YmdwVzJWczhUTkdLcFowTzZ4cHBGOEFh";
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		headers.set(HttpHeaders.AUTHORIZATION, authHeader);
		headers.set("Role-Type", "IMPEXP");
		return headers;
	}
	
	public MultiValueMap<String, String> createHeaders(String bearer, String jwtToken){
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		headers.set(HttpHeaders.AUTHORIZATION, bearer);
		headers.set("jwt_token", jwtToken);
		return headers;
	}

//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}

}
