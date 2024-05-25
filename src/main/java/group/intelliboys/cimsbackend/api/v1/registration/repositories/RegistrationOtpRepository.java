package group.intelliboys.cimsbackend.api.v1.registration.repositories;

import group.intelliboys.cimsbackend.api.v1.registration.models.RegistrationOtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RegistrationOtpRepository extends JpaRepository<RegistrationOtp, String> {
    Optional<RegistrationOtp> findByFormIdAndOtp(String formId, String otp);
    boolean existsByFormIdAndOtp(String formId, String otp);
}
