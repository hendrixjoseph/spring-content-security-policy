package com.joehxblog.spring.csp;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class ContentSecurityPolicy {
    
    public static ContentSecurityPolicyBuilder build() {
        return new ContentSecurityPolicyBuilder();
    }
    
    private final String contentSecurityPolicy;
    
    public ContentSecurityPolicy() {
        this("default-src 'self'");
    }
    
    public ContentSecurityPolicy(String contentSecurityPolicy) {
        this.contentSecurityPolicy = contentSecurityPolicy;
    }

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers(header -> header.xssProtection(Customizer.withDefaults()))
            .headers(header -> header.contentSecurityPolicy(policy ->
                    policy.policyDirectives(contentSecurityPolicy)
            ));

        return http.build();
    }
    
    @Override
    public String toString() {
        return this.contentSecurityPolicy;
    }
}
