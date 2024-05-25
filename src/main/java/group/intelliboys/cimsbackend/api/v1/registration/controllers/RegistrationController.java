package group.intelliboys.cimsbackend.api.v1.registration.controllers;

import group.intelliboys.cimsbackend.api.v1.user.models.User;
import group.intelliboys.cimsbackend.api.v1.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/registration/user")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<Boolean> saveUser(@RequestBody User user) {
        System.out.println("Called!");
        boolean isSuccess = userService.createUser(user);

        System.out.println(isSuccess);

        return new ResponseEntity<>(isSuccess, HttpStatus.OK);
    }
}
