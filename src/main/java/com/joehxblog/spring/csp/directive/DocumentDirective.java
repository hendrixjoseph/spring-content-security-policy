package com.joehxblog.spring.csp.directive;

/**
 * Please see the MDN web docs
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy#document_directives">Document directives</a>
 * for the meaning of these values.
 */
public enum DocumentDirective implements Directive {
    BASE_URI,
    SANDBOX;
    
    @Override
    public String toString() {
        return Directive.stringify(super.toString());
    }
}
