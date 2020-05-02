package ru.itis.springbootdemo.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.SignUpDto;

import java.time.LocalDateTime;

@Aspect
@Component //for context
@Slf4j
public class EmailAspect {
    //private final Logger log = LoggerFactory.getLogger(SignUpAspect.class);


    @After(value = "execution(* ru.itis.springbootdemo.service.EmailService.sendMail(*))")
    public void after(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        String email = (String) args[1];
        String name = (String) args[2];
        log.info("Время: " + LocalDateTime.now() + " " + "пользователю - " + name + " на email: " + email + "отправлено сообщение");
    }
    @AfterThrowing(pointcut = "execution(* ru.itis.springbootdemo.service.EmailService.sendMail(*))",throwing = "ex")
    public void afterThrowing(Exception ex) throws Throwable{
        //Object[]args = joinPoint.getArgs();
        log.info("exception after sendMail method (sms)" + ex);
    }
}