package com.joehxblog.spring.csp.directive;

import java.util.Objects;

public class CustomDirective implements Directive {
    private final String directive;

    /**
     * Creates a custom directive.
     *
     * @param directive the custom directive string
     */
    public CustomDirective(final String directive) {
        this.directive = directive;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(directive);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        CustomDirective other = (CustomDirective) obj;
        return Objects.equals(directive, other.directive);
    }

    @Override
    public String toString() {
        return this.directive;
    }
}
