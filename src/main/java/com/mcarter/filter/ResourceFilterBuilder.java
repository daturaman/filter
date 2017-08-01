package com.mcarter.filter;

/**
 * Builder for creating {@link ResourceFilter}s.
 */
public class ResourceFilterBuilder implements FilterBuilder<ResourceFilter, String, String> {

    @Override
    public ResourceFilter isEqualTo(String property, String value) {
        return new ResourceFilter(t -> t.containsKey(property) &&
                t.get(property).equals(value),
                String.format(FILTER_FORMAT, property, "[is equal to]", value));
    }

    @Override
    public ResourceFilter isLessThan(String property, String value) {
        return new ResourceFilter(t -> t.containsKey(property) &&
                Integer.parseInt(t.get(property)) < Integer.parseInt(value),
                String.format(FILTER_FORMAT, property, "[is less than]", value));
    }

    @Override
    public ResourceFilter isGreaterThan(String property, String value) {
        return new ResourceFilter(t -> t.containsKey(property) &&
                Integer.parseInt(t.get(property)) > Integer.parseInt(value),
                String.format(FILTER_FORMAT, property, "[is greater than]", value));
    }

    @Override
    public ResourceFilter matchesWithExpression(String property, String value) {
        return new ResourceFilter(t -> t.containsKey(property) &&
                t.get(property).matches(value),
                String.format(FILTER_FORMAT, property, "[matches expression]", value));
    }

    @Override
    public ResourceFilter isTrue(String property) {
        return new ResourceFilter( t -> Boolean.parseBoolean(t.get(property)), String.format(FILTER_FORMAT_BOOL, property, "[is true]"));
    }

    @Override
    public ResourceFilter isFalse(String property) {
        return new ResourceFilter( t -> !Boolean.parseBoolean(t.get(property)), String.format(FILTER_FORMAT_BOOL, property, "[is true]"));
    }

    @Override
    public ResourceFilter and(ResourceFilter first, ResourceFilter second) {
        return new ResourceFilter(t -> first.matches(t) && second.matches(t), first.getDescription() + " AND " + second.getDescription());
    }

    @Override
    public ResourceFilter or(ResourceFilter first, ResourceFilter second) {
		return new ResourceFilter(t -> first.matches(t) || second.matches(t), first.getDescription() + " OR " + second.getDescription());
    }

    @Override
    public ResourceFilter not(ResourceFilter filter) {
        return new ResourceFilter(filter.getPredicate().negate(), filter.getDescription() + " NOT ");
    }
}
