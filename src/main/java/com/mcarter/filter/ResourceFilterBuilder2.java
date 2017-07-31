package com.mcarter.filter;

public class ResourceFilterBuilder2 implements FilterBuilder2<ResourceFilter, String, String> {

    public static final String FILTER_FORMAT = "Filter where %s %s %s";
    public static final String FILTER_FORMAT_BOOL = "Filter where %s %s";

    @Override
    public ResourceFilter isEqualTo(String property, String value) {
        return new ResourceFilter(t -> t.containsKey(property) &&
                t.get(property).equals(value),
                String.format(FILTER_FORMAT, property, "is equal to", value));
    }

    @Override
    public ResourceFilter isLessThan(String property, String value) {
        return new ResourceFilter(t -> t.containsKey(property) &&
                Integer.parseInt(t.get(property)) < Integer.parseInt(value),
                String.format(FILTER_FORMAT, property, "is less than", value));
    }

    @Override
    public ResourceFilter isGreaterThan(String property, String value) {
        return new ResourceFilter(t -> t.containsKey(property) &&
                Integer.parseInt(t.get(property)) > Integer.parseInt(value),
                String.format(FILTER_FORMAT, property, "is greater than", value));
    }

    @Override
    public ResourceFilter matchesWithExpression(String property, String value) {
        return new ResourceFilter(t -> t.containsKey(property) &&
                t.get(property).matches(value),
                String.format(FILTER_FORMAT, property, "matches expression", value));
    }

    @Override
    public ResourceFilter isTrue(String property) {
        return new ResourceFilter( t -> Boolean.parseBoolean(t.get(property)), String.format(FILTER_FORMAT_BOOL, property, "is true"));
    }

    @Override
    public ResourceFilter isFalse(String property) {
        return new ResourceFilter( t -> !Boolean.parseBoolean(t.get(property)), String.format(FILTER_FORMAT_BOOL, property, "is true"));
    }

    @Override
    public ResourceFilter and(ResourceFilter first, ResourceFilter second) {
        return (ResourceFilter) first.and(second);
    }

    @Override
    public ResourceFilter or(ResourceFilter first, ResourceFilter second) {
        return (ResourceFilter) first.or(second);
    }

    @Override
    public ResourceFilter not(ResourceFilter filter) {
        return (ResourceFilter) filter.not();
    }
}
