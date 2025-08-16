package com.codewithmanas.gobooleanbackend.auth.register;

import com.codewithmanas.gobooleanbackend.auth.register.dto.RegisterRequestDTO;
import com.codewithmanas.gobooleanbackend.auth.register.dto.RegisterResponseDTO;
import com.codewithmanas.gobooleanbackend.auth.register.mapper.RegisterMapper;
import com.codewithmanas.gobooleanbackend.common.entity.User;
import com.codewithmanas.gobooleanbackend.common.exception.EmailAlreadyExistsException;
import com.codewithmanas.gobooleanbackend.common.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequestDTO registerRequestDTO) {

        // Sanitize and Normalize email and password
        String email = registerRequestDTO.getEmail().trim().toLowerCase();

        // Check if email already exists
        if(userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException("Email is already in use.");
        }

        // Encode the password
        String encodedPassword = passwordEncoder.encode(registerRequestDTO.getPassword());

        // Save the user to db
        User user = userRepository.save(RegisterMapper.toEntity(registerRequestDTO, encodedPassword));
        RegisterResponseDTO registerResponseDTO = RegisterMapper.toDTO(user);

        // TODO: Send email verification

        System.out.println("User registered successfully");
    }
}
