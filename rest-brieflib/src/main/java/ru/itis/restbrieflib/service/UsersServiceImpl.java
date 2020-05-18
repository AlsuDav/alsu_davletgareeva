package ru.itis.restbrieflib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.itis.restbrieflib.dto.SignUpDto;
import ru.itis.restbrieflib.dto.UserDto;
import ru.itis.restbrieflib.models.User;
import ru.itis.restbrieflib.repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.List;

import static ru.itis.restbrieflib.dto.UserDto.from;

@Component
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<UserDto> getUsers() {
        return from(usersRepository.findAll());
    }

    @Override//прикрутили пагинацию
    public List<UserDto> getUsers(Integer page, Integer size, String property) {
        Sort sort = Sort.by(property);
        PageRequest request = PageRequest.of(page, size, sort);
        Page<User> pageResult = usersRepository.findAll(request);
        List<User> users = pageResult.getContent();
        return UserDto.from(users);
    }




    @Override
    public UserDto getConcreteUser(Long userId) {
        User user = usersRepository.getOne(userId);
        return from(user);
    }

    @Override
    public List<UserDto> search(String name) {
        return from(usersRepository.findAllByNameContainsIgnoreCase(name));
    }

    @Override
    public UserDto addUser(SignUpDto userData) {
        User user = User.builder()
                .email(userData.getEmail())
                .hashPassword(userData.getPassword())
                .name(userData.getName())
                .createdAt(LocalDateTime.now())
                .build();

        usersRepository.save(user);
        return UserDto.from(user);
    }


}

