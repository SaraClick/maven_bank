package com.qa.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    // Test customer objects
    Customer mike = new Customer("Mike", "Doe", "2000-01-01");
    Customer anna = new Customer("Anna", "Doe", "2020-01-01");
    Customer jane = new Customer("Jane", "Doe", "2005-09-05");

    // Unittests
    @Test
    void testJaneDoe() { Assertions.assertEquals("Mike Doe", mike.getFullName());
    }

    @Test
    void testOver18_AdultOlder() {Assertions.assertEquals(true, mike.over18());}
    @Test
    void testOver18_Adult18() {Assertions.assertEquals(true, jane.over18());}
    @Test
    void testOver18_Child() {Assertions.assertEquals(false, anna.over18());}

}
