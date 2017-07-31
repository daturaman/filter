package com.mcarter.filter;

/**
 * Builder for creating Filters of a given type. Uses the fluent interface pattern to provide a DSL
 * for creating filters, the structure of which is enforced by nesting interfaces.
 *
 * @param <T> The type whose properties will be filtered.
 * @param <K> Type of the property to be filtered.
 * @param <V> Type of the property value.
 */
public abstract class FilterBuilder<T, K, V> {

    @FunctionalInterface
    public interface FilterQuery<T, K, V> {
        PredicateQuery<T, V> where(K property);
    }

    public interface PredicateQuery<T, V> {
        Filter<T> isEqualTo(V value);

        Filter<T> isGreaterThan(V value);

        Filter<T> isLessThan(V value);

        Filter<T> matches(V value);

        Filter<T> isTrue();

        Filter<T> isFalse();
    }

    public abstract FilterQuery<T, K, V> filter();
}