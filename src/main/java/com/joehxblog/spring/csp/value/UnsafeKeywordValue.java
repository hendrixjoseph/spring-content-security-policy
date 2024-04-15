package com.joehxblog.spring.csp.value;

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
