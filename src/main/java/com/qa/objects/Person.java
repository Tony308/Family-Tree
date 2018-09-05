package com.qa.objects;

import com.qa.enums.Gender;

import java.util.ArrayList;
import java.util.Arrays;

public class Person {

    private String name;
    private Gender gender;
    private ArrayList<Person> parents;
    private ArrayList<Person> children;
    private Person child;

    Person(String name) {
        this.name = name;
        parents = new ArrayList<>();
        children = new ArrayList<>();
    }

    String getName() {
        return name;
    }
    void addParent(Person parent) {
        this.parents.add(parent);
    }

    ArrayList<Person> getParentsList() {
        return parents;
    }

    String[] getParents() {

        String[] names = new String[parents.size()];
        int counter = 0;

        for (Person temp : parents) {
            names[counter] = temp.getName();
            counter++;
        }
        Arrays.sort(names);
        return names;
    }

    String[] getChildren() {
        String[] names = new String[children.size()];
        int counter = 0;
        for (Person temp : children) {
            names[counter] = temp.getName();
            System.out.println(temp.getName());
            counter++;
        }
        Arrays.sort(names);
        return names;
    }

    void addChildren(Person child) {
        this.children.add(child);
    }

    void setName(String name) {
        this.name = name;
    }

    Gender getGender() {
        return gender;
    }

    void setGender(Gender gender) {
        this.gender = gender;
    }


    public Person getChild() {
        return child;
    }

    public void setChild(Person child) {
        this.child = child;
    }
}
