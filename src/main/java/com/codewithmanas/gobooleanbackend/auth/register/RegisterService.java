package com.codewithmanas.gobooleanbackend.auth.register;

import com.codewithmanas.gobooleanbackend.auth.register.dto.RegisterRequestDTO;
import com.codewithmanas.gobooleanbackend.common.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final UserRepository userRepository;

    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(RegisterRequestDTO registerRequestDTO) {

        System.out.println("User registered successfully");
    }
}
