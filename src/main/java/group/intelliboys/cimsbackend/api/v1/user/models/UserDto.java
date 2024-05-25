package group.intelliboys.cimsbackend.api.v1.user.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String lastName;
    private String firstName;
    private String middleName;
    private String sex;
    private LocalDate birthDate;
    private byte age;
    private String address;
    private String email;
    private byte[] profilePic;
}
