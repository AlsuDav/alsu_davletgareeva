package ru.itis.restbrieflib.dto;

import lombok.Data;

@Data
public class SignInDto {
    private String email;
    private String password;
}
