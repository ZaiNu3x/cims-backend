package group.intelliboys.cimsbackend.api.v1.authentication.repositories;

import group.intelliboys.cimsbackend.api.v1.authentication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
