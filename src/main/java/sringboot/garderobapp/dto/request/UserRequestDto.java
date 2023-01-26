package sringboot.garderobapp.dto.request;

import lombok.Getter;
import lombok.Setter;
import sringboot.garderobapp.lib.FieldsValueMatch;
import sringboot.garderobapp.lib.ValidEmail;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@FieldsValueMatch(field = "password", fieldMatch = "repeatPassword"
        ,message = "Password do not match")
@Getter
@Setter
public class UserRequestDto {
    @NotBlank(message = "Name is mandatory")
    private String firstName;
    @NotBlank(message = "Lastname is mandatory")
    private String lastName;
    @ValidEmail
    private String email;

    @NotBlank
    @Size(min = 8, max = 40, message =" invalid password length")
    private String password;
    private String repeatPassword;
}
