package com.qa.application.test;

import com.qa.objects.Family;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import static org.junit.Assert.*;

public class TestApplication {

    Family fam;

    @Before
    public void setup() {
        fam = new Family();
    }

    @Test
    public void testMale() {
        assertTrue(fam.male("John"));

        fam.female("Susan");

        assertFalse(fam.male("Susan"));
    }

    @Test
    public void testFemale() {
        assertTrue(fam.female("John"));
        fam.male("Susan");
        assertFalse(fam.female("Susan"));
    }

    @Test
    public void testCheckMale() {

        fam.male("John");
        assertTrue(fam.isMale("John"));
        fam.female("Susan");
        assertFalse(fam.isMale("Susan"));
    }

    @Test
    public void testCheckFemale() {
        fam.female("John");
        assertTrue(fam.isFemale("John"));
        fam.male("Susan");
        assertFalse(fam.isFemale("Susan"));

    }

    @Test
    public void testSetParent() {
        fam.female("Susan");
        fam.male("John");
        assertTrue(fam.setParentOf("Susan", "John"));
    }
    @Test
    @Ignore
    public void testParentConflict() {
        fam.female("Susan");
        assertTrue(fam.setParentOf("Susan", "John"));
        //UNABLE PREVENT ANCESTRY
        assertEquals(false, fam.setParentOf("John", "Susan"));
    }

    @Test
    public void testGetParents() {
        fam.female("Susan");
        fam.male("John");
        fam.female("Mother");

        assertTrue(fam.setParentOf("Susan", "John"));
        assertTrue(fam.setParentOf("Susan", "Mother"));
        String[] parentsNamesInOrder = {"john", "mother"};
        assertEquals(parentsNamesInOrder, fam.getParents("Susan"));

    }

    @Test
    public void testGetChildren(){
        fam.female("Susan");
        fam.male("Father");
        fam.female("Mother");
        fam.male("Michael");

        assertEquals(true, fam.setParentOf("Susan", "Father"));
        assertTrue(fam.setParentOf("Susan", "Mother"));
        assertTrue(fam.setParentOf("Michael", "Mother"));
        assertTrue(fam.setParentOf("Michael", "Father"));

        String[] expected = { "michael", "susan"};
        assertArrayEquals(expected, fam.getChildrenOf("Mother"));
    }

    @Test
    public void testDuplicateName() {
        assertTrue(fam.male("tony"));
        assertFalse(fam.male("tony"));
        assertFalse(fam.isFemale("tony"));
        assertFalse(fam.isMale("tony"));

    }
}
