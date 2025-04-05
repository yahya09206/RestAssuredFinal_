package com.yahya.day3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class HamcrestMatcherExampleTest {

    /**
     * Hamcrest is a framework for writing matcher objects allowing match rules
     * to be defined declaratively
     * It is an assertion library that can be used additionally to make assertions
     * readable, and it comes with a lot of pre-written matchers to make it easier to write and read
     *
     */

    @Test
    public void testNumbers(){

        // Junit5 assertion
        assertEquals(9, 3 + 6);

        // Hamcrest reads more like human language
        assertThat(3 + 6, equalTo(9));

        // Hamcrest uses matches to express the intention clearly
        // for equality, there are options like
        /**
         * equalTo(some value)
         * is(some value)
         * is(equalTo(someValue) // just for readability
         */
        assertThat(4+6, is(10));
        assertThat(5+6, is(greaterThan(10)));
        assertThat(10+10, is(lessThanOrEqualTo(20)));
    }

    @Test
    public void testString(){

        String msg = "B23 is excellent";

        assertThat(msg, is("B23 is excellent"));
        assertThat(msg, equalTo("B23 is excellent"));
        assertThat(msg, startsWith("B23"));


    }
}
