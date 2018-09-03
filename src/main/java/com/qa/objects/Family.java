package com.qa.objects;

import com.qa.enums.Gender;

import java.util.HashMap;
import java.util.Map;

public class Family {

    private Map<String, Person> family;

    public Family(){
        family = new HashMap<String, Person>();
    }

    public boolean male(String name) {

        if (family.get(name) == null) {
            System.out.println("Person doesn't exist.");
            Person freshMember = new Person(name);
            freshMember.setGender(Gender.MALE);
            family.put(name, freshMember);
            return true;
        } else if (family.get(name).getGender().equals(Gender.MALE)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean female(String name) {

        if (family.get(name) == null) {
            System.out.println("Person doesn't exist.");
            Person freshMember = new Person(name);
            family.put(name, freshMember);
            freshMember.setGender(Gender.FEMALE);
            return true;
        } else if ( family.get(name).getGender().equals(Gender.FEMALE)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isMale(String name) {
        if (family.get(name) == null) {
            Person freshMember = new Person(name);
            family.put(name, freshMember);
            return false;
        } else if (family.get(name).getGender().equals(Gender.MALE)) {
            return true;
        }
        return false;
    }

    public boolean isFemale(String name) {
        if (family.get(name) == null) {
            Person freshMember = new Person(name);
            family.put(name, freshMember);
            return false;
        } else if (family.get(name).getGender().equals(Gender.FEMALE)) {
            return true;
        }
        return false;
    }

}
