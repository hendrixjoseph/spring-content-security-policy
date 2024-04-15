package com.joehxblog.spring.csp.value;

public class ShaValue {
    public enum ShaType {
        SHA256, SHA384, SHA512;
    }

    private final ShaType shaType;
    private final String shaValue;

    /**
     * Creates a SHA value based on the SHA type and value. Note that this does no
     * validation that the SHA value is a proper SHA value.
     *
     * @param shaType the SHA type.
     * @param shaValue the SHA value
     */
    public ShaValue(ShaType shaType, String shaValue) {
        this.shaType = shaType;
        this.shaValue = shaValue;
    }

    @Override
    public String toString() {
        return "'" + shaType + "-" + shaValue + "'";
    }
}
