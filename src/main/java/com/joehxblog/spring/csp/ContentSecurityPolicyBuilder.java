package com.joehxblog.spring.csp;

import java.util.Map;
import java.util.stream.Collectors;

import com.joehxblog.spring.csp.directive.Directive;
import com.joehxblog.spring.csp.value.Value;
import com.joehxblog.spring.csp.directive.CustomDirective;
import com.joehxblog.spring.csp.value.CustomValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collector;

public class ContentSecurityPolicyBuilder {
    
    private static Collector<CharSequence, ?, String> SPACE_COLLECTOR = Collectors.joining(" ");

    private Map<String, Set<String>> cspMap = new HashMap<>();
    
    ContentSecurityPolicyBuilder() {}
    
    public ContentSecurityPolicyBuilder add(Directive directive, Value... values) {
        String[] valueArray = Arrays.stream(values)
                .map(v -> v.toString())
                .toArray(s -> new String[s]);
        
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
                        .map(v -> v.toString())
                        .collect(SPACE_COLLECTOR))
            .collect(SPACE_COLLECTOR);
        
        return new ContentSecurityPolicy(csp);
    }
}
