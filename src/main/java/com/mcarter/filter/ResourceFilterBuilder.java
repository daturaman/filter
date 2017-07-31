package com.mcarter.filter;

import java.util.Map;

public class ResourceFilterBuilder extends FilterBuilder<Map<String, String>, String, String> {

    private static final String FILTER_STRING = "Filter where %s %s %s";
    private String filterString;

    @Override
    public FilterQuery<Map<String, String>, String, String> filter() {
        return property -> new PredicateQuery<Map<String, String>, String>() {
			@Override
			public Filter<Map<String, String>> isEqualTo(String value) {
			    filterString = String.format(FILTER_STRING, property, "=", value);
				return resource -> resource.containsKey(property) &&
						resource.get(property).equals(value);
			}

			@Override
			public Filter<Map<String, String>> isGreaterThan(String value) {
                filterString = String.format(FILTER_STRING, property, ">", value);
				return resource -> resource.containsKey(property) &&
						Integer.parseInt(resource.get(property)) > Integer.parseInt(value);
			}

			@Override
			public Filter<Map<String, String>> isLessThan(String value) {
                filterString = String.format(FILTER_STRING, property, "<", value);
				return resource -> resource.containsKey(property) &&
						Integer.parseInt(resource.get(property)) < Integer.parseInt(value);
			}

			@Override
			public Filter<Map<String, String>> matches(String value) {
                filterString = String.format(FILTER_STRING, property, "MATCHES", value);
				return resource -> resource.containsKey(property) && resource.get(property).matches(value);
			}

            @Override
            public Filter<Map<String, String>> isTrue() {
				filterString = String.format(FILTER_STRING, property, "is", true);
                return resource -> resource.containsKey(property) && Boolean.parseBoolean(resource.get(property));
            }

            @Override
            public Filter<Map<String, String>> isFalse() {
				filterString = String.format(FILTER_STRING, property, "is", false);
				return resource -> resource.containsKey(property) && !Boolean.parseBoolean(resource.get(property));
            }
		};
    }
}
