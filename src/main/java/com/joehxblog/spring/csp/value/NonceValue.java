package com.joehxblog.spring.csp.value;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy#nonce-">Nonce Values</a>
 */
public class NonceValue implements Value {
    private final String nonce;

    /**
     * Creates a nonce value. Please do not include the {@code nonce-} as this will be added.
     * @param nonce the nonce value
     */
    public NonceValue(String nonce) {
        this.nonce = nonce;
    }

    /**
     * Returns the nonce string surrounded by {@code 'nonce-} and {@code '}.
     *
     * @return the nonce string
     */
    @Override
    public String toString() {
        return "'nonce-" + nonce + "'";
    }
}
