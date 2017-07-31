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
            "Bob", ImmutableMap.of("firstname", "Bob", "surname", "Smith", "role", "administrator", "age", "31", "happy", "true"),
            "Ted", ImmutableMap.of("firstname", "Ted", "surname", "Wong", "role", "user", "age", "45", "happy", "true"),
            "Kim", ImmutableMap.of("firstname", "Kim", "surname", "Ubogo", "role", "administrator", "age", "23", "happy", "false"));

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

    @Test
    public void shouldCombineFiltersUsingAnd() {
        Filter<Map<String, String>> isAdminAndOver30 = build
                .filter()
                .where("role")
                .isEqualTo("administrator")
                .and(build
                        .filter()
                        .where("age")
                        .isGreaterThan("30"));
        assertTrue(isAdminAndOver30.matches(resources.get("Bob")));
        assertFalse(isAdminAndOver30.matches(resources.get("Ted")));
        assertFalse(isAdminAndOver30.matches(resources.get("Kim")));
    }

    @Test
    public void shouldCombineFiltersUsingOr() {
        Filter<Map<String, String>> under25orRoleIsAdmin = build
                .filter()
                .where("age")
                .isLessThan("25")
                .or(build
                        .filter()
                        .where("role")
                        .isEqualTo("user"));
        assertFalse(under25orRoleIsAdmin.matches(resources.get("Bob")));
        assertTrue(under25orRoleIsAdmin.matches(resources.get("Ted")));
        assertTrue(under25orRoleIsAdmin.matches(resources.get("Kim")));
    }

    @Test
    public void shouldFilterUsingNot() {
        Filter<Map<String, String>> notAdmin = build
                .filter()
                .where("role")
                .isEqualTo("administrator")
                .not();
        assertFalse(notAdmin.matches(resources.get("Bob")));
        assertFalse(notAdmin.matches(resources.get("Kim")));
        assertTrue(notAdmin.matches(resources.get("Ted")));
    }

    @Test
    public void filterWhereBooleanIsTrue(){
        Filter<Map<String, String>> isHappy = build.filter().where("happy").isTrue();
        assertTrue(isHappy.matches(resources.get("Bob")));
        assertTrue(isHappy.matches(resources.get("Ted")));
        assertFalse(isHappy.matches(resources.get("Kim")));
    }

    @Test
    public void filterWhereBooleanIsFalse(){
        Filter<Map<String, String>> isNotHappy = build.filter().where("happy").isFalse();
        assertFalse(isNotHappy.matches(resources.get("Bob")));
        assertFalse(isNotHappy.matches(resources.get("Ted")));
        assertTrue(isNotHappy.matches(resources.get("Kim")));
    }
}
