package cl.bci.journey.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public interface JwtService {
    public String validateToken(String token);
}
