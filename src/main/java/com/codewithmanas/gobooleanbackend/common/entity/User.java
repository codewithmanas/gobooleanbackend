package com.codewithmanas.gobooleanbackend.common.entity;

import com.codewithmanas.gobooleanbackend.common.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor // Required by JPA
@AllArgsConstructor // Optional, for convenience
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fullName;
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Password is required")
    @Column(nullable = false)
    private String hashedPassword;
    private String phoneNumber;
    private String verificationToken;
    private String refreshToken;
    private String profileImageUrl;
    private String bio;
    private boolean isVerified;
    private Instant emailVerifiedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant updatedAt;
}
