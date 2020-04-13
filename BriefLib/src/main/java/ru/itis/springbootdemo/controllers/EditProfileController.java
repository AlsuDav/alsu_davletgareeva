package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.UsersService;

@Controller
public class EditProfileController {
    @Autowired
    UsersService usersService;
    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/editProfile")
    public String getEdit(Authentication authentication, Model model){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();//получаем текущего пользователя
        model.addAttribute("user", userDetails.getUser());
        return "edit_profile";
    }
    @PostMapping("/editProfile/{user-id}")
    public String profileEdit(@PathVariable(value="user-id") long id, @RequestParam String name, @RequestParam String email){
        User user = usersRepository.findById(id).get();
        user.setEmail(email);
        user.setName(name);
        usersRepository.save(user);
        return "redirect:/profile";
    }


}
