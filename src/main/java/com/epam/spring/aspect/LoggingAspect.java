package com.epam.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect extends PointcutStorage {

    @Before("anyCatService()")
    private void logBeforeAnyCatService() {
        System.out.println("logging before cat service");
        System.out.println();
    }

    /*@After("subjectMethodAnnotatedAsAopLoggable() || subjectClassAnnotatedAsAopLoggable()")
    private void logAfterLoggable() {
        System.out.println("logging after @Loggable");
        System.out.println();
    }*/

    /*@Around("anyJoinPointWhereExecutingMethodHasTheTransactionalAnnotation()")
    private Object logTransactionBeforeAndAfter(ProceedingJoinPoint joinPoint) throws Throwable { //pjp has to be first parameter in around advice
        System.out.println(("jointPoint.toLongString() = " + joinPoint.toLongString()));
        System.out.println(("joinPoint.getTarget() = " + joinPoint.getTarget()));
        System.out.println(("joinPoint.getThis() = " + joinPoint.getThis()));
        System.out.println(("joinPoint.getKind() = " + joinPoint.getKind()));
        System.out.println(("joinPoint.getSignature() = " + joinPoint.getSignature()));
        Object result = joinPoint.proceed(); //proceed may be called once, many times or not at all
        System.out.println(("Finished " + joinPoint.getTarget()));
        System.out.println(("result: " + result));
        System.out.println();
        return result; //return result to the caller of the original method
    }*/

    /*@AfterReturning(value = "execution(java.util.List<com.epam.spring.model.Cat> * (..))", returning = "retVal")
    private void logAfterReturningNormallyWithAccessToRetVal(JoinPoint joinPoint, Object retVal) { //use Object to retrieve any returning type, may narrow down with more restrictive type
        System.out.println("joinPoint.getTarget() = " + joinPoint.getTarget());
        System.out.println("joinPoint.getSignature() = " + joinPoint.getSignature());
        System.out.println("Returning value: " + retVal);
        System.out.println();
    }*/

    /*@AfterThrowing(value = "catControllerthrowExceptionMethod()", throwing = "e")
    public void logAfterRuntimeException(RuntimeException e) {
        System.out.println("Caught runtime exception: " + e);
    }*/

    /*===============================================================================*/

    //be wise when declaring a pointcut, make them as narrow as possible
    /*@Before("anyMethod()")
    private void method() {
        System.out.println("before anyMethod");
    }*/

    /*@Before("bean(*Service)")
    private void logBeforeAnyServiceInPlace() {}

    /*@AfterReturning("anyService()")
    private void logAfterReturningNormally() {}*/

    /*@AfterThrowing(value = "anyMethod()", throwing = "t")
    private void logEverywhereAfterThrowing(Throwable t) {

    }

    //used in both cases: normal return and upon thrown exception. typically to release resources etc.
    @After("anyPublicOperationWithOneIterableArgument()")
    private void logIterableAnyway() {

    }*/

    /*@Before(value = "saveCat() && args(cat)", argNames = "cat")
    private void logSavingCat(Cat cat) {
        log.info("Saving cat: " + cat);
    }*/
}
