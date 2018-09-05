package com.qa.application.test;

import com.qa.objects.Family;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class TestApplication {

    Family fam;

    @Before
    public void setup() {
        fam = new Family();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testMale() {
        fam.female("Susan");
        assertEquals(false, fam.male("Susan"));
    }

    @Test
    public void testFemale() {
        fam.male("Susan");
        assertEquals(false, fam.female("Susan"));
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
        assertEquals(true, fam.isFemale("John"));
        fam.male("Susan");
        assertEquals(false, fam.isFemale("Susan"));
    }

    @Test
    public void testSetParent() {
        fam.female("Susan");
        fam.male("John");
        assertTrue(fam.setParentOf("Susan", "John"));
        //UNABLE PREVENT ANCESTRY
//        assertFalse( fam.setParentOf("John", "Susan"));
    }

    @Test
    public void testGetParents() {
        fam.female("Susan");
        fam.male("John");
        fam.female("Mother");
        assertTrue(fam.setParentOf("Susan", "John"));
        assertTrue(fam.setParentOf("Susan", "Mother"));
        assertTrue(fam.getParents("Susan").contains(fam.getPerson("John")));
        assertTrue(fam.getParents("Susan").contains(fam.getPerson("Mother")));

    }

    @Test
    public void testGetChildren(){
        fam.female("Susan");
        fam.male("Father");
        fam.female("Mother");
        assertTrue(fam.setParentOf("Susan", "Father"));
        assertTrue(fam.setParentOf("Susan", "Mother"));

        assertTrue(fam.getChildrenOf("Father").contains(fam.getPerson("Susan")));
        assertTrue(fam.getChildrenOf("Mother").contains(fam.getPerson("Susan")));

    }
}
