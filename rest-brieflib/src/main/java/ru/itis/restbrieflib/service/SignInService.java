package ru.itis.restbrieflib.service;

import ru.itis.restbrieflib.dto.SignInDto;
import ru.itis.restbrieflib.dto.TokenDto;

public interface SignInService {
    TokenDto signIn(SignInDto signInData);
}
