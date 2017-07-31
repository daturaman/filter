package com.mcarter.filter;

/**
 * A filter that can be used to match properties of a given type T.
 *
 * @param <T> the type for this filter.
 */
public interface Filter<T> {
    /**
     * Matches this filter against a given object
     *
     * @param t the object to match against
     * @return true if there is a match for this filter
     */
    boolean matches(T t);

    default Filter<T> and(Filter<T> other) {
        return t -> this.matches(t) && other.matches(t);
    }

    default Filter<T> or(Filter<T> other) {
        return t -> this.matches(t) || other.matches(t);
    }

    default Filter<T> not() {
        return t -> !this.matches(t);
    }
}