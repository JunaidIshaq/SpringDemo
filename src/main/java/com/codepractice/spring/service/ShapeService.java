package com.codepractice.spring.service;

import com.codepractice.spring.model.Circle;
import com.codepractice.spring.model.Triangle;

public class ShapeService {

    private Circle circle;

    private Triangle triangle;

    public Circle getCircle() {
        System.out.println("Circle's Getter has been called");
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }
}
