package com.qa.application.test;

import com.qa.objects.Family;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
        assertEquals(true, fam.female("Susan"));
    }

    @Test
    @Ignore

    public void testMaleMethod() {
        assertEquals(true, fam.isMale("John"));
    }

    @Test
    @Ignore
    public void testFemaleMethod() {
        assertEquals(false, fam.isFemale("John"));
    }

/*
    @Test
    @Ignore
    public void testSetParent() {
        assertEquals(true, setParentOf("Susan", "John"));
        assertEquals(true, setParent("John", "Susan"));
    }

    @Test
    @Ignore

    public void testGetParents() {
        assertEquals("John", getParents("Susan"));
    }

    @Test
    @Ignore
    public void testGetChildren(){
        assertEquals("Susan", getChildren("John"));
    }*/
}
