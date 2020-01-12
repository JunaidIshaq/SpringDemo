package com.codepractice.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Point {
//        implements InitializingBean, DisposableBean {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /*@Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialization init() method called for Point");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy() method called for Point");
    }*/

    public void myInit() {
        System.out.println("My init() method called for Point");
    }


    public void cleanUp() {
        System.out.println("My cleanUp() method called for Point");
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
