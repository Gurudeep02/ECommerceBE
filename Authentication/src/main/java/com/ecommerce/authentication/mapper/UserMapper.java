package com.ecommerce.authentication.mapper;

import com.ecommerce.authentication.dto.RegisterRequestDTO;
import com.ecommerce.authentication.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(RegisterRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}