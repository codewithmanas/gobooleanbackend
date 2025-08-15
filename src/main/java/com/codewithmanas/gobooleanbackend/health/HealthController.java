package com.codewithmanas.gobooleanbackend.health;


import com.codewithmanas.gobooleanbackend.common.util.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/health")
public class HealthController {

    private static final Logger log = LoggerFactory.getLogger(HealthController.class);

    @GetMapping
    public ResponseEntity<ApiResponse<String>> health(HttpServletRequest httpServletRequest) {

        String path = httpServletRequest.getRequestURI();
        String requestId = UUID.randomUUID().toString();

        log.info("[requestId={}] Received health endpoint request", requestId);

        ApiResponse<String> response = new ApiResponse<>(
                200,
                "OK",
                null,
                null,
                requestId,
                path
        );

        return ResponseEntity.ok().body(response);
    }

}
