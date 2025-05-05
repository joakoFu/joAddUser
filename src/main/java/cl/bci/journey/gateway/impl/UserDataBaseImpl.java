package cl.bci.journey.gateway.impl;

import cl.bci.journey.common.api.request.UserDataBaseRequest;
import org.springframework.http.HttpStatus;
import cl.bci.journey.common.api.response.UserDataBaseResponse;
import cl.bci.journey.gateway.UserDataBase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class UserDataBaseImpl implements UserDataBase {

    private final WebClient webClient;

    public UserDataBaseImpl(@Qualifier("webDataBase")WebClient webClient) {
        this.webClient = webClient;
    }


    @Override
    public Mono<UserDataBaseResponse> addUser(UserDataBaseRequest request) {
        return webClient.post()
                .uri("/user")
                .header("Content-Type", "application/json")
                .bodyValue(request)
                .retrieve()
                .onStatus(response -> response.is4xxClientError(), response ->
                        response.bodyToMono(String.class).flatMap(errorBody ->
                                Mono.error(new RuntimeException("Client error: " + errorBody))
                        )
                )
                .onStatus(response -> response.is5xxServerError(), response ->
                        response.bodyToMono(String.class).flatMap(errorBody ->
                                Mono.error(new RuntimeException("Server error: " + errorBody))
                        )
                )
                .bodyToMono(UserDataBaseResponse.class);
    }
}
