package com.codepractice.jdbc;

import com.codepractice.jdbc.dao.HibernateDaoImpl;
import com.codepractice.jdbc.dao.JdbcDaoImpl;
import com.codepractice.jdbc.dao.SimpleJdbcDaoImpl;
import com.codepractice.jdbc.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class JdbcDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//        JdbcDaoImpl jdbcDao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
        HibernateDaoImpl hibernateDao = ctx.getBean("hibernateDaoImpl", HibernateDaoImpl.class);

        System.out.println(hibernateDao.getCircleCount());
//        Circle circle = jdbcDao.getCircle(3);
//        if(circle != null)
//        System.out.println(circle.getId() + " : " + circle.getName());
//        else
////            System.out.println("Sorry No Record");
//        List<Circle> allCircles = jdbcDao.getAllCircle();
////        System.out.println(allCircles.getString(0));
////        Iterable iterable = allCircles.keySet();
//        for(Circle c : allCircles){
//            System.out.println(c.getId() + " : " + c.getName());
//        }
//
//        System.out.println(jdbcDao.getCircleName(4));
//
//        System.out.println(jdbcDao.getCircleForId(2).getName());
//        if(jdbcDao.insertCircle(new Circle(13,"13th Circle")) == 1 ){
//            System.out.println("Insert Successfully");
//        }
//        else
//            System.out.println("Data Not Inserted");
//        System.out.println(jdbcDao.getAllCirclesList());
//        System.out.println(jdbcDao.getAllCirclesList().size());




    }
}
