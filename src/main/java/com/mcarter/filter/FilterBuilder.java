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
public interface FilterBuilder<T extends Filter, K, V> {

	String FILTER_FORMAT = "Filter where [property=%s, condition=%s, value=%s]";
	String FILTER_FORMAT_BOOL = "Filter where [property=%s, condition=%s]";

	/**
	 * Creates a filter which returns <code>true</code> when <code>property == value</code>.
	 *
	 * @param property name of the property that will be filtered against.
	 * @param value    value to filter against.
	 * @return a new filter.
	 */
	T isEqualTo(K property, V value);

	/**
	 * Creates a filter which returns <code>true</code> when <code>property > value</code>.
	 *
	 * @param property name of the property that will be filtered against.
	 * @param value    value to filter against.
	 * @return a new filter.
	 */
	T isGreaterThan(K property, V value);

	/**
	 * Creates a filter which returns <code>true</code> when <code>property < value</code>.
	 *
	 * @param property name of the property that will be filtered against.
	 * @param value    value to filter against.
	 * @return a new filter.
	 */
	T isLessThan(K property, V value);

	/**
	 * Creates a filter which returns <code>true</code> when <code>property</code> matches the regular expression
	 * represented by <code>value</code>.
	 *
	 * @param property name of the property that will be filtered against.
	 * @param value    regular expression to filter against.
	 * @return a new filter.
	 */
	T matchesWithExpression(K property, V value);

	/**
	 * Creates a filter which tests if the value of <code>property</code> is <code>true</code>.
	 *
	 * @param property name of the property that will be filtered against.
	 * @return a new filter.
	 */
	T isTrue(K property);

	/**
	 * Creates a filter which tests if the value of <code>property</code> is <code>false</code>.
	 *
	 * @param property name of the property that will be filtered against.
	 * @return a new filter.
	 */
	T isFalse(K property);

	/**
	 * Creates a new filter by combining two existing filters using short circuit logical AND.
	 *
	 * @param first  the first filter to combine.
	 * @param second the second filter to combine.
	 * @return a new filter by combining <code>first</code> and <code>second</code> using short circuit logical AND.
	 */
	T and(T first, T second);

	/**
	 * Creates a new filter by combining two existing filters using short circuit logical OR.
	 *
	 * @param first  the first filter to combine.
	 * @param second the second filter to combine.
	 * @return a new filter by combining <code>first</code> and <code>second</code> using short circuit logical OR.
	 */
	T or(T first, T second);

	/**
	 * Returns a new filter whose predicate is a negation of the provided filter's.
	 *
	 * @param filter filter whose predicate is to be negated.
	 * @return a new filter whose predicate is a negation of <code>filter<</code>.
	 */
	T not(T filter);
}
