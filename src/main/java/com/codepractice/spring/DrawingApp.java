package com.codepractice.spring;

import com.codepractice.spring.service.FactoryService;
import com.codepractice.spring.service.ShapeService;

public class DrawingApp {

    public static void main(String[] args) {
       // Triangle triangle = new Triangle();
//        BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
//        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        context.registerShutdownHook();
//        for(String val : context.getBeanDefinitionNames()){
//            System.out.println(val);
//        }
//
//        ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
//        shapeService.getCircle().setName("Dummy Name ");
//        System.out.println(shapeService.getCircle());

        FactoryService factoryService = new FactoryService();
        ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");
        shapeService.getCircle();
//        System.out.println(context.getMessage("greeting",null, "Default Greeting", null));
//        System.out.println(context.getMessage("login.failure",null, "Default Greeting", null));
    }
}
