package ru.itis.springbootdemo.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.SignUpDto;

import java.time.LocalDateTime;

@Aspect
@Component //for context
@Slf4j
public class UsersAspect {
    //private final Logger log = LoggerFactory.getLogger(SignUpAspect.class);

    @After(value = "execution(* ru.itis.springbootdemo.service.SignUpService.SignUp(*))")
    public void after(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        SignUpDto user = (SignUpDto) args[0];
        log.info("Время: "+ LocalDateTime.now() + " " + "пользователь - " + user + "был сохранен в базу данных");
    }

}