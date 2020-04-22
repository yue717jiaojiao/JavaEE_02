package code.spring;

import code.aspect.TestAspect;
import code.bean.TestBean;
import code.service.JdbcService;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

@ComponentScan("code.*")
@EnableAspectJAutoProxy
public class TestSpring {

    public static void main(String[] args){


        AnnotationConfigApplicationContext context =
               new AnnotationConfigApplicationContext(TestSpring.class);

        TestAspect testAspect = context.getBean("testAspect", TestAspect.class);

        System.out.println(testAspect.toString());

        JdbcService jdbcservice = context.getBean("jdbcService", JdbcService.class);

        jdbcservice.getById(100L);

//
//
//        context.scan("code.service.*");
//       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       //文件系统
        //ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
//     int n=1;
//     while (n-->=0){
////         TestBean service =context.getBean("testBean",TestBean.class);
//         TestBean service = (TestBean) context.getBean("testBean");
////         HikariDataSource service = (HikariDataSource) context.getBean("getHikariDataSource");
//         System.out.println(service.toString());
//
//         JdbcService jdbcservice = context.getBean("jdbcService", JdbcService.class);
//         jdbcservice.getById(100L);
//     }






    }
}
