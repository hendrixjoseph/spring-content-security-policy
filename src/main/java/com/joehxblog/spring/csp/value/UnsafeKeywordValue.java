package com.joehxblog.spring.csp.value;

/**
 * Please see the MDN web docs
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy#unsafe_keyword_values">Unsafe keyword values</a>
 * for the meaning of these values.
 */
public enum UnsafeKeywordValue implements Value {
    UNSAFE_INLINE,
    UNSAFE_EVAL,
    UNSAFE_HASHES,
    WASM_UNSAFE_EVAL;
    
    @Override
    public String toString() {
        return Value.stringify(super.toString());
    }
}
