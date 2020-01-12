package com.codepractice.spring.service;

import com.codepractice.spring.aspect.LoggingAspect;
import com.codepractice.spring.model.Circle;

public class ShapeServiceProxy extends ShapeService {

    @Override
    public Circle getCircle() {
        new LoggingAspect().loggingAdvice();
        return super.getCircle();
    }

}
