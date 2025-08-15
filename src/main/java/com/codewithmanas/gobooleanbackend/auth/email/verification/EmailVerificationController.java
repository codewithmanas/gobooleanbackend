package com.codewithmanas.gobooleanbackend.auth.email.verification;

import com.codewithmanas.gobooleanbackend.auth.login.LoginController;
import com.codewithmanas.gobooleanbackend.common.util.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth/verify-email")
public class EmailVerificationController {

    private final EmailVerificationService emailVerificationService;
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    public EmailVerificationController(EmailVerificationService emailVerificationService) {
        this.emailVerificationService = emailVerificationService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<String>> verifyEmail(@RequestParam String token, HttpServletRequest httpServletRequest) {

        String path = httpServletRequest.getRequestURI();
        String requestId = UUID.randomUUID().toString();

        log.info("[requestId={}] Received verify-email request", requestId);

//        if(token.trim().isEmpty()) {
//            throw new InvalidTokenException("Token is missing");
//        }

        emailVerificationService.verifyEmail(token);

        ApiResponse<String> response = new ApiResponse<>(
                200,
                "Email Verified Successfully",
                null,
                null,
                requestId,
                path
        );

        return ResponseEntity.ok().body(response);
    }
}
