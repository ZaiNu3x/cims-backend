package group.intelliboys.cimsbackend.api.v1.registration.services;

import group.intelliboys.cimsbackend.api.v1.registration.models.RegistrationOtp;
import group.intelliboys.cimsbackend.api.v1.registration.repositories.RegistrationOtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistrationOtpService {
    @Autowired
    private RegistrationOtpRepository registrationOtpRepository;

    public boolean createRegistrationOtp(String formId, String otp) {
        try {
            RegistrationOtp registrationOtp = RegistrationOtp.builder()
                    .formId(formId)
                    .otp(otp)
                    .dateCreated(LocalDateTime.now())
                    .build();

            registrationOtpRepository.save(registrationOtp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validateOtp(String formId, String otp) {
        return registrationOtpRepository.existsByFormIdAndOtp(formId, otp);
    }
}
