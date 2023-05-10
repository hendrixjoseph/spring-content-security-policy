package com.joehxblog.spring.csp.directive;

public enum DocumentDirective implements Directive {
    BASE_URI,
    SANDBOX;
    
    @Override
    public String toString() {
        return Directive.stringify(super.toString());
    }
}
