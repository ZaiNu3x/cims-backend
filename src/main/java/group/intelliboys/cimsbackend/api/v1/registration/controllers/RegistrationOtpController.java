package group.intelliboys.cimsbackend.api.v1.registration.controllers;

import group.intelliboys.cimsbackend.api.v1.registration.services.RegistrationOtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/registration/otp")
public class RegistrationOtpController {

    @Autowired
    private RegistrationOtpService registrationOtpService;

    @GetMapping("validate/{formId}/{otp}")
    public ResponseEntity<Boolean> isOtpValid(@PathVariable("formId") String formId, @PathVariable("otp") String otp) {
        boolean isValid = registrationOtpService.validateOtp(formId, otp);

        return new ResponseEntity<>(isValid, HttpStatus.OK);
    }
}
