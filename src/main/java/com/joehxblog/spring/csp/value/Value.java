package com.joehxblog.spring.csp.value;

import java.util.Arrays;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy#values">Values</a>
 */
public interface Value {
    /**
     * @return an array of all the hard-coded values in enums
     * {@link KeywordValue} and {@link UnsafeKeywordValue}.
     */
    static Value[] values() {
        Value[][] values = {
            KeywordValue.values(),
            UnsafeKeywordValue.values()
        };

        return Arrays.stream(values)
            .flatMap(Arrays::stream)
            .toArray(Value[]::new);
    }
    
    static String stringify(String string) {
        return "'" + string.toLowerCase().replace('_', '-') + "'";
    }

}
