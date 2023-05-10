package com.joehxblog.spring.csp;

import java.util.Map;
import java.util.stream.Collectors;

import com.joehxblog.spring.csp.directive.Directive;
import com.joehxblog.spring.csp.value.Value;
import com.joehxblog.spring.csp.directive.CustomDirective;
import com.joehxblog.spring.csp.value.CustomValue;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collector;

public class ContentSecurityPolicyBuilder {
    
    private static Collector<CharSequence, ?, String> SPACE_COLLECTOR = Collectors.joining(" ");

    private Map<Directive, List<Value>> cspMap = new HashMap<>();
    
    public ContentSecurityPolicyBuilder() {}
    
    public ContentSecurityPolicyBuilder add(Directive directive, Value value) {
        this.cspMap.computeIfAbsent(directive, d -> new ArrayList<>()).add(value);
        return this;
    }
    
    public ContentSecurityPolicyBuilder add(String directive, String value) {
        Directive customDirective = new CustomDirective(directive);
        Value customValue = new CustomValue(value);

        this.cspMap.computeIfAbsent(customDirective, d -> new ArrayList<>()).add(customValue);
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
