package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.SignUpDto;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.User;

import java.util.List;

public interface UsersService {
    List<UserDto> getUsers();
    List<UserDto> getUsers(Integer page, Integer size, String sort);



    UserDto getConcreteUser(Long userId);

    List<UserDto> search(String name);

    UserDto addUser(SignUpDto userData);
}
