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
public class SmsAeroAspect {
    //private final Logger log = LoggerFactory.getLogger(SignUpAspect.class);
    @Before(value = "execution(* ru.itis.springbootdemo.service.SmsService.sendConfirmCode(*))")
    //выше описываем Pointcut
    // Advice
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String phone = (String) args[0];
        log.info("Время: "+ LocalDateTime.now()+ " " + "начало отправки кода с подтверждением на номер: " + phone);
    }
    @After(value = "execution(* ru.itis.springbootdemo.service.SmsService.sendConfirmCode(*))")
    public void after(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String phone = (String) args[0];
        log.info("Время: "+ LocalDateTime.now()+ " " + "код подтверждения отправлен на номер: " + phone);
    }

    @AfterThrowing(pointcut = "execution(* ru.itis.springbootdemo.service.SmsService.sendConfirmCode(*))",throwing = "ex")
    public void afterThrowing(Exception ex) throws Throwable{
        //Object[]args = joinPoint.getArgs();
        log.info("exception after sendConfirmCode method (sms)" + ex);
    }
}