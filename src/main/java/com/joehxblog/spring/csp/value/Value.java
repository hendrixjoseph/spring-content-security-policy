package com.joehxblog.spring.csp.value;

import java.util.Arrays;

public interface Value {
    static Value[] values() {
        Value[][] values = {
            KeywordValue.values(),
            UnsafeKeywordValue.values()
        };

        return Arrays.stream(values)
            .flatMap(e -> Arrays.stream(e))
            .toArray(s -> new Value[s]);
    }
    
    static String stringify(String string) {
        return "'" + string.toLowerCase().replace('_', '-') + "'";
    }

}
