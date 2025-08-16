package com.codewithmanas.gobooleanbackend.auth.login;

import com.codewithmanas.gobooleanbackend.auth.login.dto.LoginRequestDTO;
import com.codewithmanas.gobooleanbackend.common.entity.User;
import com.codewithmanas.gobooleanbackend.common.exception.InvalidCredentialsException;
import com.codewithmanas.gobooleanbackend.common.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void login(LoginRequestDTO loginRequestDTO) {

        // Sanitize and Normalize email and password
        String email = loginRequestDTO.getEmail().trim().toLowerCase();

        // Find user by email
        User user = userRepository.findByEmail(email)
                        .orElseThrow(() -> new InvalidCredentialsException("Invalid email or password"));

        // Validate password
        if(!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getHashedPassword())) {
            throw new InvalidCredentialsException("Invalid email or password");
        }

        // TODO: Check if email is verified

        // TODO: Generate token

        System.out.println("Login Successful");
    }

}
