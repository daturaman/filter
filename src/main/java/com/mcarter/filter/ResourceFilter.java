package com.mcarter.filter;

import java.util.Map;
import java.util.function.Predicate;

/**
 * Filter for comparing resources
 */
class ResourceFilter implements Filter<Map<String, String>> {

    private Map<String, Predicate<String>> propsToMatch;

    public ResourceFilter(Map<String, Predicate<String>> propsToMatch) {
        this.propsToMatch = propsToMatch;
    }

    @Override
    public boolean matches(Map<String, String> other) {

        boolean result = false;
//        other.forEach((k, v) -> {
//            //Run predicate for each property selected for filtering
//            if(propsToMatch.containsKey(k)){
//                result = propsToMatch.get(k).test(v);
//            }
//        });
        for (Map.Entry<String, String> kvp : other.entrySet()) {
            if(propsToMatch.containsKey(kvp.getKey())){
                result = propsToMatch.get(kvp.getKey()).test(kvp.getValue());
            }
        }

        return result;
    }
}
