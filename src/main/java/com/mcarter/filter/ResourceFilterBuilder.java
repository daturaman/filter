package com.mcarter.filter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

public class ResourceFilterBuilder extends FilterBuilder<ResourceFilter, String, String> {

    private Queue<String> properties = new LinkedList<>();

    @Override
    public FilterQuery<String, String> filter() {
        return new ResourceFilterQuery();
    }

    private class ResourceFilterQuery implements FilterQuery<String, String>{
        @Override
        public PredicateQuery<String> where(String property) {
            return new PredicateQuery<String>() {
                @Override
                public BuildFilter isEqualTo(String value) {
                    propsToMatch.put(property, Predicate.isEqual(value));
                    return () -> new ResourceFilter(propsToMatch);
                }
            };
        }
    }
}
