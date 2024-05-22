package group.intelliboys.cimsbackend.api.v1.user.services;

import group.intelliboys.cimsbackend.api.v1.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isUsernameExists(String username) {
        return userRepository.existsByUsername(username);
    }
}
