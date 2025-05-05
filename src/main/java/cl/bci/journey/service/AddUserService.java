package cl.bci.journey.service;

import cl.bci.journey.common.api.request.UserRequest;
import cl.bci.journey.common.api.response.JwtTokenResponse;
import cl.bci.journey.common.api.response.UserDataBaseResponse;
import cl.bci.journey.common.api.response.UserResponse;
import cl.bci.journey.gateway.JwtService;
import cl.bci.journey.gateway.UserDataBase;
import cl.bci.journey.service.map.UserMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@AllArgsConstructor
public class AddUserService {
    public final UserDataBase userDataBase;
    public final JwtService jwtService;
    private static final Logger logger = LoggerFactory.getLogger(AddUserService.class);

    public UserResponse addUser(UserRequest userRequest){
        UserDataBaseResponse userDataBaseResponse = userDataBase.addUser(UserMapper.toDataBaseRequest(userRequest)).block();
        //genero token
        JwtTokenResponse jwtTokenResponse = jwtService.generateToken(userRequest.getEmail()).block();

        logger.info(userDataBaseResponse.toString());

        return UserResponse.builder()
                .activo(true)
                .id(userDataBaseResponse.getId())
                .creado(userDataBaseResponse.getFechaCreacion())
                .modificado(userDataBaseResponse.getFechaCreacion())
                .ultimoLogin(userDataBaseResponse.getFechaUltimoLogin())
                .token(jwtTokenResponse.getToken())
                .build();
    }

}
