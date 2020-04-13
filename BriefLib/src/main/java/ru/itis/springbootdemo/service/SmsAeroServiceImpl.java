package ru.itis.springbootdemo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        httpHeaders.setBasicAuth("alsudavletgareeva@gmail.com", "");

        HttpEntity<SignInRequest> request = new HttpEntity<>(
                new SignInRequest(phone, message, "SMS Aero", "DIRECT"), httpHeaders);
        String resourceUrl = "https://gate.smsaero.ru/v2/sms/send";

        ResponseEntity<SmsResponse> response = restTemplate.postForEntity(resourceUrl, request, SmsResponse.class);

        return "" + number;
    }
    }
}
