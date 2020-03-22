package ru.itis.springbootdemo.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootdemo.dto.UserDto;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ResponseUserDto {
    private UserDto data;
}
