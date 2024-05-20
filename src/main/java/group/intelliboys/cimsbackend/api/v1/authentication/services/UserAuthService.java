package group.intelliboys.cimsbackend.api.v1.authentication.services;

import group.intelliboys.cimsbackend.api.v1.authentication.models.LoginRequest;
import group.intelliboys.cimsbackend.api.v1.authentication.models.LoginResponse;
import group.intelliboys.cimsbackend.configs.security.jwt.services.JwtService;
import group.intelliboys.cimsbackend.configs.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtService jwtService;

    public LoginResponse doLogin(LoginRequest loginRequest) {

        try {
            UserDetails user = userDetailsService.loadUserByUsername(loginRequest.getUsername());

            boolean isPasswordMatches = BCrypt.checkpw(loginRequest.getPassword(), user.getPassword());

            if (isPasswordMatches) {
                String token = jwtService.generateToken(user);
                return new LoginResponse(token, "Authentication Success!");
            }
            else {
                return new LoginResponse(null, "Invalid Credentials!");
            }

        } catch (UsernameNotFoundException e) {
            return new LoginResponse(null, "Username not found!");
        }
    }
}
