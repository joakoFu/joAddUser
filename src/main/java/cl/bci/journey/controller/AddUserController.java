package cl.bci.journey.controller;

import cl.bci.journey.common.api.request.UserRequest;
import cl.bci.journey.common.api.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Validated
public class AddUserController {
    @RequestMapping(
            method = RequestMethod.POST,
            path = "/adduser",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest){
        UserResponse userResponse= new UserResponse();
        return ResponseEntity.ok(userResponse);
    }
}
