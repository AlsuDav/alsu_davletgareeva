package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.service.UsersService;

import java.util.List;

@Controller  //чтобы умел принимать запросы, и раздавать странички
@RequestMapping("/users") //все запросы с заголовком /users будут попадать в UsersController
public class UsersController {
    @Autowired
    UsersService usersService;
    @GetMapping("/{user-id}")
    public String getConcreteUserPage(@PathVariable("user-id") Long userId, Model model) {
        UserDto user = usersService.getConcreteUser(userId);
        model.addAttribute("user", user);
        return "user_page";
    }

    @GetMapping
    public String getUsersPage(Model model){
        List<UserDto> users = usersService.getUsers();
        model.addAttribute("users", users);
        return "users_page";
    }

    //@GetMapping("/search")
    @GetMapping(path = "/search", produces = "application/json; charset=UTF-8")
    @ResponseBody //сообщаем спрингу,что мы возвращаем не view, а лист юзеров

    public List<UserDto> searchUsers(@RequestParam("name") String name) {
        return usersService.search(name);
    }

}
