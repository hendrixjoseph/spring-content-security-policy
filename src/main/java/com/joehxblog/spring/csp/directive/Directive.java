package com.joehxblog.spring.csp.directive;

import java.util.Arrays;

public interface Directive {
    static Directive[] values() {
        Directive[][] values = {
            DocumentDirective.values(),
            FetchDirective.values(),
            NavigationDirective.values()
        };

        return Arrays.stream(values)
            .flatMap(Arrays::stream)
            .toArray(Directive[]::new);
    }
    
    static String stringify(String string) {
        return string.toLowerCase().replace('_', '-');
    }
}
