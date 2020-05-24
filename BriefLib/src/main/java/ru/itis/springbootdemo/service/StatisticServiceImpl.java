package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static ru.itis.springbootdemo.dto.UserDto.from;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    UsersService usersService;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    EmailService emailService;
    //List<UserDto> users = usersService.getUsers();
    //List<User> users = usersRepository.findAllByNameContainsIgnoreCase("Alya");
    @Override
    public void sendReport() {
        System.out.println("report by "+ LocalDateTime.now().toString() + " count of users: " );
        String text = LocalDateTime.now().toString() + usersRepository.findAll().size();
        System.out.println(text);
        emailService.sendReport("Report", text);
    }
}
