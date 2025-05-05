package cl.bci.journey.service.map;

import cl.bci.journey.common.api.request.PhoneDataBaseRequest;
import cl.bci.journey.common.api.request.UserDataBaseRequest;
import cl.bci.journey.common.api.request.UserRequest;

import java.util.List;

public class UserMapper {
    public static UserDataBaseRequest toDataBaseRequest(UserRequest request) {
        if (request == null) return null;

        List<PhoneDataBaseRequest> phones = null;
        if (request.getPhones() != null) {
            phones = request.getPhones().stream()
                    .map(phoneReq -> PhoneDataBaseRequest.builder()
                            .numero(phoneReq.getNumber())
                            .codigoCiudad(phoneReq.getCitycode())
                            .codigoPais(phoneReq.getCountrycode())
                            .build())
                    .toList();
        }

        return UserDataBaseRequest.builder()
                .name(request.getName())
                .mail(request.getEmail())        // map email → mail
                .pass(request.getPassword())     // map password → pass
                .phoneRequestList(phones)
                .build();
    }
}
