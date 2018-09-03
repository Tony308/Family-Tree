package com.qa.objects;

import com.qa.enums.Gender;

import java.util.HashMap;
import java.util.Map;

public class Family {

    private Map<String, Person> family;

    public Family(){
        family = new HashMap<>();
    }

    public boolean male(String name) {

        if (family.get(name) == null) {
            System.out.println("Person doesn't exist.");
            Person freshMember = new Person(name);
            freshMember.setGender(Gender.MALE);
            family.put(name, freshMember);
            return true;

        } else if (family.get(name).getGender().equals(Gender.FEMALE)) {
            return false;
        } else {
            family.get(name).setGender(Gender.MALE);
            return true;
        }

    }

    public boolean female(String name) {

        if (family.get(name) == null) {
            System.out.println("Person doesn't exist.");
            Person freshMember = new Person(name);
            freshMember.setGender(Gender.FEMALE);
            family.put(name, freshMember);

            return true;

        } else if (family.get(name).getGender().equals(Gender.MALE)) {
            return false;
        } else {
            family.get(name).setGender(Gender.FEMALE);
            return true;
        }

    }

    public boolean isMale(String name) {
        if (family.get(name) == null) {
            createFreshMemeber(name);
        }
        return (family.get(name).getGender().equals(Gender.MALE));
    }

    public boolean isFemale(String name) {
        if (family.get(name) == null) {
            createFreshMemeber(name);
        }
        return family.get(name).getGender().equals(Gender.FEMALE);
    }

    public void createFreshMemeber(String name) {
        Person freshMember = new Person(name);
        family.put(name, freshMember);
    }

    public boolean setParentOf(String child, String parent) {
        if (family.get(child) == null){
            createFreshMemeber(child);
        }
        if (family.get(parent) == null) {
            createFreshMemeber(child);
        }

        if (family.get(child).getParents().size() == 0 && family.get(parent).getGender() == Gender.MALE) {
            family.get(child).setFather(family.get(parent));
            family.get(child).addParent(family.get(child).getFather());
            return true;
        } else if (family.get(child).getParents().size() > 0 && family.get(child).getParents().size() < 2) {
            family.get(child).addParent(family.get(parent));
            return true;
        }
        return false;
    }

//    public Array getParents(String name){
//
//    }
//
//    public Array getChildren(String name){
//
//    }


}
