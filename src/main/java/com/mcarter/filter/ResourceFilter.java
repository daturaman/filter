package com.mcarter.filter;

import java.util.Map;
import java.util.function.Predicate;

/**
 * Filter for comparing resources
 */
class ResourceFilter implements Filter<Map<String, String>> {

    private Map<String, Predicate<String>> propsToMatch;

    public ResourceFilter(Map<String, Predicate<String>> propsToMatch) {
        this.propsToMatch = propsToMatch;
    }

    @Override
    public boolean matches(Map<String, String> other) {
        other.forEach((k, v) -> {
            //Run predicate for each property selected for filtering
            //propsToMatch.computeIfPresent(k, (s, stringPredicate) -> );
        });

        return false;
    }
}
