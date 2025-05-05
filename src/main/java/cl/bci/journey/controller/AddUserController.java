package cl.bci.journey.controller;

import cl.bci.journey.common.api.request.UserRequest;
import cl.bci.journey.common.api.response.UserResponse;
import cl.bci.journey.service.AddUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Controller
@Validated
@AllArgsConstructor
public class AddUserController {

    private final AddUserService addUserService;
    @RequestMapping(
           method = RequestMethod.POST,
           path = "/adduser",
           consumes = "application/json",
           produces = "application/json"
    )
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.ok(addUserService.addUser(userRequest));
    }
}
