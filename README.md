# Content Security Policy for Spring

## What is a Content Security Policy?

<https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy>

## How to use

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.joehxblog.spring.csp.ContentSecurityPolicy;

@Configuration
public class Config {
    private ContentSecurityPolicy csp = new ContentSecurityPolicy();
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return csp.filterChain(http);
    }
}
```

Or write your own:


```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.joehxblog.spring.csp.ContentSecurityPolicy;

@Configuration
public class Config {
    private ContentSecurityPolicy csp = new ContentSecurityPolicy("default-src 'self'");
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return csp.filterChain(http);
    }
}
```

Or use the builder:

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.joehxblog.spring.csp.ContentSecurityPolicy;
import com.joehxblog.spring.csp.directive.FetchDirective;
import com.joehxblog.spring.csp.value.KeywordValue;

@Configuration
public class Config {
    private ContentSecurityPolicy csp = ContentSecurityPolicy.build()
            .add(FetchDirective.DEFAULT_SRC, KeywordValue.SELF)
            .build();
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return csp.filterChain(http);
    }
}
```

### Maven Dependency Tag

```xml
<dependency>
    <groupId>com.joehxblog</groupId>
    <artifactId>spring-content-security-policy</artifactId>
    <version>6.2.3</version>
</dependency>
```