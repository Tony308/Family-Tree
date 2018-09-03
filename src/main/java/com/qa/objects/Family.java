package com.qa.objects;

import com.qa.enums.Gender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Family {

    private Map<String, Person> family;

    public Family(){
        family = new HashMap<>();
    }

    public Person getPerson(String name){
        return family.get(name);
    }


    public boolean male(String name) {

        if (getPerson(name) == null) {
            createFreshMember(name, Gender.MALE);
            return true;
        } else if (getPerson(name).getGender().equals(Gender.FEMALE)) {
            return false;
        } else {
            getPerson(name).setGender(Gender.MALE);
            return true;
        }

    }

    public boolean female(String name) {

        if (getPerson(name) == null) {
            createFreshMember(name, Gender.FEMALE);
            return true;
        }
        if (getPerson(name).getGender().equals(Gender.MALE)) {
            return false;
        } else {
            getPerson(name).setGender(Gender.FEMALE);
            return true;
        }

    }

    public boolean isMale(String name) {
        if (getPerson(name) == null) {
            createFreshMember(name);
        }
        return (getPerson(name).getGender().equals(Gender.MALE));
    }

    public boolean isFemale(String name) {
        if (getPerson(name) == null) {
            createFreshMember(name);
        }
        return getPerson(name).getGender().equals(Gender.FEMALE);
    }

    private void createFreshMember(String name) {
            Person freshMember = new Person(name);
            family.put(name, freshMember);
    }

    private void createFreshMember(String name, Gender gender) {
        Person freshMember = new Person(name);
        freshMember.setGender(gender);
        family.put(name, freshMember);
    }
    public boolean setParentOf(String childName, String parentName) {
        if (getPerson(childName) == null){
            createFreshMember(childName);
        }
        if (getPerson(parentName) == null) {
            createFreshMember(childName);
        }


        int parentsListSize;
        parentsListSize = getPerson(childName).getParents().size();
        boolean parentGender = getPerson(parentName).getGender().equals(Gender.MALE);


        if (parentsListSize < 2 && parentGender) {
            getPerson(childName).setFather(getPerson(parentName));
            System.out.println(getPerson(childName).getFather().getName());
            getPerson(childName).addParent(getPerson(childName).getFather());
            return true;
        } else if (parentsListSize < 2 && getPerson(parentName).getGender().equals(Gender.FEMALE)) {
            getPerson(childName).setFather(getPerson(parentName));
            getPerson(childName).addParent(getPerson(parentName));
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
