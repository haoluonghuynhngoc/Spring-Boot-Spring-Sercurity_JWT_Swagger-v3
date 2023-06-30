package com.example.spring_security_jwt.repository;
import com.example.spring_security_jwt.domain.Role;
import com.example.spring_security_jwt.domain.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName name);
}
