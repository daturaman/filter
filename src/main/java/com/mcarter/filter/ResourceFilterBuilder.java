package com.mcarter.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class ResourceFilterBuilder implements FilterBuilder<ResourceFilter, String, String> {

    private String property;

    @Override
    public FilterBuilder where(String property) {
        this.property = property;
        return this;
    }

    @Override
    public ResourceFilter is(String value) {
        Map<String, Predicate<String>> propertiesToMatch = new HashMap<>();
        propertiesToMatch.put(property, Predicate.isEqual(value));
        return new ResourceFilter(propertiesToMatch);
    }

    @Override
    public ResourceFilter isGreaterThan(String value) {
        return null;
    }
}
