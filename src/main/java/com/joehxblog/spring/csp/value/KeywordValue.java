package com.joehxblog.spring.csp.value;

public enum KeywordValue implements Value {
    NONE,
    SELF,
    STRICT_DYNAMIC,
    REPORT_SAMPLE;
    
    @Override
    public String toString() {
        return Value.stringify(super.toString());
    }
}
