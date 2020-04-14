package ru.itis.springbootdemo.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.springbootdemo.models.SmsRequest;
import ru.itis.springbootdemo.models.SmsResponse;

import java.util.Random;

@Service
public class SmsAeroServiceImpl implements SmsService {

    @Override
    public String sendConfirmCode(String phone) {
        Random random = new Random();
        int number = random.nextInt(1000) + 1000;
        String message = "your confirm code is " + number;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth("alsudavletgareeva@gmail.com", "wb3ouydxCz9q9CT5OigZBuBgb2ZX");

        HttpEntity<SmsRequest> request = new HttpEntity<>(new SmsRequest(phone, message, "SMS Aero", "DIRECT"), httpHeaders);
        String resourceUrl = "https://gate.smsaero.ru/v2/sms/send";

        ResponseEntity<SmsResponse> response = restTemplate.postForEntity(resourceUrl, request, SmsResponse.class);

        return "" + number;
    }

}

