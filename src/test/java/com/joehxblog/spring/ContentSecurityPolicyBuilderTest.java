package com.joehxblog.spring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.joehxblog.spring.csp.ContentSecurityPolicyBuilder;
import com.joehxblog.spring.csp.directive.FetchDirective;
import com.joehxblog.spring.csp.directive.Directive;
import com.joehxblog.spring.csp.value.KeywordValue;
import com.joehxblog.spring.csp.value.Value;

class ContentSecurityPolicyBuilderTest {

    @Test
    void testSimpleCsp() {
        var csp = new ContentSecurityPolicyBuilder()
            .add(FetchDirective.DEFAULT_SRC, KeywordValue.SELF)
            .build();
        
        assertEquals("default-src 'self'", csp.toString());
    }
    
    @Test
    void testMaxCsp() {
        var allValues = Value.values();
        var allDirectives = Directive.values();
        
        var count = allValues.length * allDirectives.length  + allDirectives.length;
        
        var builder = new ContentSecurityPolicyBuilder();
        
        for (Directive d : allDirectives) {
            for (Value v : allValues) {
                builder.add(d, v);
            }
        }
        
        var csp = builder.build();
        
        assertEquals(count, csp.toString().split(" ").length);
    }
}
