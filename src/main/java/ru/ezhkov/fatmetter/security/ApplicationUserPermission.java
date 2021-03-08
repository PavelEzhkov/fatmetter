package ru.ezhkov.fatmetter.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApplicationUserPermission {
    DISH_READ("dish:read"),
    DISH_WRITE("dish:write"),
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write");

    private final String permission;
}
