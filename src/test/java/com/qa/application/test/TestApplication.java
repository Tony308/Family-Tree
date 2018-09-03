package com.qa.application.test;

import com.qa.objects.Family;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

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
    @Ignore
    public void testSetParent() {
        assertEquals(true, fam.setParentOf("Susan", "John"));
        assertEquals(false, fam.setParentOf("John", "Susan"));
    }

//    @Test
//    @Ignore
//    public void testGetParents() {
//        assertEquals("John", fam.getParents("Susan"));
//    }
//
//    @Test
//    @Ignore
//    public void testGetChildren(){
//        assertEquals("Susan", getChildren("John"));
//    }
}
