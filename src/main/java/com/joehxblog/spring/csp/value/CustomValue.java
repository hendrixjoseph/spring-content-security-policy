package com.joehxblog.spring.csp.value;

import java.util.Objects;

public class CustomValue implements Value {
    private final String value;
    
    public CustomValue(String value) {
        this.value = value;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(value);
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
        
        CustomValue other = (CustomValue) obj;
        return Objects.equals(value, other.value);
    }
    
    @Override
    public String toString() {
        return this.value;
    }
}
