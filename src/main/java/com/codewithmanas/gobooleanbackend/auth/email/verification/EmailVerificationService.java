package com.codewithmanas.gobooleanbackend.auth.email.verification;

import org.springframework.stereotype.Service;

@Service
public class EmailVerificationService {

    public void verifyEmail(String token) {
        System.out.println("Email verified successfully");
    }

}
