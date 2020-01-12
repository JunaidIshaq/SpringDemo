package com.codepractice.jdbc.model;


import javax.persistence.*;

@Entity
@Table( name= "circle")
public class Circle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "name")
    private String name;


    public Circle() {
    }

    public Circle(Integer id, String name) {
        this.setId(id);
        this.setName(name);
    }

    @javax.persistence.Id
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
