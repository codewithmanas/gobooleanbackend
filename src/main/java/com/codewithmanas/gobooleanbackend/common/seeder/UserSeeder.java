package com.codewithmanas.gobooleanbackend.common.seeder;

import com.codewithmanas.gobooleanbackend.common.entity.User;
import com.codewithmanas.gobooleanbackend.common.enums.Role;
import com.codewithmanas.gobooleanbackend.common.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class UserSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {

            User user1 = new User();
//            user1.setId(UUID.randomUUID());
            user1.setFullName("John Doe");
            user1.setUsername("johndoe");
            user1.setEmail("john@example.com");
            user1.setHashedPassword(passwordEncoder.encode("password123"));
            user1.setPhoneNumber("+911234567890");
            user1.setProfileImageUrl("https://api.dicebear.com/9.x/fun-emoji/svg?seed=10");
            user1.setBio("Love coding & coffee");
            user1.setVerified(true);
            user1.setEmailVerifiedAt(Instant.now());
            user1.setRole(Role.USER);
            user1.setCreatedAt(Instant.now());
            user1.setUpdatedAt(Instant.now());
            userRepository.save(user1);

            User user2 = new User();
//            user2.setId(UUID.randomUUID());
            user2.setFullName("Jane Smith");
            user2.setUsername("janesmith");
            user2.setEmail("jane@example.com");
            user2.setHashedPassword(passwordEncoder.encode("password123"));
            user2.setPhoneNumber("+911987654321");
            user2.setProfileImageUrl("https://api.dicebear.com/9.x/fun-emoji/svg?seed=11");
            user2.setBio("Backend wizard");
            user2.setVerified(true);
            user2.setEmailVerifiedAt(Instant.now());
            user2.setRole(Role.ADMIN);
            user2.setCreatedAt(Instant.now());
            user2.setUpdatedAt(Instant.now());
            userRepository.save(user2);

            User user3 = new User();
//            user3.setId(UUID.randomUUID());
            user3.setFullName("Alice Johnson");
            user3.setUsername("alicej");
            user3.setEmail("alice@example.com");
            user3.setHashedPassword(passwordEncoder.encode("password123"));
            user3.setProfileImageUrl("https://api.dicebear.com/9.x/fun-emoji/svg?seed=12");
            user3.setBio("Frontend enthusiast");
            user3.setVerified(false);
            user3.setRole(Role.USER);
            user3.setCreatedAt(Instant.now());
            user3.setUpdatedAt(Instant.now());
            userRepository.save(user3);

            User user4 = new User();
//            user4.setId(UUID.randomUUID());
            user4.setFullName("Bob Williams");
            user4.setUsername("bobby");
            user4.setEmail("bob@example.com");
            user4.setHashedPassword(passwordEncoder.encode("password123"));
            user4.setPhoneNumber("+919876543210");
            user4.setProfileImageUrl("https://api.dicebear.com/9.x/fun-emoji/svg?seed=13");
            user4.setBio("DevOps engineer");
            user4.setVerified(false);
            user4.setRole(Role.USER);
            user4.setCreatedAt(Instant.now());
            user4.setUpdatedAt(Instant.now());
            userRepository.save(user4);

            User user5 = new User();
//            user5.setId(UUID.randomUUID());
            user5.setFullName("Charlie Brown");
            user5.setUsername("charlieb");
            user5.setEmail("charlie@example.com");
            user5.setHashedPassword(passwordEncoder.encode("password123"));
            user5.setBio("Loves microservices");
            user5.setVerified(true);
            user5.setEmailVerifiedAt(Instant.now());
            user5.setRole(Role.ADMIN);
            user5.setCreatedAt(Instant.now());
            user5.setUpdatedAt(Instant.now());
            userRepository.save(user5);


            System.out.println("✅ Seeded 5 users into the database");
        }
    }
}

