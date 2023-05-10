package com.joehxblog.spring.csp.directive;

public class CustomDirective implements Directive {
    private final String directive;
    
    public CustomDirective(final String directive) {
        this.directive = directive;
    }
    
    @Override
    public String toString() {
        return this.directive;
    }
}
