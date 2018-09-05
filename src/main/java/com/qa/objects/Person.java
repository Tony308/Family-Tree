package com.qa.objects;

import com.qa.enums.Gender;

import java.util.ArrayList;

public class Person {

    private String name;
    private Gender gender;
    private ArrayList<Person> parents;
    private ArrayList<Person> children;

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

    ArrayList<Person> getParents() {
        return parents;
    }

    public ArrayList<Person> getChildren() {
        return children;
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
}
