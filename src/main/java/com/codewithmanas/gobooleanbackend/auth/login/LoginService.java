package com.codewithmanas.gobooleanbackend.auth.login;

import com.codewithmanas.gobooleanbackend.auth.login.dto.LoginRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public void login(LoginRequestDTO loginRequestDTO) {
        System.out.println("Login Successful");
    }

}
