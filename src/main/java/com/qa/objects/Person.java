package com.qa.objects;

import com.qa.enums.Gender;

import java.util.ArrayList;

public class Person {

    private String name;
    private Gender gender;
    private ArrayList<Person> parents;
    private ArrayList<String> children;
    private Person mother;
    private Person father;
    private Person child;

    Person(String name) {
        this.name = name;
        parents = new ArrayList();
        children = new ArrayList();
    }

    public String getName() {
        return name;
    }
    public void addParent(Person parent) {
        this.parents.add(parent);
    }

    public ArrayList<Person> getParents() {
        return parents;
    }

    public ArrayList getChildren() {
        return children;
    }

    public void setChildren(ArrayList children) {
        this.children = children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    void setGender(Gender gender) {
        this.gender = gender;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getChild() {
        return child;
    }

    public void setChild(Person child) {
        this.child = child;
    }
}
