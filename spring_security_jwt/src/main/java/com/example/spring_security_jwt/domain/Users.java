package com.example.spring_security_jwt.domain;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String userName;
    private String password;
    private String email;
    @ManyToMany( fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
}
