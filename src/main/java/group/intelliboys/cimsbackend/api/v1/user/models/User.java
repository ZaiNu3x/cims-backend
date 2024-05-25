package group.intelliboys.cimsbackend.api.v1.user.models;

import group.intelliboys.cimsbackend.api.v1.user.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(length = 30)
    private String username;

    @Column(length = 72, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(length = 30, nullable = false)
    private String lastName;

    @Column(length = 30, nullable = false)
    private String firstName;

    @Column(length = 30)
    private String middleName;

    @Column(length = 6, nullable = false)
    private String sex;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private byte age;

    @Column(length = 128, nullable = false)
    private String address;

    @Column(length = 128, nullable = false)
    @Email
    private String email;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] profilePic;

}
