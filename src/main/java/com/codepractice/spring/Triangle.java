package com.codepractice.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Iterator;
import java.util.List;

public class Triangle implements Shape{
//        implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean {

    private List<Point> points;

    private ApplicationContext applicationContext;

    public Triangle(List<Point> points) {
        this.points = points;
    }

    public Triangle() {
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public void draw(){
        Iterator<Point> iterable = points.iterator();
        System.out.println("Drawing Triangle");
        while(iterable.hasNext()){
            Point point = iterable.next();
            System.out.println("Point (" + point.getX() + ", " + point.getY()+")");
        }
    }

/*    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("Application Context Name is : "+ this.applicationContext.getApplicationName());
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("Bean Name is : "+ beanName);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("Initialization Beans init() method called for Triangle");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy() method called for Triangle");
    }*/

    public void myInit() {
        System.out.println("My init() method called for Triangle");
    }

    public void cleanUp() {
        System.out.println("My cleanUp() method called for Triangle");
    }
}
