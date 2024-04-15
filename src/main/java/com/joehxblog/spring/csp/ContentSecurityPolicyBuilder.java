package com.joehxblog.spring.csp;

import com.joehxblog.spring.csp.directive.Directive;
import com.joehxblog.spring.csp.value.Value;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ContentSecurityPolicyBuilder {
    
    private static final Collector<CharSequence, ?, String> SPACE_COLLECTOR = Collectors.joining(" ");

    private final Map<String, Set<String>> cspMap = new HashMap<>();
    
    ContentSecurityPolicyBuilder() {}
    
    public ContentSecurityPolicyBuilder add(Directive directive, Value... values) {
        String[] valueArray = Arrays.stream(values)
                .map(Object::toString)
                .toArray(String[]::new);
        
        return this.add(directive.toString(), valueArray);
    }
    
    public ContentSecurityPolicyBuilder add(Directive directive, String... values) {
        return this.add(directive.toString(), values);
    }
    
    public ContentSecurityPolicyBuilder add(String directive, String... values) {       
        Set<String> valueSet = Arrays.stream(values).collect(Collectors.toSet());
        
        this.cspMap.computeIfAbsent(directive, d -> new HashSet<>()).addAll(valueSet);
        return this;
    }
    
    public ContentSecurityPolicy build() {
        String csp = this.cspMap.entrySet().stream()
            .map(e -> e.getKey() 
                    + " " 
                    + e.getValue().stream()
                        .collect(SPACE_COLLECTOR))
            .collect(SPACE_COLLECTOR);
        
        return new ContentSecurityPolicy(csp);
    }
}
