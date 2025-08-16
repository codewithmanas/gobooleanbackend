package com.codewithmanas.gobooleanbackend.auth.register.mapper;

import com.codewithmanas.gobooleanbackend.auth.register.dto.RegisterRequestDTO;
import com.codewithmanas.gobooleanbackend.auth.register.dto.RegisterResponseDTO;
import com.codewithmanas.gobooleanbackend.common.entity.User;

public class RegisterMapper {

    public static User toEntity(RegisterRequestDTO registerRequestDTO, String encodedPassword) {
        User user = new User();
        user.setEmail(registerRequestDTO.getEmail());
        user.setHashedPassword(encodedPassword);

        return user;
    }

    public static RegisterResponseDTO toDTO(User user) {
        RegisterResponseDTO registerResponseDTO = new RegisterResponseDTO();

        registerResponseDTO.setEmail(user.getEmail());

        return  registerResponseDTO;
    }

}
