package com.joehxblog.spring.csp.value;

public class NonceValue implements Value {
    private final String nonce;

    public NonceValue(String nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "'nonce-" + nonce + "'";
    }
}
