package cl.bci.journey.service.impl;

import cl.bci.journey.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {
    @Override
    public String validateToken(String token) {
        return "hola";
    }
}
