package com.epam.spring.aspect;

import org.aspectj.lang.annotation.Pointcut;

public abstract class PointcutStorage {

    //pattern
    //execution(modifiers-pattern? return-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)

    //param-pattern
    //() - no params
    //(*) - one param of any type
    //(*,String) - two params: one of any type and one String
    //(..) - any number (zero or more) of params

    @Pointcut("execution(public void com.epam.spring.controller.rest.CatController.throwException() throws RuntimeException)")
    protected void catControllerThrowExceptionMethod() {}

    @Pointcut("execution(* *(..))")
    protected void anyMethod() {}

    @Pointcut("execution(public * *(..))")
    protected void anyPublicOperation() {}

    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    protected void anyJoinPointWhereExecutingMethodHasTheTransactionalAnnotation() {}

    @Pointcut("bean(catService*)")
    protected void anyCatService() {} //if named properly

    @Pointcut("@annotation(com.epam.spring.annotation.Loggable)")
    protected void subjectMethodAnnotatedAsAopLoggable() {}

    @Pointcut("@within(com.epam.spring.annotation.Loggable)")
    protected void subjectClassAnnotatedAsAopLoggable() {}

    /*@Pointcut("execution(public void *(..))")
    protected void anyPublicOperationWhichReturnsVoid() {}

    @Pointcut("execution(public String *(..))")
    protected void anyPublicOperationWhichReturnsString() {}

    @Pointcut("execution(public String toString())")
    protected void everyToStringCall() {}

    @Pointcut("execution(public boolean equals(Object))")
    protected void everyEqualsCall() {}*/

    /*@Pointcut("execution(* *save*(com.epam.spring.model.Cat))")
    protected void saveCat() {}*/

    /*@Pointcut("this(com.epam.spring.service.springdata.CatService)")
    protected void anyJoinPointForProxyThatImplementsCatService() {}

    @Pointcut("target(com.epam.spring.service.springdata.CatService)")
    protected void anyJoinPointForTargetObjectThatImplementsCatService() {}

    @Pointcut("target(com.epam.spring.controller.rest.CatController)")
    protected void anyJoinPointWhereTargetObjectInstanceOfCatController() {}

    //same as above, added in SpringAOP specially for beans
    @Pointcut("bean(catController)")
    protected void catControllerAsBean() {}*/

    /*@Pointcut("subjectAnnotatedAsAopLoggable() && everyToStringCall()")
    protected void subjectAnnotatedAsAopLoggableAndEveryToStringCall() {}

    @Pointcut("execution(* com.epam.spring.repository.* .*(..))")
    protected void anyMethodInRepositoryPackage() {} //none there

    @Pointcut("within(com.epam.spring.repository.* .*)")
    protected void anyJoinPointInRepositoryPackage() {} //none there

    //note second dot after epam - it makes full depth
    @Pointcut("within(com.epam..*)")
    protected void jointPointEverywhere() {}

    @Pointcut("args(Iterable)")
    protected void whereRuntimeArgumentIsIterable() {}*/

   /*@Pointcut(value = "anyPublicOperation() && args(Iterable)")
    protected void anyPublicOperationWithOneIterableArgument() {}*/

    /*@Pointcut("@target(org.springframework.transaction.annotation.Transactional)")
    protected void anyJoinPointWhereTargetObjectHasTheTransactionalAnnotation() {}*/

    /*@Pointcut("execution(* set*(..))")
    protected void nameBeginsWithSet() {}*/

}
