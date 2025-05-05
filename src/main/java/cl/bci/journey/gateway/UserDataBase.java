package cl.bci.journey.gateway;

import cl.bci.journey.common.api.request.UserDataBaseRequest;
import cl.bci.journey.common.api.response.UserDataBaseResponse;
import reactor.core.publisher.Mono;


public interface UserDataBase {
    public Mono<UserDataBaseResponse> addUser(UserDataBaseRequest token);

}
