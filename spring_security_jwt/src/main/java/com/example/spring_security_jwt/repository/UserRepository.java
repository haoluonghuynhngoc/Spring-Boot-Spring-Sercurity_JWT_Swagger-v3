package com.example.spring_security_jwt.repository;
import com.example.spring_security_jwt.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUserName(String userName);
}
