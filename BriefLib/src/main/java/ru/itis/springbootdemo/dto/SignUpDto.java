package ru.itis.springbootdemo.dto;

import lombok.Data;

@Data
//@Data for getters,setters,constructors
public class SignUpDto {
    private String name;
    private String email;
    private String password;
}

