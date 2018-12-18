package com.seven.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
