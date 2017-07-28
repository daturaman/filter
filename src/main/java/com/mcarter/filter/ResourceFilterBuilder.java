package com.mcarter.filter;

import java.util.function.Predicate;

public class ResourceFilterBuilder extends FilterBuilder<ResourceFilter, String, String> {

    @Override
    public Predicate<String> isEqualTo(String value) {
          return Predicate.isEqual(value);
    }

    @Override
    public Predicate<String> isGreaterThan(String value) {
        return null;
    }

    @Override
    public ResourceFilter build() {
        return new ResourceFilter(propsToMatch);
    }
}
