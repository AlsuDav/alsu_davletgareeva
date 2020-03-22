package ru.itis.springbootdemo.service;


import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.io.StringWriter;

@Service
public class EmailServiceImpl implements EmailService {


        @Autowired
        private JavaMailSender javaMailSender; //встроенная в спринг штука,которая отправляет сообщения на email

        @Value("${spring.mail.username}") //из properties file берем св-ва
        private String userName;

    @Override
        public void sendMail(String subject, String text, String email, String name) {
            VelocityContext context = new VelocityContext();
            context.put("text", text);
            context.put("name", name);
            VelocityEngine velocity = new VelocityEngine();
            StringWriter writer = new StringWriter();
            Template template = velocity.getTemplate("src/main/resources/mails/mail.ftl");
            template.merge(context, writer);

            String result = writer.toString();

            MimeMessagePreparator messagePreparator = mimeMessage -> {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                messageHelper.setFrom(userName);
                messageHelper.setTo(email);
                messageHelper.setSubject(subject);
                messageHelper.setText(result, true);
            };

            javaMailSender.send(messagePreparator);
        }

    }

