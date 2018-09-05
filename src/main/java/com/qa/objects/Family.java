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

        return getPerson(name).getGender() == null;
    }

    public boolean isFemale(String name) {
        if (getPerson(name) == null) {
            createFreshMember(name);
        }

        return getPerson(name).getGender() == null;
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

        boolean parentIsMale = isMale(parentName);
        boolean parentIsFemale = isFemale(parentName);
        int parentsListSize;
        parentsListSize = getPerson(childName).getParents().size();

//        for (int x = 0; x < getPerson(parentName).getChildren().size();x ++) {
//            if (getPerson(parentName).getChildren().get(x).equals(getPerson(parentName))) {
//                return false;
//            } else if (getPerson(childName).getParents().get(x).equals(getPerson(childName))) {
//                return false;
//            }
//        }

        if (parentsListSize == 1 && isFemale(getPerson(childName).getParents().get(0).getName())) {
            getPerson(parentName).setGender(Gender.MALE);
            getPerson(childName).addParent(getPerson(parentName));
            getPerson(parentName).addChildren(getPerson(childName));
            return true;
        }

        if (parentsListSize == 1 && isMale(getPerson(childName).getParents().get(0).getName())) {
            getPerson(parentName).setGender(Gender.FEMALE);
            getPerson(childName).addParent(getPerson(parentName));
            getPerson(parentName).addChildren(getPerson(childName));
            return true;
        }


        if (parentsListSize < 2 && parentIsMale) {
            getPerson(childName).addParent(getPerson(parentName));
            getPerson(parentName).addChildren(getPerson(childName));
            return true;
        } else if (parentsListSize < 2 && parentIsFemale ) {
            getPerson(childName).addParent(getPerson(parentName));
            getPerson(parentName).addChildren(getPerson(childName));
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
