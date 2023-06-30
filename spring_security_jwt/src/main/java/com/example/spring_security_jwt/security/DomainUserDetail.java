package com.example.spring_security_jwt.security;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DomainUserDetail implements UserDetails {
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

//    public DomainUserDetail(User user) {
//        this.username = user.getUserName();
//        this.password = user.getPassword();
//        this.authorities = user.getRoles().stream().map(role ->
//                role.getName().name()
//        ).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password ;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
