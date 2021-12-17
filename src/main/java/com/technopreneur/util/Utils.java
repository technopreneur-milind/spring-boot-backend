package com.technopreneur.util;

import org.springframework.security.core.Authentication;

public final class Utils {

    public static boolean isAdmin(final Authentication authentication) {
        return authentication != null && authentication.isAuthenticated()
                && authentication.getAuthorities() != null
                && authentication.getAuthorities().stream().anyMatch(r -> "ROLE_ADMIN".equalsIgnoreCase(r.getAuthority()));
    }

}
