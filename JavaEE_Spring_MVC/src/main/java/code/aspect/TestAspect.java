package code.aspect;

/*
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    @Pointcut("execution(* code.service.*.*(..))")
    public void service(){}

    @Before("service()")
    public void beforeService(){
        System.out.println("beforeService");
    }

    @After("service()")
    public void afterService(){
        System.out.println("afterService");
    }

    @Around("service()")
    public Object aroundService(ProceedingJoinPoint jp){
        Object object =null;
        try{
            System.out.println("before around service");
            //joinpoint
            object = jp.proceed();
            //日志输出，请求参数，相应记录
            System.out.println("after around service" + object);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object;
    }
}
*/
