package com.joehxblog.spring.csp.value;

public enum KeywordValue implements Value {
    NONE,
    SELF,
    STRICT_DYNAMIC,
    REPORT_SAMPLE,
    INLINE_SPECULATION_RULES;
    
    @Override
    public String toString() {
        return Value.stringify(super.toString());
    }
}
