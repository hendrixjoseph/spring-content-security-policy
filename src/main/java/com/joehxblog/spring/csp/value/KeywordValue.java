package com.joehxblog.spring.csp.value;

/**
 * Please see the MDN web docs
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy#keyword_values">Keyword values</a>
 * for the meaning of these values.
 */
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
