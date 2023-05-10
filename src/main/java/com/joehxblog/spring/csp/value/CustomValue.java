package com.joehxblog.spring.csp.value;

public class CustomValue implements Value {
    private final String value;
    
    public CustomValue(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return this.value;
    }
}
