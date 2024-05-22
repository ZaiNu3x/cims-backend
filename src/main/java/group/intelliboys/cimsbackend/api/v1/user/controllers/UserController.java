package group.intelliboys.cimsbackend.api.v1.user.controllers;

import group.intelliboys.cimsbackend.api.v1.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/registration")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/find/exists/{username}")
    public ResponseEntity<Boolean> isUserExists(@PathVariable("username") String username) {
        System.out.println(username);
        boolean isExists = userService.isUsernameExists(username);
        return new ResponseEntity<>(isExists, HttpStatus.OK);
    }
}
