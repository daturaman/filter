package com.mcarter.filter;

import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class FilterTest {

    private ResourceFilterBuilder filter;
    private Map<String, Map<String, String>> resources = ImmutableMap.of(
            "Bob", ImmutableMap.of("firstname", "Bob", "surname", "Smith", "role", "administrator", "age", "31"),
            "Ted", ImmutableMap.of("firstname", "Ted", "surname", "Wong", "role", "user", "age", "45"),
            "Kim", ImmutableMap.of("firstname", "Kim", "surname", "Ubogo", "role", "administrator", "age", "23"));

    @Before
    public void setUp(){
        filter = new ResourceFilterBuilder();
    }

    @Test
    public void filterWhereRoleEqualsAdministrator(){
//        Filter roleIsAdmin = filter.where("role").isEqualTo("administrator").build();
//        assertTrue(roleIsAdmin.matches(resources.get("Bob")));
//        assertTrue(roleIsAdmin.matches(resources.get("Kim")));
//        assertFalse(roleIsAdmin.matches(resources.get("Ted")));
    }

//    @Test
//    public void filterWhereAgeIsGreaterThan30(){
//        Filter ageGreaterThan30 = filter.where("age", filter.isGreaterThan("30")).build();
//        assertTrue(ageGreaterThan30.matches(resources.get("Bob")));
//        assertTrue(ageGreaterThan30.matches(resources.get("Ted")));
//        assertFalse(ageGreaterThan30.matches(resources.get("Kim")));
//    }
}
