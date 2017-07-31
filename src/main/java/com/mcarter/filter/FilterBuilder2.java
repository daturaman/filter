/*
 * <copyright>
 *
 * Copyright (c) 2010 - 2017 Gresham Technologies plc. All rights reserved.
 *
 * </copyright>
 */
package com.mcarter.filter;

/**
 * Builder for creating filters.
 *
 * @author mcarter
 */
public interface FilterBuilder2<T extends Filter, K, V> {

    T isEqualTo(K property, V value);

    T isGreaterThan(K property, V value);

    T isLessThan(K property, V value);

    T matchesWithExpression(K property, V value);

    T isTrue(K property);

    T isFalse(K property);

    T and(T first, T second);

    T or(T first, T second);

    T not(T filter);
}
