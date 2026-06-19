package com.ecommerce.authentication.service;

import com.ecommerce.authentication.dto.AuthResponseDTO;
import com.ecommerce.authentication.dto.LoginRequestDTO;
import com.ecommerce.authentication.dto.RegisterRequestDTO;

public interface AuthService {
    String register(RegisterRequestDTO dto);
    AuthResponseDTO login(LoginRequestDTO dto);
}
