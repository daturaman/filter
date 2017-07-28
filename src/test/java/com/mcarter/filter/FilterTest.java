package com.mcarter.filter;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Map;

import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FilterTest {
    @Parameters
    public static Iterable<Map<String, String>> data() {
        return Arrays.asList(
                ImmutableMap.of("firstname", "Bob", "surname", "Smith", "role", "administrator", "age", "31"),
                ImmutableMap.of("firstname", "Ted", "surname", "Wong", "role", "administrator", "age", "45"),
                ImmutableMap.of("firstname", "Kim", "surname", "Ubogo", "role", "administrator", "age", "23"));
    }

    @Parameter()
    public Map<String, String> resource;

    @Test
    public void filterWhereAgeIsGreaterThan25() throws Exception {

    }
}
