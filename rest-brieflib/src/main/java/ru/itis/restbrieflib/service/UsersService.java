package ru.itis.restbrieflib.service;

import ru.itis.restbrieflib.dto.SignUpDto;
import ru.itis.restbrieflib.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getUsers();
    List<UserDto> getUsers(Integer page, Integer size, String sort);



    UserDto getConcreteUser(Long userId);

    List<UserDto> search(String name);

    UserDto addUser(SignUpDto userData);
}
