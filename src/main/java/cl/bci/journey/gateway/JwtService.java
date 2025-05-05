package cl.bci.journey.gateway;

import cl.bci.journey.common.api.response.JwtTokenResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service

public interface JwtService {
    public Mono<JwtTokenResponse> validateToken(String token);
    public Mono<JwtTokenResponse> generateToken(String token);
}
