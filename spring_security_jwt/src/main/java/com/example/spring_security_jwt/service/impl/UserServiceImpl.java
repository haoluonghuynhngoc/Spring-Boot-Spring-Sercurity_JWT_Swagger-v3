package com.example.spring_security_jwt.service.impl;
import com.example.spring_security_jwt.domain.Role;
import com.example.spring_security_jwt.domain.Users;
import com.example.spring_security_jwt.domain.enums.RoleName;
import com.example.spring_security_jwt.repository.RoleRepository;
import com.example.spring_security_jwt.repository.UserRepository;
import com.example.spring_security_jwt.service.UserService;
import com.example.spring_security_jwt.service.dto.LoginDTO;
import com.example.spring_security_jwt.service.dto.RegisterDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public Users createUser(RegisterDTO register) {
        Collection<Role> role = new ArrayList<>();
        role.add(roleRepository.save(Role.builder().name(RoleName.ADMIN).build()));
        var user = com.example.spring_security_jwt.domain.Users.builder()
                .userName(register.getUserName())
                .password(bCryptPasswordEncoder.encode(register.getPassword()))
                .roles(role)
                .email(register.getEmail())
                .build();
        return userRepository.save(user);
    }

    @Override
    public Users loginUser(LoginDTO login) {
        return null;
    }
}
