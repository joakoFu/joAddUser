package cl.bci.journey.service;

import cl.bci.journey.common.api.response.JwtTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service

public interface JwtService {
    public Mono<JwtTokenResponse> validateToken(String token);
}
