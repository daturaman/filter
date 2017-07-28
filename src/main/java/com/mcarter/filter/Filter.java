package com.mcarter.filter;

/**
 * A where that can be used to compare against instances of a given type T.
 *
 * @param <T> the type that this where will be used to compare against.
 */
@FunctionalInterface
public interface Filter<T> {
    boolean matches(T other);
}