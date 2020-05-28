package ru.itis.springbootdemo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springbootdemo.security.UserDetailsImpl;

@Controller
public class ChatController {
    @GetMapping("/forum")
    public String getIndexPage(Model model, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("username", userDetails.getUser().getName());
        return "forum";
    }

}
