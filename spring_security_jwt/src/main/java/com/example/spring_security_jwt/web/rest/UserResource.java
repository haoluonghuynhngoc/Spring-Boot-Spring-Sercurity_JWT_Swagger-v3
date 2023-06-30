package com.example.spring_security_jwt.web.rest;
import com.example.spring_security_jwt.domain.Users;
import com.example.spring_security_jwt.security.DomainUserDetail;
import com.example.spring_security_jwt.security.jwt.TokenProvider;
import com.example.spring_security_jwt.service.UserService;
import com.example.spring_security_jwt.service.dto.RegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;
    private final TokenProvider tokenProvider;

    @PostMapping("/register")
    public ResponseEntity<?> updateProduct(@RequestBody RegisterDTO register) {
        Users users = userService.createUser(register);
        var jwtToken = "";
        if (users != null) {
            jwtToken = tokenProvider.generateToken(DomainUserDetail.builder()
                    .username(users.getUserName())
                    .password(users.getPassword())
                    .authorities(users.getRoles().stream().map(role ->
                            role.getName().name()
                    ).map(SimpleGrantedAuthority::new).collect(Collectors.toList()))
                    .build());
        }
        return ResponseEntity.status(HttpStatus.OK).body(jwtToken);
    }
}
