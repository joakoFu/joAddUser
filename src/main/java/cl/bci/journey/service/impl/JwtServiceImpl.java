package cl.bci.journey.service.impl;

import cl.bci.journey.common.api.response.JwtTokenResponse;
import cl.bci.journey.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.http.MediaType;


@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {
    private final WebClient webClient;
    @Override
    public Mono<JwtTokenResponse> validateToken(String token) {
        return webClient.get()
                .uri("/tokenValidator")
                .header("Content-Type","application/json")
                .header("token",token)
                .retrieve()
                .bodyToMono(JwtTokenResponse.class);
    }
}
