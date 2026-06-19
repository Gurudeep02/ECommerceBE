package com.ecommerce.authentication.service;

import com.ecommerce.authentication.dto.AuthResponseDTO;
import com.ecommerce.authentication.dto.LoginRequestDTO;
import com.ecommerce.authentication.dto.RegisterRequestDTO;
import com.ecommerce.authentication.model.User;
import com.ecommerce.authentication.repository.UserRepository;
import com.ecommerce.authentication.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public String register(RegisterRequestDTO dto) {

        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole("ROLE_USER");

        userRepository.save(user);

        return "User registered successfully";
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO dto) {

        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        List.of(new SimpleGrantedAuthority(user.getRole()))
                );

        String token = jwtUtil.generateToken(userDetails);

        return new AuthResponseDTO(token, user.getRole());
    }
}