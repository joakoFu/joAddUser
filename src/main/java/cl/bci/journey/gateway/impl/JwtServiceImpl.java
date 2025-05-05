package cl.bci.journey.gateway.impl;

import cl.bci.journey.common.api.response.JwtTokenResponse;
import cl.bci.journey.gateway.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Qualifier;


@Service

public class JwtServiceImpl implements JwtService {


    private final WebClient webClient;

    public JwtServiceImpl(@Qualifier("authClient")WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<JwtTokenResponse> validateToken(String token) {
        return webClient.get()
                .uri("/tokenValidator")
                .header("Content-Type","application/json")
                .header("token",token)
                .retrieve()
                .bodyToMono(JwtTokenResponse.class);
    }

    @Override
    public Mono<JwtTokenResponse> generateToken(String token) {
        return webClient.post()
                .uri("/tokenGeneration")
                .header("Content-Type","application/json")
                .header("rut-client",token)
                .retrieve()
                .bodyToMono(JwtTokenResponse.class);
    }
}
