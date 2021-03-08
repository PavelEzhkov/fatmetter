package ru.ezhkov.fatmetter.security;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ru.ezhkov.fatmetter.security.ApplicationUserPermission.*;

@AllArgsConstructor
@Getter
public enum ApplicationUserRole {
    USER(Sets.newHashSet(DISH_READ, DISH_WRITE, PRODUCT_READ)),
    ADMIN(Sets.newHashSet(DISH_READ, DISH_WRITE, PRODUCT_READ, PRODUCT_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    public List<GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
