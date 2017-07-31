package com.mcarter.filter;

import java.util.Map;
import java.util.function.Predicate;

public class ResourceFilter implements Filter<Map<String, String>> {

    private Predicate<Map<String, String>> predicate;
    private String description;

    public ResourceFilter(Predicate<Map<String, String>> predicate, String description) {
        this.predicate = predicate;
        this.description = description;
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        return predicate.test(resource);
    }

    /**
     * Get the predicate used by this filter
     *
     * @return java.util.function.Predicate used by this filter.
     */
    public Predicate<Map<String, String>> getPredicate() {
        return predicate;
    }

    /**
     * Get the formatted description of this filter. Can be parsed to create another filter.
     *
     * @return a string description of this filter.
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }

    public static ResourceFilter parseFilter(String filterDescription) {
        throw new UnsupportedOperationException("TBD");
    }

}
