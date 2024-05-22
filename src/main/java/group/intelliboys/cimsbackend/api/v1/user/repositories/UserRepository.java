package group.intelliboys.cimsbackend.api.v1.user.repositories;

import group.intelliboys.cimsbackend.api.v1.authentication.dto.UserAuthDto;
import group.intelliboys.cimsbackend.api.v1.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT new group.intelliboys.cimsbackend.api.v1.authentication.dto.UserAuthDto(u.username, u.password, u.role) FROM User u WHERE username = ?1")
    Optional<UserAuthDto> findByUsername(String username);

    boolean existsByUsername(String username);
}
