package ru.itis.springbootdemo.dto;

import lombok.Data;

@Data
//@Data for getters,setters,constructors
public class SignUpDto {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    //код, сгенерированный сервером(смс)
    private String code;
    //код, вводимый пользователем
    private String confirmCode;


}

