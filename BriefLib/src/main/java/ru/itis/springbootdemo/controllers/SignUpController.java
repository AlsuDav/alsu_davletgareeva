package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.dto.SignUpDto;
import ru.itis.springbootdemo.service.SignUpService;
import ru.itis.springbootdemo.service.SignUpServiceImpl;

@Controller
public class SignUpController {
    @Autowired
    private SignUpService service;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "sign_up";
    }
    @PostMapping("/signUp")
    public String signUp(SignUpDto form) {
        System.out.println(form.getName());
        System.out.println(form.getEmail());
        System.out.println(form.getPassword());
        service.SignUp(form);
        return "redirect:/signUp";
        //redirect-новый запрос, т.е. сервер отпр киберзаголовок с новым урлом
        //и браузер посылает новый запрос по этому урлу
    }
    @ResponseBody
    @RequestMapping(path = "/signUp", produces = "application/text; charset=UTF-8")
    public String signUp(SignUpDto form) {
        System.out.println(form.getCode() + form.getConfirmCode());
        if (form.getCode().equals(form.getConfirmCode())) {
            signUpService.signUp(form);
            return "ok";
        }
        else {
            return "error";
        }
    }

    @ResponseBody
    @RequestMapping(path = "/signUp/sendCode", produces = "application/text; charset=UTF-8")
    public String sendCode(@RequestParam("phone") String phone) {
        return sendCodeService.sendCode(phone);
    }
}
