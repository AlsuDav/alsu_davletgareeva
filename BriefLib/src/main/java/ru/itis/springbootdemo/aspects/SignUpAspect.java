package ru.itis.springbootdemo.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.SignUpDto;

import java.time.LocalDateTime;

@Aspect
@Component //for context
@Slf4j
public class SignUpAspect {
    //private final Logger log = LoggerFactory.getLogger(SignUpAspect.class);
    @Before(value = "execution(* ru.itis.springbootdemo.service.SignUpService.SignUp(*))")
    //выше описываем Pointcut
    // Advice
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        SignUpDto user = (SignUpDto)args[0];
        log.info("Время: "+ LocalDateTime.now()+ " " + "пользователь - " + user + " начал регистрацию");
    }
    @After(value = "execution(* ru.itis.springbootdemo.service.SignUpService.SignUp(*))")
    public void after(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        SignUpDto user = (SignUpDto) args[0];
        log.info("Время: "+ LocalDateTime.now() + " " + "пользователь - " + user + " завершил регистрацию");
    }

}