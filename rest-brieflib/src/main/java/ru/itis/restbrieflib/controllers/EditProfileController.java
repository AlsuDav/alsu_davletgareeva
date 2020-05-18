package ru.itis.restbrieflib.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.restbrieflib.dto.ProfileForm;
import ru.itis.restbrieflib.models.User;
import ru.itis.restbrieflib.repositories.UsersRepository;
import ru.itis.restbrieflib.security.jwt.details.UserDetailsImpl;
import ru.itis.restbrieflib.service.UsersService;

import javax.validation.Valid;

@Controller
public class EditProfileController {
    @Autowired
    UsersService usersService;
    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/editProfile")
    public String getEdit(Authentication authentication, Model model){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();//получаем текущего пользователя
        model.addAttribute("user", userDetails.getUsername());
        model.addAttribute("profileForm", new ProfileForm());
        return "edit_profile";
    }
    //@PostMapping("/editProfile/{user-id}")
    //public String profileEdit(@PathVariable(value="user-id") long id, @RequestParam String name, @RequestParam String email){
//            User user = usersRepository.findById(id).get();
//        user.setEmail(email);
//        user.setName(name);
//        usersRepository.save(user);
//        return "redirect:/profile";
//}
    @PostMapping("/editProfile")
    public String profileEdit(Authentication authentication, @Valid ProfileForm form, BindingResult bindingResult, Model model){
        System.out.println(form);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        if(!bindingResult.hasErrors()){
            User user = usersRepository.findById(userDetails.getUserId()).get();
            user.setEmail(form.getEmail());
            user.setName(form.getName());
            usersRepository.save(user);
            return "redirect:/profile";
        }

        model.addAttribute("user", userDetails.getUsername());
        System.out.println(bindingResult.getAllErrors());
        model.addAttribute("profileForm", form);
        return "edit_profile";
    }


}
