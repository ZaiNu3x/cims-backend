package group.intelliboys.cimsbackend.api.v1.registration.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "registration_otps")
public class RegistrationOtp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 6, nullable = false, updatable = false)
    private String formId;
    @Column(length = 6, nullable = false, updatable = false)
    private String otp;
    @Column(nullable = false, updatable = false)
    private LocalDateTime dateCreated;
}
