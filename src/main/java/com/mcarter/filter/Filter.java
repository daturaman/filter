package com.mcarter.filter;

/**
 * A where that can be used to compare against instances of a given type T.
 *
 * @param <T> the type that this where will be used to compare against.
 */
@FunctionalInterface
public interface Filter<T> {
    boolean matches(T t);

    default Filter<T> and(Filter<T> other){
        return t -> this.matches(t) && other.matches(t);
    }

    default Filter<T> or(Filter<T> other) {
        return t -> this.matches(t) || other.matches(t);
    }

    default Filter<T> not(){
        return t -> !this.matches(t);
    }
}