https://docs.spring.io/spring/docs/5.1.9.RELEASE/spring-framework-reference/core.html#aop

Aspect-Oriented Programming (AOP) complements Object-Oriented Programming (OOP) by providing another way of thinking about program structure. The key unit of modularity in OOP is the class, whereas in AOP the unit of modularity is the aspect. Aspects enable the modularization of concerns such as transaction management that cut across multiple types and objects. (Such concerns are often termed crosscutting concerns in AOP literature.)

**Terminology**

* **Aspect**: a modularization of a concern that cuts across multiple classes. Transaction management is a good example of a crosscutting concern in enterprise Java applications. In Spring AOP, aspects are implemented using regular classes (the schema-based approach) or regular classes annotated with the @Aspect annotation (the @AspectJ style).
* **Join point**: a point during the execution of a program, such as the execution of a method or the handling of an exception. In Spring AOP, a join point always represents a method execution.
* **Advice**: action taken by an aspect at a particular join point. Different types of advice include "around", "before" and "after" advice. (Advice types are discussed below.) Many AOP frameworks, including Spring, model an advice as an interceptor, maintaining a chain of interceptors around the join point.
* **Pointcut**: a predicate that matches join points. Advice is associated with a pointcut expression and runs at any join point matched by the pointcut (for example, the execution of a method with a certain name). The concept of join points as matched by pointcut expressions is central to AOP, and Spring uses the AspectJ pointcut expression language by default.
* **Introduction**: declaring additional methods or fields on behalf of a type. Spring AOP allows you to introduce new interfaces (and a corresponding implementation) to any advised object. For example, you could use an introduction to make a bean implement an IsModified interface, to simplify caching. (An introduction is known as an inter-type declaration in the AspectJ community.)
* **Target** object: object being advised by one or more aspects. Also referred to as the advised object. Since Spring AOP is implemented using runtime proxies, this object will always be a proxied object.
* **AOP proxy**: an object created by the AOP framework in order to implement the aspect contracts (advise method executions and so on). In the Spring Framework, an AOP proxy will be a JDK dynamic proxy or a CGLIB proxy.
* **Weaving**: linking aspects with other application types or objects to create an advised object. This can be done at compile time (using the AspectJ compiler, for example), load time, or at runtime. Spring AOP, like other pure Java AOP frameworks, performs weaving at runtime.

**Types of advice**

* **Before advice**: Advice that executes before a join point, but which does not have the ability to prevent execution flow proceeding to the join point (unless it throws an exception).
* **After returning advice**: Advice to be executed after a join point completes normally: for example, if a method returns without throwing an exception.
* **After throwing advice**: Advice to be executed if a method exits by throwing an exception.
* **After (finally) advice**: Advice to be executed regardless of the means by which a join point exits (normal or exceptional return).
* **Around advice**: Advice that surrounds a join point such as a method invocation. This is the most powerful kind of advice. Around advice can perform custom behavior before and after the method invocation. It is also responsible for choosing whether to proceed to the join point or to shortcut the advised method execution by returning its own return value or throwing an exception.

**Supported Pointcut Designators**

Spring AOP supports the following AspectJ pointcut designators (PCD) for use in pointcut expressions:

**execution**: For matching method execution join points. This is the primary pointcut designator to use when working with Spring AOP.

**within**: Limits matching to join points within certain types (the execution of a method declared within a matching type when using Spring AOP).

**@within**: Limits matching to join points within types that have the given annotation (the execution of methods declared in types with the given annotation when using Spring AOP).

**this**: Limits matching to join points (the execution of methods when using Spring AOP) where the bean reference (Spring AOP proxy) is an instance of the given type.

**target**: Limits matching to join points (the execution of methods when using Spring AOP) where the target object (application object being proxied) is an instance of the given type.

**@target**: Limits matching to join points (the execution of methods when using Spring AOP) where the class of the executing object has an annotation of the given type.

**args**: Limits matching to join points (the execution of methods when using Spring AOP) where the arguments are instances of the given types.

**@args**: Limits matching to join points (the execution of methods when using Spring AOP) where the runtime type of the actual arguments passed have annotations of the given types.

**@annotation**: Limits matching to join points where the subject of the join point (the method being executed in Spring AOP) has the given annotation.

-----------------------------------

**Spring AOP** currently **supports only method execution join points** (advising the execution of methods on Spring beans). Field interception is not implemented, although support for field interception could be added without breaking the core Spring AOP APIs. If you need to advise field access and update join points, consider a language such as AspectJ.

Spring AOP **defaults to using standard JDK dynamic proxies** for AOP proxies. This enables any interface (or set of interfaces) to be proxied.

Spring AOP **can also use CGLIB proxies**. This is necessary to proxy classes rather than interfaces. **CGLIB is used by default if a business object does not implement an interface**. As it is good practice to program to interfaces rather than classes; business classes normally will implement one or more business interfaces. It is possible to force the use of CGLIB, in those (hopefully rare) cases where you need to advise a method that is not declared on an interface, or where you need to pass a proxied object to a method as a concrete type.

To use @AspectJ aspects in a Spring configuration you need to enable Spring support for configuring Spring AOP based on @AspectJ aspects, and autoproxying beans based on whether or not they are advised by those aspects. By autoproxying we mean that **if Spring determines that a bean is advised by one or more aspects, it will automatically generate a proxy for that bean** to intercept method invocations and ensure that advice is executed as needed.

In Spring AOP, **it is not possible to have aspects themselves be the target of advice from other aspects**. The @Aspect annotation on a class marks it as an aspect, and hence excludes it from auto-proxying.

Due to the proxy-based nature of Spring’s AOP framework, **calls within the target object are by definition not intercepted**. For JDK proxies, only public interface method calls on the proxy can be intercepted. With CGLIB, public and protected method calls on the proxy will be intercepted, and even package-visible methods if necessary. However, common interactions through proxies should always be designed through public signatures.

Note that pointcut definitions are generally matched against any intercepted method. If a pointcut is strictly meant to be public-only, even in a CGLIB proxy scenario with potential non-public interactions through proxies, it needs to be defined accordingly.