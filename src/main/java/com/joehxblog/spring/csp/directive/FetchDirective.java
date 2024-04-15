package com.joehxblog.spring.csp.directive;

/**
 * Please see the MDN web docs
 * <a href="https://developer.mozilla.org/en-US/docs/Glossary/Fetch_directive">Fetch directive</a>
 * for the meaning of these values.
 */
public enum FetchDirective implements Directive {

    CHILD_SRC,
    CONNECT_SRC,
    DEFAULT_SRC,
    FONT_SRC,
    FRAME_SRC,
    IMG_SRC,
    MANIFEST_SRC,
    MEDIA_SRC,
    OBJECT_SRC,
    SCRIPT_SRC,
    SCRIPT_SRC_ELEM,
    SCRIPT_SRC_ATTR,
    STYLE_SRC,
    STYLE_SRC_ELEM,
    STYLE_SRC_ATTR,
    WORKER_SRC;
    
    @Override
    public String toString() {
        return Directive.stringify(super.toString());
    }
}
