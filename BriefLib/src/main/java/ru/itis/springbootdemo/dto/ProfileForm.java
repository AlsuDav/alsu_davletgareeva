package ru.itis.springbootdemo.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ProfileForm {
    @Email(message = "{errors.incorrect.email}")
    private String email;

    @NotNull(message = "{errors.null.name}")
    private String name;

//    @Pattern(regexp = "^id*$")
//    @NotBlank
//    private String vkId;
}
