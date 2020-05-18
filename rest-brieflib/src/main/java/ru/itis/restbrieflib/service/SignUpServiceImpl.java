package ru.itis.restbrieflib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.restbrieflib.dto.SignUpDto;
import ru.itis.restbrieflib.models.Role;
import ru.itis.restbrieflib.models.State;
import ru.itis.restbrieflib.models.User;
import ru.itis.restbrieflib.repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

@Component
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private UsersRepository usersRepository;
//    @Autowired
//    private EmailService emailService;
//    @Autowired
//    private ExecutorService executorService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void SignUp(SignUpDto form) {
        User user = User.builder()
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .name(form.getName())
                .createdAt(LocalDateTime.now())
                .state(State.CONFIRMED) //т.к регаемся теперь через телефон
                .role(Role.USER)
                .confirmCode(UUID.randomUUID().toString())
                .phoneNumber(form.getPhoneNumber())
                .build();
        usersRepository.save(user);
        //emailService.sendMail("Confirm", user.getConfirmCode(), user.getEmail(), user.getName());
        //executorService.submit(()->emailService.sendMail("Confirm", user.getConfirmCode(), user.getEmail(), user.getName()));
    }
}
