package com.mcarter.filter;

import java.util.Map;

/**
 * Filter for comparing resources
 */
class ResourceFilter implements Filter<Map<String, String>> {

    private Map<String, String> propsToMatch;

    public ResourceFilter(Map<String, String> propsToMatch) {
        this.propsToMatch = propsToMatch;
    }

    @Override
    public boolean matches(Map<String, String> other) {
        other.forEach((k, v) -> {

        });

        return false;
    }
}
