package com.joehxblog.spring.csp.directive;

import com.joehxblog.spring.csp.value.KeywordValue;
import com.joehxblog.spring.csp.value.UnsafeKeywordValue;

import java.util.Arrays;

/**
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy#directives">Directives</a>
 */
public interface Directive {
    /**
     * @return an array of all the hard-coded values in enums
     * {@link DocumentDirective}, {@link FetchDirective}, and {@link NavigationDirective}.
     */
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
