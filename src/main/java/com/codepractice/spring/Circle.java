package com.codepractice.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Controller
public class Circle implements Shape {

    private Point center;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void draw() {
        System.out.println(this.getMessageSource().getMessage("drawing.circle", null, "Drawing Circle", null));
        System.out.println(this.getMessageSource().getMessage("drawing.point", new Object[] {center.getX(),center.getY()}, "Default Point Message", null));
        System.out.println(this.getMessageSource().getMessage("greeting",null, "Default Greeting", null));
        DrawEvent drawEvent = new DrawEvent(this);
        publisher.publishEvent(drawEvent);
    }

    public Point getCenter() {
        return center;
    }

   @Resource
    public void setCenter(Point center) {
        this.center = center;
    }

    @PostConstruct
    public void initializeCircle(){
        System.out.println("Initializing of Circle");
    }

    @PreDestroy
    public void destroyCircle(){
        System.out.println("Destroying the Circle");
    }

}
