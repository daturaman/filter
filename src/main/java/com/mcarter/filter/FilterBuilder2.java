/*
 * <copyright>
 *
 * Copyright (c) 2010 - 2017 Gresham Technologies plc. All rights reserved.
 *
 * </copyright>
 */
package com.mcarter.filter;

import java.util.Map;
import java.util.function.BiPredicate;

import com.google.common.collect.ImmutableMap;

/**
 * @author mcarter
 */
public interface FilterBuilder2<T,U> {

	static <T,U> Filter<T> createFilterWhere(U property, BiPredicate<T, U> predicate) {
		return resource -> predicate.test(resource,property);
	}

	BiPredicate<T,U> isGreaterThan(T resource, U property);

	BiPredicate<T, U> and(BiPredicate<T,U> other);

	public static void main(String[] args) {

		ImmutableMap<String, String> m = ImmutableMap.of("firstname", "Bob", "surname", "Smith", "role", "administrator", "age", "9", "happy", "true");

	}
}
