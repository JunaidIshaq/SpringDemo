package com.codepractice.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

//@Aspect
public class LoggingAspect {

//    @Before("allCirleMethods()")
//    public void LoggingAdvice(JoinPoint joinPoint){
//
//    }
//
//    @AfterThrowing(pointcut = "args(name)", throwing = "ex")
//    public void exceptionAdvice(String name, RuntimeException ex){
//        System.out.println("An Exception has been Thrown ");
//        ex.printStackTrace();
//    }
//
//    @AfterReturning(pointcut = "args(name)", returning = "returnString")
//    public void stringArgumentMethods(String name, String returnString){
//        System.out.println("A method that takes String arguments has been called " + name);
//        System.out.println("The Output value is : " + returnString);
//    }

//    @Around("@annotation(com.codepractice.spring.aspect.Loggable)")
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {

        Object returnValue = null;
        try {
            System.out.println("Before advice");
          returnValue =   proceedingJoinPoint.proceed();
            System.out.println("After Returning");
        } catch (Throwable throwable) {
            System.out.println("After Throwing");
        }
        System.out.println("After Finally");
        return returnValue;
    }
//
//    @Pointcut("execution(* get*())")
//    public void allGetters(){
//    }
//
//    @Pointcut("within(com.codepractice.spring.model.Circle)")
//    public void allCirleMethods(){
//    }

    public void loggingAdvice(){
        System.out.println("Logging from the device");
    }
}
