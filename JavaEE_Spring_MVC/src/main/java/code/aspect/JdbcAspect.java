package code.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class JdbcAspect {

    @Pointcut("execution(* code.service.*.*(..))")
    public void service(){}


    @Before("service()")
    public void beforeService(JoinPoint joinPoint){
        System.out.print(new Date()+":");
        System.out.println("执行的方法：" + joinPoint.getSignature());
    }


    @After("service()")
    public void afterService(){
        System.out.print(new Date()+":");
        System.out.println("方法执行完毕！");
    }


//    @Around("service()")
//    public void aroundService(ProceedingJoinPoint joinPoint){
//        Connection connection = joinPoint.
//    }


}
