package com.mcarter.filter;

import java.util.Map;

public class ResourceFilterBuilder extends FilterBuilder<Map<String, String>, String, String> {

    @Override
    public FilterQuery<Map<String, String>, String, String> filter() {
        return new FilterQuery<Map<String, String>, String, String>() {
            @Override
            public PredicateQuery<Map<String, String>, String> where(String property) {
                return new PredicateQuery<Map<String, String>, String>() {
                    @Override
                    public Filter<Map<String, String>> isEqualTo(String value) {
                        System.out.println(value);
                        return resource -> resource.containsKey(property) &&
                                resource.get(property).equals(value);
                    }

                    @Override
                    public Filter<Map<String, String>> isGreaterThan(String value) {
                        return resource -> resource.containsKey(property) &&
                                Integer.parseInt(resource.get(property)) > Integer.parseInt(value);
                    }

                    @Override
                    public Filter<Map<String, String>> isLessThan(String value) {
                        return resource -> resource.containsKey(property) &&
                                Integer.parseInt(resource.get(property)) < Integer.parseInt(value);
                    }

                    @Override
                    public Filter<Map<String, String>> matches(String value) {
                        return resource -> resource.containsKey(property) && resource.get(property).matches(value);
                    }
                };
            }
        };
    }
}
