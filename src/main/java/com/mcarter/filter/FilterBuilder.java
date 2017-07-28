package com.mcarter.filter;

public interface FilterBuilder<T extends Filter, K, V> {

    //Filter olderThan18 = where().whereProperty("age").isGreaterThan("18");
    //Filter roleIsAdmin = where().whereProperty("role").is("administrator");
    //Filter f = olderThan18.and(roleIsAdmin).and(anotherFilter).or(yetAnotherFilter);

    FilterBuilder where(K property);

    T is(V value);

    T isGreaterThan(V value);

    //T fromString();
    //toString();
}
