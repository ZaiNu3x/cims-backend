package group.intelliboys.cimsbackend.api.v1.authentication.controllers;

import group.intelliboys.cimsbackend.api.v1.authentication.models.LoginRequest;
import group.intelliboys.cimsbackend.api.v1.authentication.models.LoginResponse;
import group.intelliboys.cimsbackend.api.v1.authentication.services.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserAuthService userAuthService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginRequest) {

        LoginResponse loginResponse = userAuthService.doLogin(loginRequest);

        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }
}
