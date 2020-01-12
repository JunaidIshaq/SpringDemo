package com.codepractice.spring.service;

import com.codepractice.spring.model.Circle;
import com.codepractice.spring.model.Triangle;

public class FactoryService {

    public Object getBean(String beanType){
        if(beanType.equals("shapeService")) return new ShapeServiceProxy();
        if(beanType.equals("circle")) return new Circle();
        if(beanType.equals("triangle")) return new Triangle();
        return null;
    }
}
