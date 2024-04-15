package com.joehxblog.spring.csp.directive;

/**
 * Please see the MDN web docs
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy#navigation_directives">Navigation directives</a>
 * for the meaning of these values.
 */
public enum NavigationDirective implements Directive {
    FORM_ACTION,
    FRAME_ANCESTORS;
    
    @Override
    public String toString() {
        return Directive.stringify(super.toString());
    }
}
