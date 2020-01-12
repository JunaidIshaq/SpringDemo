package com.codepractice.spring.model;

public class Circle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Circle's setter called");
    }

    public String setNameandReturn(String name){
        this.name = name;
        System.out.println("Circle's setter method");
        return this.name;
    }
}
