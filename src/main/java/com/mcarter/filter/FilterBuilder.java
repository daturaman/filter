package com.mcarter.filter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class FilterBuilder<T extends Filter, K, V> {

    protected Map<K, Predicate<V>> propsToMatch = new LinkedHashMap<>();

    @FunctionalInterface
    public interface FilterQuery<K,V> {
        PredicateQuery<V> where(K property);
    }

    public interface PredicateQuery<V> {
        BuildFilter isEqualTo(V value);
    }


    public interface BuildFilter<T> {
        Filter<T> build();
    }

    public abstract FilterQuery<K,V> filter();
}

// FilterBuilder builder
// builder.filter().where("role").isEqualTo("admin").build();
//