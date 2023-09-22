package com.xml_project_be.xml_project.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static com.xml_project_be.xml_project.models.Permission.*;

@RequiredArgsConstructor
public enum Role {
    USER(Collections.EMPTY_SET),
    ADMIN(
        Set.of(
            ADMIN_READ,
            ADMIN_UPDATE,
            ADMIN_DELETE,
            ADMIN_CREATE,
            TECH_ADMIN_READ,
            TECH_ADMIN_UPDATE,
            TECH_ADMIN_DELETE,
            TECH_ADMIN_CREATE
        )
    ),
    TECH_ADMIN(
        Set.of(
            TECH_ADMIN_READ,
            TECH_ADMIN_UPDATE,
            TECH_ADMIN_DELETE,
            TECH_ADMIN_CREATE
        )
    );

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}