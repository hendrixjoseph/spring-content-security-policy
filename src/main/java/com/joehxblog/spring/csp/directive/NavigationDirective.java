package com.joehxblog.spring.csp.directive;

public enum NavigationDirective implements Directive {
    FORM_ACTION,
    FRAME_ANCESTORS;
    
    @Override
    public String toString() {
        return Directive.stringify(super.toString());
    }
}
