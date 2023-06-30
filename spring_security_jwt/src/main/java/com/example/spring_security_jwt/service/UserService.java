package com.example.spring_security_jwt.service;

import com.example.spring_security_jwt.domain.Users;
import com.example.spring_security_jwt.service.dto.LoginDTO;
import com.example.spring_security_jwt.service.dto.RegisterDTO;

public interface UserService {
    Users createUser(RegisterDTO register);

    Users loginUser(LoginDTO login);
}
