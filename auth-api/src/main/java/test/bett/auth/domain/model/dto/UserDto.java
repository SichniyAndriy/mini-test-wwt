package test.bett.auth.domain.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserDto {

    private UUID id;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
