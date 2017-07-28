package com.mcarter.filter;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class FilterTest {

    private Map<String, Map<String, String>> resources = ImmutableMap.of(
            "Bob", ImmutableMap.of("firstname", "Bob", "surname", "Smith", "role", "administrator", "age", "31"),
            "Ted", ImmutableMap.of("firstname", "Ted", "surname", "Wong", "role", "user", "age", "45"),
            "Kim", ImmutableMap.of("firstname", "Kim", "surname", "Ubogo", "role", "administrator", "age", "23"));

    @Test
    public void filterWhereRoleEqualsAdministrator(){
        Filter roleIsAdmin = new ResourceFilterBuilder("role").isEqualTo("administrator");
        assertTrue(roleIsAdmin.matches(resources.get("Bob")));
        assertTrue(roleIsAdmin.matches(resources.get("Kim")));
        assertFalse(roleIsAdmin.matches(resources.get("Ted")));
    }

    @Test
    public void filterWhereAgeIsGreaterThan30(){
        Filter ageGreaterThan30 = new ResourceFilterBuilder("age").isGreaterThan("30");
        assertTrue(ageGreaterThan30.matches(resources.get("Bob")));
        assertTrue(ageGreaterThan30.matches(resources.get("Ted")));
        assertFalse(ageGreaterThan30.matches(resources.get("Kim")));
    }
}
