package com.gjozef.devicesservice.config.security;

import com.gjozef.devicesservice.domain.User;
import com.gjozef.devicesservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class DeviceAuthenticationFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION_HEADER = "X-";

    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws ServletException, IOException {

        Optional.ofNullable(req.getHeader(AUTHORIZATION_HEADER))
            .flatMap(this::getAuthenticationFor)
            .ifPresent(SecurityContextHolder.getContext()::setAuthentication);

        doFilter(req, res, chain);
    }

    private Optional<Authentication> getAuthenticationFor(String username) {
        return userRepository.findByUsername(username)
            .map(this::createAuthentication);
    }

    private Authentication createAuthentication(User user) {
        return new UsernamePasswordAuthenticationToken(user, null);
    }
}