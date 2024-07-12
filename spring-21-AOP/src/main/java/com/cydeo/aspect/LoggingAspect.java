package com.cydeo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    // We use this logger to print something on the console
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void myPoint(){}

//    @Before("myPoint()")
//    public void log(){
//        logger.info("info log.............");
//    }


    //    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void log(){
//        logger.info("info log.............");
//    }
//


    //This line defines a pointcut expression that matches the execution of any findById method within the CourseRepository
    // class in the com.cydeo.repository package. The execution(* com.cydeo.repository.CourseRepository.findById(*))
    // syntax means that it matches any return type (*), the findById method name, and any single argument (*).
//    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
//    public void courseRepositoryFindByIdbc() {
//    }
//
    // This annotation specifies that the following method should be executed before the method matched by the pointcut
    // courseRepositoryFindByIdbc().
//    @Before("courseRepositoryFindByIdbc()")
//    public void beforeCourseRepositoryFindById(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }
    //This method will be executed before the findById method in CourseRepository.
    // The JoinPoint parameter provides reflective access to both the state and the static part of the join point.
//
//    @Pointcut("within(com.cydeo.controller..*)")
//    public void anyControllerOperation() {
//    }
//
//
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    public void anyServiceOperation() {
//    }
//
//
//    @Before("anyControllerOperation() || anyControllerOperation() ")
//    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//
//
//        @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//        public void anyDeleteControllerOperation(){}
//
//
//    @Before("anyDeleteControllerOperation()")
//    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//}


//    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
//    public void loggingAnnotationPC() {
//    }

//     @Before("loggingAnnotationPC()")
//    public void beforeLoggingAnnotation(JoinPoint joinPoint){
//         logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//     }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void afterReturningGetMappingAnnotation() {
    }


//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()",returning = "result")
//    public void afterGetMappingOperation(JoinPoint joinPoint,Object result){
//    logger.info("After Returning -> Method: {}, Result: {}"
//                , joinPoint.getSignature(), joinPoint.getSignature(),result.toString());
//    }


    @AfterThrowing(pointcut = "afterReturningGetMappingAnnotation()", throwing = "exception")
    public void afterThrowingGetMappingOperation(JoinPoint joinPoint, RuntimeException exception) {
        logger.error("After Throwing -> Method: {}, Exception: {}",
                joinPoint.getSignature().toShortString(), exception.getMessage());
    }


    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
    public void loggingAnnotationPC() {
    }

    @Around("loggingAnnotationPC()")
    public Object anyLoggingAnnotationOperation(ProceedingJoinPoint proceedingJoinPoint) {

        logger.info("Before -> Method: {} - Parameter {}"
                , proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();

        }

        logger.info("After -> Method: {} - Result: {}"
                , proceedingJoinPoint.getSignature().toShortString(), result.toString());
        return result;
    }

}













