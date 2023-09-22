package com.xml_project_be.xml_project.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    TECH_ADMIN_READ("management:read"),
    TECH_ADMIN_UPDATE("management:update"),
    TECH_ADMIN_CREATE("management:create"),
    TECH_ADMIN_DELETE("management:delete");
    @Getter
    private final String permission;
}