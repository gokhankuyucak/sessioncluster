package com.kuyucak.projects.sessionsample.security;

import com.kuyucak.projects.sessionsample.session.HttpSessionConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityWebApplicationInitializer() {
        super(SecurityWebConfig.class, HttpSessionConfig.class);
    }
}
