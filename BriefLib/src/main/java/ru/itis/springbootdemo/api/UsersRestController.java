package ru.itis.springbootdemo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.SignUpDto;
import ru.itis.springbootdemo.service.UsersService;

@RestController
@RequestMapping("/api/users-management")
public class UsersRestController {
    @Autowired
    UsersService usersService;

    @PostMapping("/users")
    public ResponseUserDto addUser(@RequestBody SignUpDto userData) {
        return ResponseUserDto.builder()
                .data(usersService.addUser(userData))
                .build();
    }

    @GetMapping("/users")
    public ResponseUsersDto getUsers(@RequestParam("page") Integer page,
                                     @RequestParam("size") Integer size,
                                     @RequestParam("sort") String sort)  {
                return ResponseUsersDto.builder()
                .data(usersService.getUsers(page, size, sort))
                .build();
    }
    @GetMapping("/users/{user-id}")
    public ResponseUserDto getUser(@PathVariable("user-id") Long userId) {
        return ResponseUserDto.builder()
                .data(usersService.getConcreteUser(userId))
                .build();
    }



}
