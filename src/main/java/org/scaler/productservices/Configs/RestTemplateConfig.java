package org.scaler.productservices.Configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplate() {
//        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
//        //requestFactory.setReadTimeout(600000);
//        requestFactory.setConnectTimeout(600000);
//        return new RestTemplate(requestFactory);
        return new RestTemplateBuilder().build();
    }
}
