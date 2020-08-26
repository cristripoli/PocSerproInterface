package poc.api.interfaces.config;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
	
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

	   List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
	   MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	   converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
	   messageConverters.add(converter);

        return builder
               .setConnectTimeout(Duration.ofMillis(3000))
               .setReadTimeout(Duration.ofMillis(3000))
               .additionalMessageConverters(messageConverters)
               .build();
    }
}
