package com.joehxblog.spring.csp;

import java.util.Map;
import java.util.stream.Collectors;

import com.joehxblog.spring.csp.directive.Directive;
import com.joehxblog.spring.csp.value.Value;

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
    
    public ContentSecurityPolicy build() {
        var csp = this.cspMap.entrySet().stream()
            .map(e -> e.getKey() 
                    + " " 
                    + e.getValue().stream()
                        .map(v -> v.toString())
                        .collect(SPACE_COLLECTOR))
            .collect(SPACE_COLLECTOR);
        
        return new ContentSecurityPolicy(csp);
    }
}
