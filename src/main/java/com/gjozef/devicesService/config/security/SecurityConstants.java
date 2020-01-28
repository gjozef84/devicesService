package com.gjozef.devicesService.config.security;

class SecurityConstants {

    static final String[] PERMITTED_URLS = {
        "/v2/api-docs",
        "/configuration/ui",
        "/swagger-resources/**",
        "/configuration/**",
        "/swagger-ui.html",
        "/swagger-ui.html/**",
        "/webjars/**"
    };
}
