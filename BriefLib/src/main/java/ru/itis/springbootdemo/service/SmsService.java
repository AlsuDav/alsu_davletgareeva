package ru.itis.springbootdemo.service;

public interface SmsService {
    String sendConfirmCode(String phone);
}
