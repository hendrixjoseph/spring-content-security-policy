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

    private Map<Directive, Set<Value>> cspMap = new HashMap<>();
    
    ContentSecurityPolicyBuilder() {}
    
    public ContentSecurityPolicyBuilder add(Directive directive, Value... values) {
        Set<Value> valueSet = Arrays.stream(values).collect(Collectors.toSet());
        
        this.cspMap.computeIfAbsent(directive, d -> new HashSet<>()).addAll(valueSet);
        return this;
    }
    
    public ContentSecurityPolicyBuilder add(String directive, String... values) {
        Directive customDirective = new CustomDirective(directive);
        Value[] valueArray = Arrays.stream(values)
                .map(v -> new CustomValue(v))
                .toArray(s -> new Value[s]);
        
        return this.add(customDirective, valueArray);
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
