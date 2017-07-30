package com.mcarter.filter;

import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class FilterTest {

    private ResourceFilterBuilder build;
    private Map<String, Map<String, String>> resources = ImmutableMap.of(
            "Bob", ImmutableMap.of("firstname", "Bob", "surname", "Smith", "role", "administrator", "age", "31"),
            "Ted", ImmutableMap.of("firstname", "Ted", "surname", "Wong", "role", "user", "age", "45"),
            "Kim", ImmutableMap.of("firstname", "Kim", "surname", "Ubogo", "role", "administrator", "age", "23"));

    @Before
    public void setUp() {
        build = new ResourceFilterBuilder();
    }

    @Test
    public void filterWhereRoleEqualsAdministrator() {
        Filter<Map<String, String>> roleIsAdmin = build.filter().where("role").isEqualTo("administrator");
        assertTrue(roleIsAdmin.matches(resources.get("Bob")));
        assertTrue(roleIsAdmin.matches(resources.get("Kim")));
        assertFalse(roleIsAdmin.matches(resources.get("Ted")));
    }

    @Test
    public void filterWhereAgeIsGreaterThan30() {
        Filter<Map<String, String>> ageGreaterThan30 = build.filter().where("age").isGreaterThan("30");
        assertTrue(ageGreaterThan30.matches(resources.get("Bob")));
        assertTrue(ageGreaterThan30.matches(resources.get("Ted")));
        assertFalse(ageGreaterThan30.matches(resources.get("Kim")));
    }

    @Test
    public void filterWhereAgeIsLessThan25() {
        Filter<Map<String,String>> ageLessThan25 = build.filter().where("age").isLessThan("25");
        assertTrue(ageLessThan25.matches(resources.get("Kim")));
        assertFalse(ageLessThan25.matches(resources.get("Bob")));
        assertFalse(ageLessThan25.matches(resources.get("Ted")));
    }

    @Test
    public void filterWhereSurnameMatchesRegEx(){
        Filter<Map<String, String>> matchesSurnameRegEx = build.filter().where("surname").matches(".*o.*");
        assertTrue(matchesSurnameRegEx.matches(resources.get("Ted")));
        assertTrue(matchesSurnameRegEx.matches(resources.get("Kim")));
        assertFalse(matchesSurnameRegEx.matches(resources.get("Bob")));
    }
}
