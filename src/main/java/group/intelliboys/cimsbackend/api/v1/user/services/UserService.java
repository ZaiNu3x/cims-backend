package group.intelliboys.cimsbackend.api.v1.user.services;

import group.intelliboys.cimsbackend.api.v1.registration.services.RegistrationOtpService;
import group.intelliboys.cimsbackend.api.v1.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private RegistrationOtpService registrationOtpService;

    public boolean isUsernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean isEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean sendOtp(String formId, String email) {
        if (!isEmailExists(email)) {

            try {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(email);
                message.setSubject("Registration OTP");

                String otp = generateOtp();
                message.setText(otp);
                emailSender.send(message);

                registrationOtpService.createRegistrationOtp(formId, otp);

                return true;
            } catch (Exception e) {
                System.out.println("Internal Error!");
                return false;
            }

        } else {
            return false;
        }
    }

    private String generateOtp() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();

        Collection<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            int randomNum = random.nextInt(0, 9);

            otp.append(randomNum);
        }

        return new String(otp);
    }
}
