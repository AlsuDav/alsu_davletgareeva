package ru.itis.springbootdemo.service;

public interface EmailService {
    void sendMail(String subject, String text, String email, String name);
    void sendReport(String subject, String text);
}
