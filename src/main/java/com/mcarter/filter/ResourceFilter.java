package com.mcarter.filter;

import java.util.Map;
import java.util.function.Predicate;

/**
 * A filter for resources.
 */
public class ResourceFilter implements Filter<Map<String, String>> {

	private final Predicate<Map<String, String>> predicate;
	private final String description;

	/**
	 * Creates a new filter with the provided predicate and description.
	 *
	 * @param predicate   a {@link Predicate} that determines the behaviour of this filter.
	 * @param description a parseable description of this filter.
	 */
	public ResourceFilter(Predicate<Map<String, String>> predicate, String description) {
		this.predicate = predicate;
		this.description = description;
	}

	/**
	 * @see Filter#matches(Object)
	 */
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

	/**
	 * Returns a parsable description of this filter.
	 *
	 * @return a string representation of this filter that can be parsed to create another ResourceFilter.
	 */
	@Override
	public String toString() {
		return description;
	}

	/**
	 * Parses a string representation of a filter.
	 *
	 * @param filterDescription a string in the correct format to define a filter.
	 * @return the {@link ResourceFilter} represented by the string argument.
	 */
	public static ResourceFilter parseFilter(String filterDescription) {
		throw new UnsupportedOperationException("TBD");
	}
}
