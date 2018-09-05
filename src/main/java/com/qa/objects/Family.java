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
        boolean childExists = getPerson(childName) == null;
        boolean parentExists = getPerson(parentName) == null;

        if (childExists){
            createFreshMember(childName);
        }
        if (parentExists) {
            createFreshMember(childName);
        }

        int parentsListSize;
        parentsListSize = getPerson(childName).getParents().size();
        boolean parentIsMale = getPerson(parentName).getGender().equals(Gender.MALE);
        boolean parentIsFemale = getPerson(parentName).getGender().equals(Gender.FEMALE);

        if (parentsListSize < 2 && parentIsMale) {
            //sets father
            getPerson(childName).setFather(getPerson(parentName));
            //Add children
            getPerson(parentName).addChildren(getPerson(childName));
            //Adds
            getPerson(childName).addParent(getPerson(childName).getFather());
            return true;
        } else if (parentsListSize < 2 && parentIsFemale ) {
            //setMother
            getPerson(childName).setMother(getPerson(parentName));
            //Add children
            getPerson(parentName).addChildren(getPerson(childName));

            getPerson(childName).addParent(getPerson(parentName));
            return true;
        }
        return false;
    }

    public ArrayList getParents(String name){
        return family.get(name).getParents();
    }

    public ArrayList getChildrenOf(String name){
        return family.get(name).getChildren();
    }


}
