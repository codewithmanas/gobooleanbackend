package com.codewithmanas.gobooleanbackend.auth.register;

import com.codewithmanas.gobooleanbackend.auth.register.dto.RegisterRequestDTO;
import com.codewithmanas.gobooleanbackend.common.util.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth/register")
public class RegisterController {

    private final RegisterService registerService;
    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> register(@Valid @RequestBody RegisterRequestDTO registerRequestDTO, HttpServletRequest httpServletRequest) {

                String path = httpServletRequest.getRequestURI();
                String requestId = UUID.randomUUID().toString();

                log.info("[requestId={}] Received register endpoint request", requestId);

                registerService.register(registerRequestDTO);

                ApiResponse<String> response = new ApiResponse<>(
                        201,
                        "User registered. Please verify your email.",
                        null,
                        null,
                        requestId,
                        path
                );


                return ResponseEntity.status(201).body(response);
    }


}
