/*
 * <copyright>
 *
 * Copyright (c) 2010 - 2017 Gresham Technologies plc. All rights reserved.
 *
 * </copyright>
 */
package com.mcarter.filter;

import java.util.Map;

/**
 * @author mcarter
 */
public interface Resource<K,V> {
	V getValue(K key);

	public class MapResource implements Resource<String,String> {

		private Map<String, String> resource;

		public MapResource(Map<String, String> resource){
			this.resource = resource;
		}

		@Override
		public String getValue(String key) {
			return resource.get(key);
		}
	}
}
