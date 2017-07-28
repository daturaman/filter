package com.mcarter.filter;

import java.util.HashMap;
import java.util.Map;

public class ResourceFilterBuilder implements FilterBuilder<ResourceFilter, String, String> {

    private String property;

    @Override
    public FilterBuilder where(String property) {
        this.property = property;
        return this;
    }

    @Override
    public ResourceFilter is(String value) {
        Map<String, String> propertiesToMatch = new HashMap<>();
        propertiesToMatch.put(property, value);//TODO need the operand here too
        return new ResourceFilter(propertiesToMatch);
    }

    @Override
    public ResourceFilter isGreaterThan(String value) {
        return null;
    }
}
