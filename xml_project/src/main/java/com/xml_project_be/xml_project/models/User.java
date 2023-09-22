package com.xml_project_be.xml_project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "First name cannot be null or empty")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "login", unique = true, nullable = false)
    @NotBlank(message = "login cannot be null or empty")
    private String login;
    @Column(name = "password", nullable = false)
    @NotBlank(message = "password cannot be null or empty")
    private String password;
    @Column(name = "email")
    @Email(message = "Bad Email")
    private String email;
    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private Role role;
    @Column(name = "state", nullable = false)
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private State state;
    @Column(name = "phone_number")
    @Pattern(regexp = "(\\+7[-_()\\s]+|\\+7\\s?[(]?[0-9]{3}[)]?\\s?\\d{3}-?\\d{2}-?\\d{2})", message = "Bad phone number")
    private String phoneNumber;
    @ElementCollection
    protected Set<String> nickNames;


    private boolean isActive(){
        return state.equals(State.ACTIVE);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive();
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }
}