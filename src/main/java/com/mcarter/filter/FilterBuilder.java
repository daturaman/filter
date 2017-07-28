package com.mcarter.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class FilterBuilder<T extends Filter, K, V> {

    protected Map<K, Predicate<V>> propsToMatch = new HashMap<>();

    //Filter olderThan18 = builder().where("age", isGreaterThan("18"));
    //Filter roleIsAdmin = builder().where("role").isEqualTo("administrator");
    //Filter f = olderThan18.and(roleIsAdmin).and(anotherFilter).or(yetAnotherFilter);
    //Filter f1 = builder().where("firstname", isEqualTo("Bob").and("age", isGreaterThan("15");

    public abstract Predicate<V> isEqualTo(V value);

    public abstract Predicate<V> isGreaterThan(V value);

    public FilterBuilder where(K property, Predicate<V> predicate){
        propsToMatch.put(property, predicate);
        return this;
    }

    public abstract T build();

    //T fromString();
    //toString();

}
