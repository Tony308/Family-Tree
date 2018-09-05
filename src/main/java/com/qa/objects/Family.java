package com.qa.objects;

import com.qa.enums.Gender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Family {

    private Map<String, Person> family;

    public Family(){
        family = new HashMap<>();
    }

    private Person getPerson(String name){
        return family.get(name);
    }

    public boolean male(String name) {
            if (getPerson(name) == null){
                createFreshMember(name, Gender.MALE);
                return true;
            }  else if (getPerson(name).getName().equals(name)) {
                return false;
            }

            if (getPerson(name).getGender().equals(Gender.FEMALE)) {
                return false;
            }
        getPerson(name).setGender(Gender.MALE);
        return true;
    }

    public boolean female(String name) {

        if (getPerson(name) == null) {
            createFreshMember(name, Gender.FEMALE);
            return true;
        }  else if (getPerson(name).getName().equals(name)) {
            return false;
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
        }  else if (getPerson(name).getName().equals(name)) {
            return false;
        }
        boolean noGender = getPerson(name).getGender() == null;
        return noGender || (getPerson(name).getGender().equals(Gender.MALE));
    }

    public boolean isFemale(String name) {
        if (getPerson(name) == null) {
            createFreshMember(name);
        }   else if (getPerson(name).getName().equals(name)) {
            return false;
        }
        return getPerson(name).getGender() == null || (getPerson(name).getGender().equals(Gender.FEMALE));
    }

    private void createFreshMember(String name) {
            Person freshMember = new Person(name);
            family.put(name, freshMember);
    }

    private boolean createFreshMember(String name, Gender gender) {
        String convertedName = name.toLowerCase();
        Person freshMember = new Person(convertedName);
        freshMember.setGender(gender);
        family.put(name, freshMember);
        return true;
    }

    public boolean setParentOf(String childName, String parentName) {
        boolean childNotExists = getPerson(childName) == null;
        boolean parentNotExists = getPerson(parentName) == null;

        if (childNotExists){
            createFreshMember(childName);
        }   else if (getPerson(childName).getName().equals(childName)) {
            return false;
        }
        if (parentNotExists) {
            createFreshMember(parentName);
        }   else if (getPerson(parentName).getName().equals(parentName)) {
            return false;
        }

        boolean parentIsMale = isMale(parentName);
        boolean parentIsFemale = isFemale(parentName);
        int parentsListSize;
        parentsListSize = getPerson(childName).getParents().size();

        if (parentsListSize == 1 && isFemale(getPerson(childName).getParents().get(0).getName())) {
            getPerson(parentName).setGender(Gender.MALE);
            addParentChildRelation(childName,parentName);
            return true;
        } else if (parentsListSize == 1 && isMale(getPerson(childName).getParents().get(0).getName())) {
            getPerson(parentName).setGender(Gender.FEMALE);
            addParentChildRelation(childName,parentName);
            return true;
        } else if (parentsListSize < 2 && parentIsMale) {
            addParentChildRelation(childName,parentName);
            return true;
        } else if (parentsListSize < 2 && parentIsFemale ) {
            addParentChildRelation(childName,parentName);
            return true;
        }
        return false;
    }

    private void addParentChildRelation(String childName, String parentName) {
        getPerson(childName).addParent(getPerson(parentName));
        getPerson(parentName).addChildren(getPerson(childName));
    }

    public String[] getParents(String name){
        ArrayList<Person> parentsList = getPerson(name).getParents();
        String[] names = new String[parentsList.size()];
        int counter = 0;
        for (Person temp : parentsList) {
            names[counter] = temp.getName();
            counter++;
        }
        Arrays.sort(names);
        return names;

    }

    public String[] getChildrenOf(String name){

        ArrayList<Person> childrenList = getPerson(name).getChildren();

        String[] names = new String[childrenList.size()];
        int counter = 0;
        for (Person temp : childrenList) {
            names[counter] = temp.getName();
            counter++;
        }
        Arrays.sort(names);
        return names;
    }

//    public boolean checkName(String name) {
//        if (getPerson(name).) {
//
//        }
//        return false;
//    }

}
