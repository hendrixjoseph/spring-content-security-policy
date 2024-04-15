package com.joehxblog.spring.csp.value;

public class ShaValue {
    public enum ShaType {
        SHA256, SHA384, SHA512;
    }

    private final ShaType shaType;
    private final String shaValue;

    public ShaValue(ShaType shaType, String shaValue) {
        this.shaType = shaType;
        this.shaValue = shaValue;
    }

    @Override
    public String toString() {
        return "'" + shaType + "-" + shaValue + "'";
    }
}
