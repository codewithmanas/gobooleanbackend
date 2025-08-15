package com.codewithmanas.gobooleanbackend.auth.login;

import com.codewithmanas.gobooleanbackend.auth.login.dto.LoginRequestDTO;
import com.codewithmanas.gobooleanbackend.common.util.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth/login")
public class LoginController {
    private final LoginService loginService;
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO, HttpServletRequest httpServletRequest) {
        String path = httpServletRequest.getRequestURI();
        String requestId = UUID.randomUUID().toString();

        log.info("[requestId={}] Received login endpoint request", requestId);

        loginService.login(loginRequestDTO);

        ApiResponse<String> response = new ApiResponse<>(
                200,
                "Logged in successful",
                null,
                null,
                requestId,
                path
        );

        return ResponseEntity.status(200).body(response);
    }

}
