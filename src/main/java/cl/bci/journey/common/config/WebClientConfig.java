package cl.bci.journey.common.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    @Qualifier("authClient")
    public WebClient authClient(WebClient.Builder builder) {
        return builder.baseUrl("http://localhost:8081").build();
    }

    @Bean
    @Qualifier("webDataBase")
    public WebClient webDataBase(WebClient.Builder builder) {
        return builder.baseUrl("http://localhost:8082").build();
    }

}
